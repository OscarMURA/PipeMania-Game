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
        return board.generateBoardPrint();
    }

    public String putPipe(String pipe, int x, int y){
        String out;
        board.changePipe(x, y, pipe);
        out = board.generateBoardPrint();
        return out;
    }

    public String evaluatePipe(){
        String out;
        if(board.validationPipes()){
            out = "funciona";
        }else{
            out = "No funciona";
        }
        return out;
    }

    public String genereteBoardPrint(){
        return board.generateBoardPrint();
    }

    public boolean isWorkingPipeSystem(){
        return board.validationPipes();
    }

    public String finishMatch(){
        String out;
        if(board.validationPipes()){
            player.setMatch(board.generateBoardPrint());
            //player.setScore(calculateMatch());
            out = player.toString();
        }else{
            out = "No funciona";
        }
        return out;
    }

    /*public double calculateMatch(){
        //Puntos = (100 - tuberiasUsadas) * 10 - tiempoEnSegundos
        double score = (100 - board.usedPipes()) * 10 - (System.currentTimeMillis()-startTime);
        return score;
    }*/

    public Player getPlayer(){
        return player;
    }
}