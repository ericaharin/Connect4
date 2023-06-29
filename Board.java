import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

/** Class Board will create the Board for the game of Connect 4
 * @Author Erica Lee
 */
public class Board {
    private int numberRows = 6;
    private int numberCol = 7;
    private SquareButton[][] board;
    private GridPane grid;
    private int[] index = new int[2];

    /**
     * creates a board of number of rows and columns based on the inputted values
     * @param  a number of rows and b number of columns
     */
    public Board (int a, int b) {
        this.numberRows = a;
        this.numberCol = b;
        board = new SquareButton[numberRows][numberCol];

        // creates the square buttons to add to the board
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberCol; j++){
                board[i][j] = new SquareButton();
            }
        }

        // adds the square buttons to the board
        grid = new GridPane();
        for (int index = 0; index < numberRows; index ++) {
            for (int index2 =0; index2 <numberCol; index2 ++){
                grid.add(board[index][index2], index2, index);
            }
        }
    }


    /**
     * method that returns the GridPane of the created board
     */
    public GridPane getGridPane() {
        return grid;
    }

    /**
     * method that returns the WegeButton of the inputted index
     * @param row and column
     * @return SquareButton which is the at the index
     */
    public SquareButton getsButtonAtIndex(int row, int column){
        return board[row][column];
    }

    /** method that finds the index of the inputted WegeButton
     * @param b (squarebutton)
     * @return index of button
     */
    public int[] getIndex(SquareButton b) {
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberCol; j++) {
                if (b == this.getsButtonAtIndex(i,j)){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }


}
