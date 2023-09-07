package model;
import java.util.Random;
import util.Collections;
import util.DoubleLinkedList;

public class Board {
    private int colum;
    public int row;
    private Collections board;
    private Random rd;

    public Board(int colum, int row){
        this.colum = colum;
        this.row = row;
        rd = new Random();
    }


    public void initBoard() {

    }



}
