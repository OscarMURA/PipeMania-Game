package model;

import java.util.Random;
import util.Collections;
import util.DoubleLinkedList;

public class Board {
    private int colum;
    public int row;
    private Collections board;
    private Random rd;

    public Board(int colum, int row) {
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

    private void initBoard() {
        board = new DoubleLinkedList();
        int amountNode = colum * row;
        board = addPipe(amountNode, board);
        generateRandomSourceAndDrain(0, 0, 0, 0);
    }

    private Collections addPipe(int counter, Collections board) {
        Collections result;
        if (counter == 0) {
            result = board;
        } else {
            Pipe pipe = new Pipe();
            board.add(pipe);
            result = addPipe(counter - 1, board);
        }
        return result;
    }

    public void generateRandomSourceAndDrain(int rowSource, int columSource, int rowDrain, int columDrain) {
        if (!(Math.abs(rowSource - rowDrain) + Math.abs(columSource - columDrain) < 4)) {
            int PositionSource = this.colum * (columSource - 1) + rowSource - 1;
            int PositionDrain = this.colum * (columDrain - 1) + rowDrain - 1;
            Pipe source = (Pipe) (((DoubleLinkedList) board).get(PositionSource)).getContent();
            Pipe drain = (Pipe) (((DoubleLinkedList) board).get(PositionDrain)).getContent();
            source.setContent("F");
            drain.setContent("D");

        } else {

            rowSource = rd.nextInt(row) + 1;
            columSource = rd.nextInt(colum) + 1;
            rowDrain = rd.nextInt(row) + 1;
            columDrain = rd.nextInt(colum) + 1;
            generateRandomSourceAndDrain(rowSource, columSource, rowDrain, columDrain);
        }
    }

    public void changePipe(int row, int colum, String pipe) {

        int position = this.colum * (colum) + row;
        Pipe pipe1 = (Pipe) (((DoubleLinkedList) board).get(position)).getContent();
        pipe1.setContent(pipe);
    }

    public String genereteBoardPrint() {
        StringBuilder out = new StringBuilder();
        String cellFormat = "%-3s"; // Formato de celda con un ancho de 3 caracteres

        for (int i = 0; i < colum; i++) {
            for (int j = 0; j < row; j++) {
                int position = this.colum * (i) + j;
                Pipe pipe = (Pipe) (((DoubleLinkedList) board).get(position)).getContent();
                String cellContent = pipe.getContent();
                String formattedCell = String.format(cellFormat, cellContent);
                out.append(formattedCell);
            }
            out.append("\n");
        }
        return out.toString();
    }

}
