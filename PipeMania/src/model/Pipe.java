package model;

public class Pipe {
    private String content;
    private PipeType type;

    public Pipe() {
        content = "X";
        type = PipeType.X;
    }

    public void setContent(String value) {
        content = value;
        switch (value) {
            case "X":
                type = PipeType.X;
                break;
            case "||":
                type = PipeType.VERTICAL;
                break;
            case "=":
                type = PipeType.HORIZONTAL;
                break;
            case "o":
                type = PipeType.ELBOW;
                break;
            case "F":
                type = PipeType.F;
                break;

            case "D":
                type = PipeType.D;
                break;
        }
    }

    public String getContent() {
        return content;
    }

}
