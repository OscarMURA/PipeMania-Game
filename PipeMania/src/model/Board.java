
package model;

import java.util.Random;
import util.DoubleLinkedList;
/**
 * The `Board` class represents a game board consisting of pipes, with methods for adding pipes,
 * changing pipe content, validating pipe connections, and generating a string representation of the
 * board.
 */
public class Board {

    // These are instance variables of the `Board` class in Java.
    // They are declared outside of any method, and are accessible
    // from all methods in the class.

    /**
     * The `private int colum` variable is an instance variable of the `Board` class
     * in Java. It is
     * used to store the number of columns in the board. It is declared as
     * `private`, which means it
     * can only be accessed within the `Board` class.
     */
    private int colum;

    /**
     * is declaring a public instance variable named `row` of type `int`.
     * This variable is accessible from outside the `Board` class and can be used to
     * store the number
     * of rows in the board
     */
    public int row;

    /** This var is for save the position the Drains Pipes */
    public int finaL;
    /** This var is for save the position the sources Pipes */
    public int init;

    /**
     * board is declaring a private instance variable named
     * `board` of type `DoubleLinkedList<Pipe>`. This variable is used to store the
     * pipes on the board.
     * `DoubleLinkedList` is a custom class that represents a doubly linked list,
     * and `Pipe` is a class
     * representing a pipe object.
     */
    private DoubleLinkedList<Pipe> board;

    private Random rd;

    /**
     * The `public Board(int colum, int row)` constructor is initializing a new
     * instance of the `Board`
     * class. It takes two parameters, `colum` and `row`, which represent the number
     * of columns and
     * rows in the board, respectively
     */
    public Board(int colum, int row) {
        this.colum = colum;
        this.row = row;
        rd = new Random();
        initBoard();
    }

    /**
     * The getColum() function returns the value of the colum variable.
     * 
     * @return The method is returning the value of the variable "colum".
     */
    public int getColum() {
        return colum;
    }

    /**
     * The function returns the value of the variable "row".
     * 
     * @return The method is returning the value of the variable "row".
     */
    public int getRow() {
        return row;
    }

    private void initBoard() {
        board = new DoubleLinkedList<Pipe>();
        int amountNode = colum * row;
        board = addPipe(amountNode, board);
        generateRandomSourceAndDrain(0, 0, 0, 0);
    }

    /**
     * The function recursively adds a specified number of Pipe objects to a
     * DoubleLinkedList and
     * returns the updated list.
     * 
     * @param counter The number of pipes to add to the board.
     * @param board   The current state of the double linked list of pipes on the
     *                board.
     * @return The method is returning a DoubleLinkedList<Pipe> object.
     */
    private DoubleLinkedList<Pipe> addPipe(int counter, DoubleLinkedList<Pipe> board) {
        DoubleLinkedList<Pipe> result;
        if (counter == 0) {
            result = board;
        } else {
            Pipe pipe = new Pipe();
            board.add(pipe);
            result = addPipe(counter - 1, board);
        }
        return result;
    }

    /**
     * The function generates random positions for a source and drain in a grid,
     * ensuring they are not
     * too close to each other.
     * 
     * @param rowSource   The row index of the source pipe.
     * @param columSource The column index of the source pipe.
     * @param rowDrain    The row number of the drain pipe.
     * @param columDrain  The column index of the drain pipe.
     */
    private void generateRandomSourceAndDrain(int rowSource, int columSource, int rowDrain, int columDrain) {
        if (!(Math.abs(rowSource - rowDrain) + Math.abs(columSource - columDrain) < 4)) {
            int PositionSource = this.colum * (columSource - 1) + rowSource - 1;
            int PositionDrain = this.colum * (columDrain - 1) + rowDrain - 1;
            // Añado las posiciones de las tuberias
            // y la fuente es el primero
            this.init = PositionSource;
            this.finaL = PositionDrain;
            Pipe source = board.get(PositionSource);
            Pipe drain = board.get(PositionDrain);
            source.setContent("F");
            drain.setContent("D");
        } else {
            rowSource = rd.nextInt(row) + 1;
            columSource = rd.nextInt(colum) + 1;
            rowDrain = rd.nextInt(row) + 1;
            columDrain = rd.nextInt(colum) + 1;

            generateRandomSourceAndDrain(rowSource, columSource, rowDrain, columDrain);
        }
    }

    /**
     * The function changes the content of a pipe on a board at a specified row and
     * column position.
     * 
     * @param row   The row index of the pipe on the board.
     * @param colum The parameter "colum" represents the column number of the pipe
     *              on the board.
     * @param pipe  The "pipe" parameter is a string that represents the type of
     *              pipe to be placed in
     *              the specified row and column on the board. It can have one of
     *              the following values: "X", "||",
     *              "=", or "o".
     */
    public void changePipe(int row, int colum, String pipe) {

        if (pipe.equalsIgnoreCase("X") || pipe.equalsIgnoreCase("||") || pipe.equalsIgnoreCase("=")
                || pipe.equalsIgnoreCase("o")) {
                    
            int position = this.colum * (colum) + row;
            Pipe pipe1 = board.get(position);

            if (!pipe1.getType().equals(PipeType.F) && !pipe1.getType().equals(PipeType.D))
                pipe1.setContent(pipe);
        }

    }

    /**
     * The function "validationPipes" checks if a series of pipes on a board are
     * connected correctly.
     * 
     * @return The method is returning a boolean value.
     */
    public boolean validationPipes() {

        boolean result = false;
        int posCurrent = this.init;
        Pipe current = (board).get(init);
        Pipe aux = new Pipe();
        aux.setVisit(TypeVisit.VISITED);
        current.setVisit(TypeVisit.VISITED);
        result = validationPipesRecursively(posCurrent, aux, current);
        return result;
    }

    /**
     * The function `validationPipesRecursively` recursively checks if a series of
     * pipes are connected
     * correctly on a board.
     * 
     * @param posCurrent The current position of the pipe on the board.
     * @param last       The last pipe that was visited in the recursion.
     * @param current    The current pipe being checked for validation.
     * @return The method is returning a boolean value.
     */
    private boolean validationPipesRecursively(int posCurrent, Pipe last, Pipe current) {
        boolean result;
        int pos = -1;
        if (posCurrent == finaL) {
            result = true;

        } else {

            boolean pipeNextDown = false, pipeNextUp = false, pipeNextRight = false, pipeNextLeft = false;
            Pipe pipeDown = null, pipeUp = null, pipeRigh = null, pipeLeft = null;
            int posDown = posCurrent + colum, posUp = posCurrent - colum, posRight = posCurrent + 1,
                    posLeft = posCurrent - 1;

            if (posDown < colum * row) {// Do not leave the board
                pipeDown = (board).get(posDown);
                pipeNextDown = pipeNextIsUpOrDown(last, current, pipeDown);

            }
            if (posUp >= 0) {// Does not exceed the upper limit
                pipeUp = (board).get(posUp);
                pipeNextUp = pipeNextIsUpOrDown(last, current, pipeUp);

            }
            if (posCurrent % colum != 0 && posCurrent != 0) {// Does not exceed the left limit
                pipeLeft = board.get(posLeft);
                pipeNextLeft = pipeNextIsRightOrLeft(last, current, pipeLeft);
            }
            if ((posCurrent + 1) % colum != 0) {// Does not exceed the right limit
                pipeRigh = board.get(posRight);
                pipeNextRight = pipeNextIsRightOrLeft(last, current, pipeRigh);

            }

            //This only happens when the one pipe is connected to only other
            if (pipeNextDown ^ pipeNextUp ^ pipeNextRight ^ pipeNextLeft) {

                //This is for the case when the pipe is connected to only one pipe
                if (pipeNextDown) {
                    pos = posDown;
                    last = current;
                    current = pipeDown;

                } else if (pipeNextUp) {
                    pos = posUp;
                    last = current;
                    current = pipeUp;

                } else if (pipeNextRight) {
                    pos = posRight;
                    last = current;
                    current = pipeRigh;

                } else {
                    pos = posLeft;
                    last = current;
                    current = pipeLeft;

                }
                current.setVisit(TypeVisit.VISITED);
                result = validationPipesRecursively(pos, last, current);

            } else {
                //This is for the case when the pipe is connected to two or more pipes
                //The visit of the pipes is restarted, for a next verification
                result = false;
                resetVisit(0, 0);
            }

        }

        return result;
    }

    /**
     * The function determines if the next pipe in a sequence is either a horizontal
     * or elbow pipe and has
     * not been visited before.
     * 
     * @param last    The last pipe in the sequence.
     * @param current The current pipe in the pipeline system.
     * @param next    The next parameter is an object of type Pipe, which represents
     *                the next pipe in a
     *                pipeline system.
     * @return The method is returning a boolean value.
     */
    public boolean pipeNextIsRightOrLeft(Pipe last, Pipe current, Pipe next) {
        boolean value = false;

        if ((next.getType().equals(PipeType.HORIZONTAL) || next.getType().equals(PipeType.D))
                && next.getVisit().equals(TypeVisit.NOT_VISITED)) {

            if (current.getType().equals(PipeType.HORIZONTAL) || current.getType().equals(PipeType.F))
                value = true;
            else if (current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.VERTICAL))
                value = true;

        } else if (next.getType().equals(PipeType.ELBOW) && next.getVisit().equals(TypeVisit.NOT_VISITED)) {
            value = true;
        }

        return value;
    }

    /**
     * The function determines if the next pipe in a sequence is either vertical or
     * an elbow and has not
     * been visited before.
     * 
     * @param last    The previous pipe in the pipeline.
     * @param current The current pipe in the pipeline system.
     * @param next    The next parameter is an object of type Pipe, which represents
     *                the next pipe in a
     *                pipeline system.
     * @return The method is returning a boolean value.
     */
    private boolean pipeNextIsUpOrDown(Pipe last, Pipe current, Pipe next) {
        boolean value = false;

        if ((next.getType().equals(PipeType.VERTICAL) || next.getType().equals(PipeType.D))
                && next.getVisit().equals(TypeVisit.NOT_VISITED)) {
            if (current.getType().equals(PipeType.VERTICAL) || current.getType().equals(PipeType.F)) {
                value = true;
            } else if (current.getType().equals(PipeType.ELBOW) && last.getType().equals(PipeType.HORIZONTAL))
                value = true;

        } else if (next.getType().equals(PipeType.ELBOW) && next.getVisit().equals(TypeVisit.NOT_VISITED)) {
            value = true;
        }

        return value;
    }

    /**
     * The function generates a string representation of a board by recursively
     * iterating through its
     * elements.
     * 
     * @return The method is returning a string representation of the board.
     */
    public String generateBoardPrint() {
        return generateBoardPrintRecursively(0, 0, "");
    }

    /**
     * The function generates a string representation of a board by recursively
     * iterating through each
     * position and appending the content of the corresponding pipe.
     * 
     * @param i   The parameter "i" represents the current row index in the board.
     * @param j   The parameter "j" represents the current column index in the
     *            board.
     * @param out The "out" parameter is a string that represents the current state
     *            of the board being
     *            generated. It is built up recursively as the function traverses
     *            through the board.
     * @return The method is returning a String value.
     */
    private String generateBoardPrintRecursively(int i, int j, String out) {
        String result;
        if (i >= colum) {
            result = out;
        } else if (j >= row) {
            result = generateBoardPrintRecursively(i + 1, 0, out + "\n");
        } else {
            int position = colum * i + j;
            Pipe pipe = (board).get(position);
            result = generateBoardPrintRecursively(i, j + 1, out + pipe.getContent() + " ");
        }
        return result;
    }

    /**
     * The function `resetVisit` resets the visit status of each pipe on a board by
     * iterating through each
     * position and setting the visit status to "not visited".
     * 
     * @param i The parameter `i` represents the current column index in the board.
     * @param j The parameter "j" represents the current column index in the board.
     */

    private void resetVisit(int i, int j) {
        if (i >= colum) {
            return;
        } else if (j >= row) {
            resetVisit(i + 1, 0);
        } else {
            int position = colum * i + j;
            Pipe pipe = (board).get(position);
            pipe.setVisit(TypeVisit.NOT_VISITED);
            resetVisit(i, j + 1);
        }

    }

    /**
     * The function returns a DoubleLinkedList of Pipe objects representing the
     * board.
     * 
     * @return A DoubleLinkedList of Pipe objects is being returned.
     */
    public DoubleLinkedList<Pipe> getBoard() {
        return board;
    }

    /**
     * The restartBoard() function resets the board and generates random source and
     * drain positions.
     */
    public void restartBoard() {
        restartBoard(0);
        generateRandomSourceAndDrain(0, 0, 0, 0);
    }

    /**
     * The restartBoard function recursively sets the content and visit status of
     * each pipe on the
     * board to default values.
     * 
     * @param index The index parameter represents the current index of the board
     *              that we want to
     *              restart.
     */
    private void restartBoard(int index) {
        if (index < board.getNumItems()) {
            Pipe pipe = board.get(index);
            pipe.setContent("X");
            pipe.setVisit(TypeVisit.NOT_VISITED);
            restartBoard(index + 1);
        }
    }

    /**
     * The function "accountUsedPipes" returns the total number of pipes used in an
     * account.
     * 
     * @return The method is returning the value of the variable "account".
     */
    public int accountUsedPipes() {
        int account = 0;
        account = accountUsedPipes(0, 0, account);
        return account;
    }

    /**
     * The function recursively counts the number of pipes of certain types on a
     * board.
     * 
     * @param i       The current column index
     * @param j       The parameter `j` represents the current row index in the
     *                board.
     * @param account The parameter "account" represents the number of pipes that
     *                have been used so far.
     * @return The method is returning the value of the variable "result".
     */
    private int accountUsedPipes(int i, int j, int account) {
        int result;
        if (i >= colum)
            result = account;

        else if (j >= row)
            result = accountUsedPipes(i + 1, 0, account);

        else {

            int position = colum * i + j;
            Pipe pipe = board.get(position);

            if (pipe.getType().equals(PipeType.HORIZONTAL) || pipe.getType().equals(PipeType.VERTICAL)
                    || pipe.getType().equals(PipeType.ELBOW))
                result = accountUsedPipes(i, j + 1, account + 1);
            else
                result = accountUsedPipes(i, j + 1, account);

        }

        return result;
    }

}
