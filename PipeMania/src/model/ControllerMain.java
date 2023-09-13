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
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            out = "\n" + "No se pudo, indice invalido";
        } else if (!pipe.equals("||") && !pipe.equals("=") && !pipe.equals("o")) {
            out = "Invalida opcion de tubería";
        } else {
            out = game.putPipe(pipe, x, y);
        }
        return out;
    }

    /*
     * public String evaluatePipe(){
     * 
     * return game.evaluatePipe();
     * }
     * 
     * /*public String finishMatch(){
     * String out;
     * if(game.evaluatePipe()){
     * actualPlayer.setMatch(game.genereteBoardPrint());
     * actualPlayer.setScore(calculateMatch(game));
     * playersBST.add(game.getPlayer());
     * out = actualPlayer.toString();
     * }else{
     * out = "No funciona";
     * }
     * return out;
     * }
     */

    /*
     * public double calculateMatch(Game game){
     * double score = (100 - game.usedPipes()) * 10 -
     * (System.currentTimeMillis()-startTime)/1000;
     * return score;
     * }
     */

}