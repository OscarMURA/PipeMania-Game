package model;

import java.util.Calendar;

public class Player implements Comparable<Player>{

    private String nickName;
    private double score;
    private String match;

    public Player(String nickName){
        this.nickName = nickName;
    }

    @Override
    public int compareTo(Player other){
        int result;
        if(score<other.getScore()){ //this is less than "other"
            result = -1;
        }else if(score>other.getScore()){   //this is bigger than "other"
            result = 1;
        }else{          //this is equals to "other"
            result = 0;
        }
        return result;
    }

    public void setScore(double score){
        this.score=score;
    }

    public double getScore(){
        return score;
    }

    public void setMatch(String match){
        this.match = match;
    }

    @Override
    public String toString(){
        return "Usuario: " + nickName + ", Score = "+ 
        score + ", match:\n" + match + "\n";
    }

}