package model;



/**
 * The `Pipe` class represents a pipe object with properties such as content, type, and visit.
 */
public class Pipe{

    private String content;
    private PipeType type;
    private TypeVisit visit;


    public Pipe(){
        content="X";
        type=PipeType.X;
        visit=TypeVisit.NOT_VISITED;
    }
/**
 * The function sets the content of a variable and assigns a corresponding PipeType based on the value.
 * 
 * @param value The value parameter is a string that represents the content of the pipe.
 */
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
        }
    }

    /**
     * The getContent() function returns the content of a string.
     * 
     * @return The method is returning a String value.
     */
    public String getContent() {
        return content;
    }


    /**
     * The function returns the type of the pipe.
     * 
     * @return The method is returning the value of the variable "type", which is of type PipeType.
     */
    public PipeType getType() {
        return type;
    }


    /**
     * The function sets the type of a pipe.
     * 
     * @param type The "type" parameter is of type PipeType, which is likely an enumeration or a custom
     * class representing different types of pipes.
     */
    public void setType(PipeType type){
        this.type=type;
    }

    /**
     * The function sets the value of the visit variable to the specified TypeVisit object.
     * 
     * @param visit The parameter "visit" is of type "TypeVisit".
     */
    public void setVisit(TypeVisit visit) {
        this.visit = visit;
    }

    /**
     * The function returns the TypeVisit object.
     * 
     * @return The method is returning an object of type TypeVisit.
     */
    public TypeVisit getVisit() {
        return visit;
    }
}
