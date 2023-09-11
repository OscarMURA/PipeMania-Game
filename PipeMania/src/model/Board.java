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
          pipe.setVisited(false);
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
            PositionSource=4;
            PositionDrain=24;
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
        NodeDouble currentNode=((DoubleLinkedList) board).get(init);

        Pipe current=(Pipe) currentNode.getContent();
        Pipe aux=new Pipe();
        aux.setVisited(true);
        current.setVisited(true);
        result=validationPipesRecursively(posCurrent,aux,current, currentNode);
        return result;
    }


    private boolean validationPipesRecursively(int posCurrent,Pipe last, Pipe current, NodeDouble currentNode) {
        boolean result;
        int pos=-1;
        if (posCurrent == finaL) {
            result = true;

        } else {

            boolean pipeNextDown = false, pipeNextUp = false, pipeNextRight = false, pipeNextLeft = false;
            Pipe pipeDown = null, pipeUp = null, pipeRigh = null, pipeLeft = null;
            int posDown = posCurrent + colum, posUp = posCurrent - colum, posRight = posCurrent + 1, posLeft = posCurrent - 1;

            if (posDown < colum * row) {//No se sale de abajo del tablero
                pipeDown = (Pipe) ((DoubleLinkedList) board).get(posDown).getContent();
                pipeNextDown = pipeNextIsUpOrDown( last,current, pipeDown);
                System.out.println("pipeNextDown: "+pipeNextDown);
            }
            if(posUp>=0){//No sobrepasa el limite superior
                pipeUp = (Pipe) ((DoubleLinkedList) board).get(posUp).getContent();
                pipeNextUp = pipeNextIsUpOrDown(last, current, pipeUp);
                System.out.println("pipeNextUp: "+pipeNextUp);
            }
            if(posLeft%colum!=0){//No sobrepasa el limite izquierdo
                pipeLeft = (Pipe) currentNode.getPrev().getContent();
                pipeNextLeft = pipeNextIsRightOrLeft(last, current, pipeLeft );
                System.out.println("pipeNextLeft: "+pipeNextLeft);
            }
            if((posRight+1)%colum!=0){//No sobrepasa el limite derecho
                pipeRigh = (Pipe) currentNode.getNext().getContent();
                pipeNextRight = pipeNextIsRightOrLeft(last, current, pipeRigh );
                System.out.println("pipeNextRight: "+pipeNextRight);
            }

            if(pipeNextDown ^ pipeNextUp ^ pipeNextRight ^ pipeNextLeft){
                System.out.println("entre al exclusivo");
                if(pipeNextDown) {
                    pos = posDown;
                    currentNode=((DoubleLinkedList) board).get(posDown);
                    last=current;
                    current=pipeDown;

                }else if(pipeNextUp) {
                    pos = posUp;
                    currentNode=((DoubleLinkedList) board).get(posUp);
                    last=current;
                    current=pipeUp;

                }else if(pipeNextRight) {
                    pos = posRight;
                    currentNode=currentNode.getNext();
                    last=current;
                    current=pipeRigh;

                } else {
                    pos = posLeft;
                    currentNode=currentNode.getPrev();
                    last=current;
                    current=pipeLeft;

                }
                current.setVisited(true);
                result=validationPipesRecursively(pos,last,current,currentNode);

            }else {

                result = false;
                resetVisit(0,0);
            }

        }

        return result;
    }



    public boolean pipeNextIsRightOrLeft(Pipe last, Pipe current, Pipe next){
        boolean value=false;
        if( (next.getType().equals(PipeType.HORIZONTAL) || next.getType().equals(PipeType.D)) && !next.isVisited() ){

            if(current.getType().equals(PipeType.HORIZONTAL) || current.getType().equals(PipeType.F))
                value=true;
            else if(current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.VERTICAL))
                value = true;

        }else if(next.getType().equals(PipeType.ELBOW) && !next.isVisited()){
            value=true;
        }

        return value;

    }



    private boolean pipeNextIsUpOrDown(Pipe last, Pipe current, Pipe next){

        boolean value=false;

        System.out.println("next: "+next.getType());
        if( (next.getType().equals(PipeType.VERTICAL) || next.getType().equals(PipeType.D)) && !next.isVisited() ) {
            System.out.println("Entro en el if 1");
            System.out.println("Current: "+current.getType());
            System.out.println("next: "+next.getType());
            if (current.getType().equals(PipeType.VERTICAL) || current.getType().equals(PipeType.F)) {
                value = true;
                System.out.println("\n-Entro en el if 2-");
            }
            else if (current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.HORIZONTAL))
                value = true;

        }else if(next.getType().equals(PipeType.ELBOW) && !next.isVisited()){
            value=true;
        }

        return value;
    }

    public String generateBoardPrint() {
        return generateBoardPrintRecursively(0, 0,"");
    }

    private String generateBoardPrintRecursively(int i, int j, String out) {
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

    private void resetVisit(int i, int j ){
        if (i >= colum) {
            //sale
        } else if (j >= row) {
            resetVisit(i + 1, 0);
        } else {
            int position = colum * i + j;
            Pipe pipe = (Pipe) ((DoubleLinkedList) board).get(position).getContent();
            pipe.setVisited(false);
            resetVisit(i, j + 1);
        }


    }


}
