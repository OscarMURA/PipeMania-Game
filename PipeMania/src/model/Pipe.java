package model;

import java.util.Objects;

public class Pipe{
    private String content;
    private PipeType type;

    private boolean visited;

    public Pipe(){
        content="X";
        type=PipeType.X;
        visited=false;
    }
    public void setContent(String value){
        content=value;
        switch (value){
            case "X":
                type=PipeType.X;
                break;
            case "||":
                type=PipeType.VERTICAL;
                break;
            case "=":
                type=PipeType.HORIZONTAL;
                break;
            case "o":
                type=PipeType.ELBOW;
                break;
            case "F":
                type=PipeType.F;
                break;

            case "D":
                type=PipeType.D;
                break;

            default: 
                type=PipeType.X;
                content="X";
                break;

        }
    }

    public String getContent() {
        return content;
    }

    public PipeType getType() {
        return type;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
