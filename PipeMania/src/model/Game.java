package model;

public class Game{
    private Board board;
    private Player player;
    private long startTime;

    public Game(){
    }

    public String initGame(String name){
        this.board = null;
        this.board = new Board(8, 8);
        this.player = null;
        this.player = new Player(name);
        startTime = System.currentTimeMillis();
        return board.genereteBoardPrint();
    }

    public String putPipe(String pipe, int x, int y){
        String out;
        board.changePipe(x, y, pipe);
        out = board.genereteBoardPrint();
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

    public String genereteBoardPrint(){
        return board.genereteBoardPrint();
    }

    /*
    public boolean evaluatePipe(){
        return board.evaluatePipe();
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

    public Player getPlayer(){
        return player;
    }
}