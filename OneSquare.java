/**
 * A single square for the Connect4 Game
 * @author Erica Lee
 */
public class OneSquare {

    /**
     * enums of the types of square in the Connect4 game
     */
    public enum SquareType {PLAYER1, PLAYER2, BLANK};

    private SquareType squareType;

    /**
     * creates a square of the inputted square type
     * @param type of square
     */
    public OneSquare (SquareType type) {
        this.squareType = type;
    }

    /**
     * method that returns the square type
     */
    public SquareType getSquareType(){
        return this.squareType;
    }

}
