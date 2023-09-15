package model;

/**
 * The Game class represents a game.
 */
public class Game{
    private Board board;
    private Player player;
    private long startTime;

    /* The `public Game()` is a constructor for the `Game` class. It is used to create a new instance
    * of the `Game` object. In this case, the constructor does not have any parameters and does not
    * perform any specific actions.
    */
    public Game(){
    }

    /**
     * The function initializes a game by creating a new board and player, and returns a string
     * representation of the board.
     * 
     * @param name The name of the player who is starting the game.
     * @return The method is returning the generated board print as a String.
     */
    public String initGame(String name){
        this.board = null;
        this.board = new Board(8, 8);
        this.player = null;
        this.player = new Player(name);
        startTime = System.currentTimeMillis();
        return board.generateBoardPrint();
    }

    /**
     * The function takes a pipe, x and y coordinates, changes the pipe at that position on the board,
     * and returns the updated board as a string.
     * 
     * @param pipe The "pipe" parameter is a string that represents the type of pipe to be placed on
     * the board.
     * @param x The x parameter represents the row index of the pipe on the board. It indicates the
     * vertical position of the pipe on the board.
     * @param y The y parameter represents the row index of the pipe on the board.
     * @return The method is returning a String value.
     */
    public String putPipe(String pipe, int x, int y){
        String out;
        board.changePipe(x, y, pipe);
        out = board.generateBoardPrint();
        return out;
    }

    /**
     * The function evaluates if the pipes on the board are valid and returns a corresponding message.
     * 
     * @return The method evaluatePipe() returns a String value.
     */
    public String evaluatePipe(){
        String out;
        if(board.validationPipes()){
            out = "funciona";
        }else{
            out = "No funciona";
        }
        return out;
    }

    /**
     * The function returns a string representation of the board.
     * 
     * @return The method is returning a string representation of the board.
     */
    public String genereteBoardPrint(){
        return board.generateBoardPrint();
    }

    /**
     * The function checks if the pipe system on the board is working.
     * 
     * @return The method is returning a boolean value.
     */
    public boolean isWorkingPipeSystem(){
        return board.validationPipes();
    }

    /**
     * The function "finishMatch" checks if the board is valid and returns the player's match if it is,
     * otherwise it returns "No funciona".
     * 
     * @return The method is returning a String.
     */
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

    /**
     * The function calculates a match score based on the number of used pipes and the time elapsed.
     * 
     * @return The method is returning a double value, which is the calculated score.
     */
    public double calculateMatch(){
        //Puntos = (100 - tuberiasUsadas) * 10 - tiempoEnSegundos
        double score = (100 - board.usedPipes()) * 10 - (System.currentTimeMillis()-startTime);
        return score;
    }

    /**
     * The function returns the player object.
     * 
     * @return The method is returning an object of type Player.
     */
    public Player getPlayer(){
        return player;
    }
}