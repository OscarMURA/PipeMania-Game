package model;

/**
 * The Player class represents a player in a game, with a nickname, score, and
 * match information.
 */
public class Player implements Comparable<Player> {

    /**
     * The line `private String nickName;` is declaring a private instance variable
     * called `nickName`
     * /* of type `String` in the `Player` class. This variable is used to store the
     * nickname of the
     * /* player. The `private` access modifier means that this variable can only be
     * accessed within the
     * /* `Player` class itself.
     */
    private String nickName;
    /**
     * The line `private double score;` is declaring a private instance variable
     * called `score` of type
     * /* `double` in the `Player` class. This variable is used to store the score
     * of the player. The
     * /* `private` access modifier means that this variable can only be accessed
     * within the `Player`
     * /* class itself.
     */
    private double score;
    /**
     * The line `private String match;` is declaring a private instance variable
     * called `match` of type
     * /* `String` in the `Player` class. This variable is used to store the match
     * information of the
     * /* player. The `private` access modifier means that this variable can only be
     * accessed within the
     * /* `Player` class itself.
     */
    private String match;

    /**
     * The code `public Player(String nickName){ this.nickName = nickName; }` is a
     * constructor for the
     * /* `Player` class. It takes a parameter `nickName` of type `String` and
     * assigns it to the
     * /* `nickName` instance variable of the `Player` object being created.
     */
    public Player(String nickName) {
        this.nickName = nickName;
        this.score = 0;
        this.match = "";
    }

    /**
     * This function compares the score of the current player with another player
     * and returns -1 if the
     * current player's score is less, 1 if it is greater, and 0 if they have the
     * same score.
     * 
     * @param other The "other" parameter is an instance of the Player class that we
     *              are comparing the
     *              current instance to.
     * @return The method is returning an integer value that represents the
     *         comparison result between
     *         the current player and the "other" player. The returned value can be
     *         interpreted as follows:
     */
    @Override
    public int compareTo(Player other) {
        int result;
        if (score < other.getScore()) { // this is less than "other"
            result = -1;
        } else if (score > other.getScore()) { // this is bigger than "other"
            result = 1;
        } else { // this is equals to "other"
            result = 0;
        }
        return result;
    }

    /**
     * The function sets the score value for an object.
     * 
     * @param score The parameter "score" is of type double, which means it can hold
     *              decimal values.
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * The function returns the score as a double.
     * 
     * @return The method is returning a double value, which is the score.
     */
    public double getScore() {
        return score;
    }

    /**
     * The function sets the value of the "match" variable.
     * 
     * @param match The parameter "match" is a string that represents a match.
     */
    public void setMatch(String match) {
        this.match = match;
    }

    /**
     * The toString() function returns a string representation of the object,
     * including the user's
     * nickname, score, and match details.
     * 
     * @return The toString() method is returning a string representation of an
     *         object. The returned
     *         string includes the user's nickname, score, and match details.
     */
    @Override
    public String toString() {
        return "User: " + nickName + ", Score = " +
                (int) score + "\n" + "\n Match:\n" + match + "\n";
    }

    /**
     * The function sets the nickname of an object.
     * 
     * @param name The name parameter is a String that represents the nickname to be
     *             set.
     */
    public void setNickName(String name) {
        this.nickName = name;
    }

}