package model;
import java.util.Random;
import util.Collections;
import util.DoubleLinkedList;
import util.NodeDouble;

public class Board {

    private int colum;
    public int row;
    public int finaL;
    public int init;
    private Collections board;
    private Random rd;


    public Board(int colum, int row){
        this.colum = colum;
        this.row = row;
        rd = new Random();
        initBoard();
    }

    public int getColum() {
        return colum;
    }

    public int getRow() {
        return row;
    }

    public Collections getBoard() {
        return board;
    }

    private void initBoard(){
        board= new DoubleLinkedList();
        int amountNode= colum*row;
        board = addPipe(amountNode, board);
        generateRandomSourceAndDrain(0,0,0,0);
    }


    private Collections addPipe(int counter, Collections board){
      Collections result;
      if(counter==0){
          result = board;
      }else{
          Pipe pipe = new Pipe();
          pipe.setPosition( Math.abs(colum*row-counter));
          board.add(pipe);
          result = addPipe(counter-1, board);
      }
      return result;
    }

    public void generateRandomSourceAndDrain(int rowSource, int columSource, int rowDrain, int columDrain){
        if(!(Math.abs(rowSource-rowDrain)+Math.abs(columSource-columDrain) < 4)) {
            int PositionSource = this.colum*(columSource-1)+rowSource-1;
            int PositionDrain = this.colum*(columDrain-1)+rowDrain-1;
            //Añado las posiciones de las tuberias
            //y la fuente es el primero
            PositionDrain=8;
            PositionSource=35;
            this.init=PositionSource;
            this.finaL=PositionDrain;
            Pipe source = (Pipe) (((DoubleLinkedList) board).get(PositionSource)).getContent();
            Pipe drain = (Pipe) (((DoubleLinkedList) board).get(PositionDrain)).getContent();
            source.setContent("F");
            drain.setContent("D");

        }else {

            rowSource = rd.nextInt(row)+1;
            columSource = rd.nextInt(colum)+1;
            rowDrain = rd.nextInt(row)+1;
            columDrain = rd.nextInt(colum)+1;
            generateRandomSourceAndDrain(rowSource, columSource, rowDrain, columDrain);
        }
    }

    public void changePipe(int row, int colum, String pipe){
        int position = this.colum*(colum)+row;
        Pipe pipe1 = (Pipe) (((DoubleLinkedList) board).get(position)).getContent();
        pipe1.setContent(pipe);
    }



    public boolean validationPipes(){
        boolean result=false;
        int posCurrent=this.init;
        Pipe current=(Pipe)((DoubleLinkedList) board).get(init).getContent();
        Pipe aux=new Pipe();
        result=validationPipesRecursively(posCurrent,true,aux,current);
        return result;
    }

    private boolean validationPipesRecursively(int posCurrent, boolean following,Pipe last, Pipe current) {
        boolean result;
        int pos=-1;
        if (posCurrent == finaL) {
            result = true;

        } else {

            Pipe pipeDown= (Pipe)((DoubleLinkedList) board).get(posCurrent+this.colum).getContent();
            Pipe pipeUp=(Pipe)((DoubleLinkedList) board).get(posCurrent-this.colum).getContent();
            Pipe pipeRigh=(Pipe)((DoubleLinkedList) board).get(posCurrent+1).getContent();
            Pipe pipeLeft=(Pipe)((DoubleLinkedList) board).get(posCurrent-1).getContent();

            boolean pipeNextRight= pipeNextIsRightOrLeft(current,pipeRigh,last);
            boolean pipeNextLeft= pipeNextIsRightOrLeft(current,pipeLeft,last);
            boolean pipeNextUp= pipeNextIsUpOrDown(current,pipeUp,last);
            boolean pipeNextDown= pipeNextIsUpOrDown(current,pipeDown,last);

            //Exclusive disjunction is used because there can only be one case
            boolean exclusiveDisjuction;
            boolean conjuction=!(pipeNextLeft && pipeNextUp && pipeNextDown && pipeNextRight);
            boolean disjuction=pipeNextLeft || pipeNextUp || pipeNextDown || pipeNextRight;
            exclusiveDisjuction=conjuction && disjuction;

            //This case, for the source you must have a horizontal or vertical tube
            if (exclusiveDisjuction) {
                if (pipeNextRight){
                    pos=posCurrent+1;
                    last=current;
                    current=pipeRigh;
                } else if (pipeNextLeft) {
                    pos = posCurrent - 1;
                    last = current;
                    current = pipeLeft;
                }else if(pipeNextUp) {
                    pos = posCurrent - this.colum;
                    last = current;
                    current = pipeUp;
                }else if(pipeNextDown) {
                    pos = posCurrent + this.colum;
                    last = current;
                    current = pipeDown;
                }
                following = true;
                result = validationPipesRecursively(pos, following, last, current);

            } else {
                result = false;
            }

        }

        return result;
    }
    public boolean pipeNextIsRightOrLeft(Pipe current, Pipe next,Pipe last){
        boolean value=false;

        if ((next.getType().equals(PipeType.HORIZONTAL) || next.getType().equals(PipeType.D)) && !next.equals(last) && !next.equals(current)) {
            if (current.getType().equals(PipeType.HORIZONTAL) || current.getType().equals(PipeType.F)) {
                 value = true;
            } else if (current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.VERTICAL) && !next.getType().equals(PipeType.D)) {
                value = true;
            }
        }else if(next.getType().equals(PipeType.ELBOW) && !next.equals(last) && !current.getType().equals(PipeType.F) && !current.getType().equals(PipeType.ELBOW)) {
            value = true;
        }
        return value;

    }



    private boolean pipeNextIsUpOrDown(Pipe current, Pipe next,Pipe last){

        boolean value=false;
        if ((next.getType().equals(PipeType.VERTICAL) ||next.getType().equals(PipeType.D) && !next.equals(last) && !next.equals(current))) {
            if (current.getType().equals(PipeType.VERTICAL) || current.getType().equals(PipeType.F)) {
                value = true;
            } else if (current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.HORIZONTAL) && !next.getType().equals(PipeType.D)) {
                value = true;
            }
        }else if(next.getType().equals(PipeType.ELBOW) && !next.equals(last) && !current.getType().equals(PipeType.F)&& !current.getType().equals(PipeType.ELBOW)) {
            value = true;
        }
        return value;
    }

    public String generateBoardPrint() {
        return generateBoardPrintRecursively(0, 0,"");
    }

    public String generateBoardPrintRecursively(int i, int j, String out) {
        String result;
        if (i >= colum) {
            result= out;
        } else if (j >= row) {
            result = generateBoardPrintRecursively(i + 1, 0, out + "\n");
        } else {
            int position = colum * i + j;
            Pipe pipe = (Pipe) ((DoubleLinkedList) board).get(position).getContent();
            result= generateBoardPrintRecursively(i, j + 1, out + pipe.getContent() + " ");
        }
        return result;
    }







}
