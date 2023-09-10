package model;
import java.util.Random;
import util.Collections;
import util.DoubleLinkedList;

public class Board {
    private int colum;
    public int row;
    private Collections board;
    private Random rd;
    private Collections pipesPos;


    public Board(int colum, int row){
        this.colum = colum;
        this.row = row;
        rd = new Random();
        pipesPos= new DoubleLinkedList();
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
            pipesPos.add(PositionSource);

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

    public void validatePosCorrectPipeFromBoard(int position, Pipe pipe){
        //Boolean to validate that the position is valid
        boolean pipeNextRight,pipeNextLeft,pipeNextUp,pipeNextDown;

        int posDown=(Integer) (((DoubleLinkedList) pipesPos).getLast()).getContent();
        //Compare the position with the position of the last pipe added
        pipeNextRight=(position==posDown+1);
        pipeNextLeft=(position==posDown-1);
        pipeNextUp=(position==posDown-this.colum);
        pipeNextDown=(position==posDown+this.colum);
        //If a case is true, the pipe is added to the board
        Pipe pipePrev= (Pipe) (((DoubleLinkedList) board).get(position)).getContent();

        if(pipeNextRight || pipeNextLeft){
            if((pipePrev.getType().equals(TypePipe.HORIZONTAL) || pipePrev.getType().equals(TypePipe.HORIZONTAL))
                    && pipe.getType().equals(TypePipe.HORIZONTAL)) {
                pipesPos.add(position);

            }
        }else if(pipeNextUp || pipeNextDown){
            if((pipePrev.getType().equals(TypePipe.VERTICAL) || pipePrev.getType().equals(TypePipe.VERTICAL))
                    && pipe.getType().equals(TypePipe.VERTICAL)) {
                pipesPos.add(position);
            }
        }









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
