import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * A JavaFX button that has a Connect4 square painted on it
 * @author Erica Lee
 */
public class SquareButton extends Button {


    /** the square that is displayed on the button **/
    private OneSquare square;

    private static Color player1Color = Color.RED;
    private static Color player2Color = Color.YELLOW;
    private static Color blankColor = Color.GREY;
    private static Color backgroundColor = Color.BLUE;

    /**
     * Create a Connect4 Game Button with default BLANK SquareType
     **/
    public SquareButton (){
        this.square = new OneSquare(OneSquare.SquareType.BLANK);
        setGraphic (new GameTile());
    }

    /**
     * Method that returns the square
     */
    public OneSquare getSquare (){
        return this.square;
    }

    /**
     * Method that sets the square
     */
    public void setSquare (OneSquare c){
        this.square = c;
        repaint();
    }


    /**
     * get color methods for player1, player2, and blank square
     * @return color of square type
     */
    public Color getPlayer1Color(){
        return this.player1Color;
    }
    public Color getPlayer2Color(){
        return this.player2Color;
    }
    public Color getBlankColor(){
        return this.blankColor;
    }
    public Color getBackgroundColor(){
        return this.backgroundColor;
    }

    /**
     * set color methods for player1, player2, and blank square
     */
    public void setPlayer1Color(Color c) {
        this.player1Color = c;
    }
    public void setPlayer2Color(Color c) {
        this.player2Color = c;
    }
    public void setBlankColor(Color c) {
        this.blankColor = c;
    }
    public void setBackgroundColor(Color c) {
        this.backgroundColor = c;
    }


    /**
     * Redisplays the square image
     */
    public void repaint(){
        ((GameTile)getGraphic()).paintTile();
    }


    /**
     * Nested class that will have the graphics for the different squares (red, yellow, blank)
     */
    private class GameTile extends Canvas {
        public GameTile() {
            super(70,70);
            paintTile();
        }

        /**
         * method that paints the tile based on the square type
         */
        public void paintTile(){
            GraphicsContext gc = getGraphicsContext2D();
            gc.setFill(getBackgroundColor());
            gc.fillRect(0,0,75,75);



            if (getSquare().getSquareType() == OneSquare.SquareType.BLANK){
                gc.setFill(getBlankColor());

            }
            else if (getSquare().getSquareType() == OneSquare.SquareType.PLAYER1){
                gc.setFill(getPlayer1Color());
            }
            else if (getSquare().getSquareType() == OneSquare.SquareType.PLAYER2){
                gc.setFill(getPlayer2Color());
            }
            gc.fillOval(0,0,70,70);
        }

    }



}
