package model;

import util.BST;
import java.util.Calendar;

public class ControllerMain{

    private BST<Player> playersBST;
    private Board board;
    private Player actualPlayer;
    private long startTime;

    public ControllerMain(){
        this.playersBST = new BST<Player>();
    }

    public String initGame(String name){
        this.board = null;
        this.board = new Board(8, 8);
        this.actualPlayer = null;
        this.actualPlayer = new Player(name);
        startTime = System.currentTimeMillis();
        return board.genereteBoardPrint();
    }

    public String putPipe(String pipe, int x, int y){
        String out;
        if(x>7 || x<0 || y>7 || y<0){
            out = "\n" + "No se pudo, indice invalido";
        }else if(!pipe.equals("||") && !pipe.equals("=") && !pipe.equals("o")){
            out = "Invalida opcion de tubería";
        }else{
            board.changePipe(x, y, pipe);
            out = board.genereteBoardPrint();
        }
        return out;
    }

    /*public String evaluatePipe(){
        String out;
        if(board.evaluatePipe()){
            out = "funciona";
        }else{
            out = "No funciona";
        }
        return out;
    }*/

    /*public String finishMatch(){
        String out;
        if(board.evaluatePipe()){
            actualPlayer.setMatch(board.genereteBoardPrint());
            actualPlayer.setScore(calculateMatch);
            out = actualPlayer.toString();
        }else{
            out = "No funciona";
        }
        return out;
    }*/

    /*public double calculateMatch(){
        int score = (100 - board.usedPipes()) * 10 - (System.currentTimeMillis()-startTime);
        return score;
    }*/

}