import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * Class Connect4 that extends Application to play the Connect4 game
 * @author Erica Lee
 */
public class Connect4 extends Application{

    private Board board;
    private BorderPane layout;
    private int turnNumber = 0;
    private final int numberRows = 6;
    private final int numberCol = 7;

    /**
     * start method
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    public void start (Stage primaryStage){
        board = new Board(numberRows,numberCol);

        // creates new border pane with top as the board and bottom as label showing whose turn
        layout = new BorderPane();
        layout.setCenter(board.getGridPane());
        Label playerTurn = new Label();
        playerTurn.setText("Player 1's Turn");
        layout.setLeft(playerTurn);

        Label wrongSpot = new Label();
        layout.setRight(wrongSpot);


        // creates scene where the layout is displayed and has the title of the game
        primaryStage.setTitle("Erica's Connect4 Game!");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();

        /**
         * Event handler for placing a piece down on the board
          */
        for (int rowIndex = 0; rowIndex<numberRows; rowIndex++){
            for (int columnIndex = 0; columnIndex<numberCol; columnIndex++){
                int col = columnIndex;
                board.getsButtonAtIndex(rowIndex,columnIndex).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        SquareButton b = (SquareButton) event.getSource();

                        // if top row is already filled in that column, assume the whole column is filled
                        if (board.getsButtonAtIndex(0,col).getSquare().getSquareType()!=OneSquare.SquareType.BLANK){
                            wrongSpot.setText("Column already filled");
                        }

                        // if the bottom square is empty, it will just add there
                        else if (board.getsButtonAtIndex(5,col).getSquare().getSquareType()==OneSquare.SquareType.BLANK){
                            wrongSpot.setText("");
                            if(turnNumber%2 ==0){
                                board.getsButtonAtIndex(5, col).setSquare(new OneSquare(OneSquare.SquareType.PLAYER1));
                                board.getsButtonAtIndex(5, col).repaint();
                                playerTurn.setText("Player 2's Turn");
                                turnNumber++;
                            }
                            else {
                                board.getsButtonAtIndex(5, col).setSquare(new OneSquare(OneSquare.SquareType.PLAYER2));
                                board.getsButtonAtIndex(5, col).repaint();
                                playerTurn.setText("Player 1's Turn");
                                turnNumber++;
                            }
                        }

                        // if neither conditions true (column is completely filled or the bottom is open), it will place the piece at the lowest available square
                        else {
                            wrongSpot.setText("");
                            // run through the rows in the column from top to bottom
                            for (int rowIndex2 = 0; rowIndex2< numberRows; rowIndex2++){

                                // if it is a blank square, nothing happens & the loop will just keep running
                                if (board.getsButtonAtIndex(rowIndex2,col).getSquare().getSquareType()
                                        == OneSquare.SquareType.BLANK){
                                }

                                // if the square is not blank at the index, it will add to the row above the it
                                else{
                                    if(turnNumber%2 ==0){
                                        board.getsButtonAtIndex(rowIndex2 -1, col).setSquare(new OneSquare(OneSquare.SquareType.PLAYER1));
                                        board.getsButtonAtIndex(rowIndex2-1, col).repaint();
                                        playerTurn.setText("Player 2's Turn");
                                        turnNumber++;
                                    }
                                    else {
                                        board.getsButtonAtIndex(rowIndex2-1, col).setSquare(new OneSquare(OneSquare.SquareType.PLAYER2));
                                        board.getsButtonAtIndex(rowIndex2-1, col).repaint();
                                        playerTurn.setText("Player 1's Turn");
                                        turnNumber++;
                                    }
                                    rowIndex2 = numberRows;

                                }

                            }
                        }

                    }
                });
            }
        }

    }


}
