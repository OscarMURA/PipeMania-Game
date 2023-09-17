
package model;

import util.BST;

/**
 * The ControllerMain class is responsible for managing the game and interacting
 * with the user.
 */
public class ControllerMain {

    /**
     * The line `private BST<Player> playersBST;` is declaring a private instance
     * variable `playersBST`
     * /* of type `BST<Player>
     */
    private BST<Player> playersBST;
    /**
     * The line `private Game game;` is declaring a private instance variable `game`
     * of type `Game`.
     * /* This variable is used to store an instance of the `Game` class, which
     * represents the current
     * /* game being played.
     */
    private Game game;

    /**
     * The code `public ControllerMain(){ this.playersBST = new BST<Player>(); }` is
     * a constructor for
     * /* the `ControllerMain` class.
     */
    public ControllerMain() {
        this.playersBST = new BST<Player>();
    }

    /**
     * The function initializes a new game and returns the result of the game's
     * initialization with the
     * given player name.
     * 
     * @param namePlayer A String representing the name of the player.
     * @return The method is returning the result of the `game.initGame(namePlayer)`
     *         method call.
     */
    public String initGame(String namePlayer) {
        game = new Game();
        return game.initGame(namePlayer);
    }

    /**
     * The function takes a pipe character and coordinates as input, checks for
     * validity, and returns a
     * message indicating whether the pipe was successfully placed or not.
     * 
     * @param pipe The parameter "pipe" is a string that represents the type of pipe
     *             to be placed. It
     *             can have the following values: "||", "=", "o", or "x".
     * @param x    The x parameter represents the x-coordinate of the position where
     *             the pipe will be
     *             placed.
     * @param y    The parameter "y" represents the y-coordinate of the position
     *             where the pipe is to be
     *             placed.
     * @return The method is returning a String.
     */
    public String putPipe(String pipe, int x, int y) {
        String out;
        if (pipe.equals("x")) {
            pipe = "X";
        }
        if (!pipe.equals("||") && !pipe.equals("=") && !pipe.equals("o") && !pipe.equals("X")) {
            out = "Invalid pipe option";
        } else {
            out = game.putPipe(pipe, x, y);
        }
        return out;
    }

    /**
     * The function "evaluatePipe" returns the result of evaluating the game's pipe.
     * 
     * @return The method evaluatePipe() is being called on the object "game" and
     *         the result of that
     *         method is being returned.
     */
    public String evaluatePipe() {
        return game.evaluatePipe();
    }

    /**
     * The function "finishMatch" returns a string indicating whether the game's
     * pipe system is working
     * or not.
     * 
     * @return The method is returning a String.
     */
    public String finishMatch() {
        String out;
        if (game.isWorkingPipeSystem()) {
            game.finishMatch();
            out = game.getPlayer().toString();
            Player player = game.getPlayer();
            playersBST.add(player);
        } else {
            out = "The pipe doesn't work";
        }
        return out;
    }

    public String getCurrentBoardState() {
        if (game != null) {
            return game.getCurrentBoardState();
        } else {
            return "No game in progress.";
        }
    }

    /**
     * The function returns the ranking of players, or a message indicating that
     * there are no
     * registered players.
     * 
     * @return The method is returning a string. If the playersBST is empty, it
     *         returns the message "No
     *         hay jugadores registrados." Otherwise, it returns the ranking of the
     *         players, with the number 4
     *         indicating the top 4 players in the ranking.
     */
    public String getRanking() {
        String out = "";
        if (playersBST.isEmpty()) {
            out = "There are no registered players";
        } else {
            out = "\n" + "\n" + playersBST.getRanking(4);
        }
        return out;
    }

}