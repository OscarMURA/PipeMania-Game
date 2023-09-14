package model;

import util.BST;

public class ControllerMain {

    private BST<Player> playersBST;
    private Game game;

    public ControllerMain() {
        this.playersBST = new BST<Player>();
    }

    public String initGame(String namePlayer) {
        game = new Game();
        return game.initGame(namePlayer);
    }

    public String putPipe(String pipe, int x, int y) {
        String out;
        if (pipe.equals("x")) {
            pipe = "X";
        }
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            out = "\n" + "No se pudo, indice invalido";
        } else if (!pipe.equals("||") && !pipe.equals("=") && !pipe.equals("o") && !pipe.equals("X")) {
            out = "Invalida opcion de tubería";
        } else {
            out = game.putPipe(pipe, x, y);
        }
        return out;
    }

    public String evaluatePipe() {
        return game.evaluatePipe();
    }

    public String finishMatch() {
        String out;
        if (game.isWorkingPipeSystem()) {
            out = game.getPlayer().toString();
            playersBST.add(game.getPlayer());
        } else {
            out = "No funciona";
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

}