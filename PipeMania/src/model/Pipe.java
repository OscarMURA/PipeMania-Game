package model;

import java.util.Objects;

public class Pipe{
    private String content;
    private PipeType type;
    private int position;

    public Pipe(){
        content="X";
        type=PipeType.X;
        position=-1;
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

    public void setPosition(int position) {
        this.position = position;
    }
    public int getPositon(){
        return position;
    }
    public PipeType getType() {
        return type;
    }
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pipe pipe)) return false;
        return position == pipe.position && Objects.equals(getContent(), pipe.getContent()) && getType() == pipe.getType();
    }

}
