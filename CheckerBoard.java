import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This program draws a red and black checkerboard with uniform green pieces on
 * the red tiles up to the third row and then with uniform purple pieces on the red tiles
 * starting from the 5th row.
 *
 * @author Jasmine Montrichard
 * @version 1
 */
public class CheckerBoard extends Application
{
    @Override
    public void start(Stage stage) {
        // Sets the title of the JavaFX Application
        stage.setTitle("JavaFX CheckerBoard - Jasmine Montrichard");
        
        // Creates the canvas and the tool to draw the shapes needed
        Canvas canvas = new Canvas(800,800);
        GraphicsContext pen = canvas.getGraphicsContext2D();
        
        int rows = 8; // Number of rows
        int cols = 8; // Number of columns
        int spacing = 50; // Spacing when shifting each tile
        
        // -- Rectangles (x,y,width,height)
        pen.setLineWidth(5); // Adds a thin black outline to each tile
        
        // Draws the red and black checkerboard
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pen.strokeRect((15+spacing*j), (18+spacing*i), 50, 50);
                // Checks if the current tile has the same or different parities and sets the color accordingly
                if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    pen.setFill(Color.RED);
                } else if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    pen.setFill(Color.BLACK);
                }
                pen.fillRect((15+spacing*j), (18+spacing*i), 50, 50);
            }
        }
        
        // -- Pieces
        // GREEN
        pen.setStroke(Color.DARKGREEN); // Adds a dark green outline for the green pieces
        pen.setFill(Color.GREEN); // Adds a green fill colour for the green pieces
        
        // Adds a green piece for each red tile up to the 3rd row
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cols; j++) {
                // Checks if the current tile is red
                if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    // Draws a green piece
                    pen.strokeOval((24+spacing*j), (26+spacing*i), 30, 30);
                    pen.fillOval((24+spacing*j), (26+spacing*i), 30, 30);
                }
            }
        }
        
        // PURPLE
        pen.setStroke(Color.DARKMAGENTA); // Adds a dark purple outline for the purple pieces
        pen.setFill(Color.PURPLE); // Adds a dark purple outline for the purple pieces
        
        // Adds a purple piece for each red tile starting from the 5th row
        for (int i = 5; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Checks if the current tile is red
                if ((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0)) {
                    // Draws a purple piece
                    pen.strokeOval((24+spacing*j), (26+spacing*i), 30, 30);
                    pen.fillOval((24+spacing*j), (26+spacing*i), 30, 30);
                }
            }
        }
        
        // Places the canvas on a new Pane 
        Pane myPane = new Pane(canvas);
        
        // Places the Pane onto a new Scene with a window size of 435x435, and a sky blue background
        Scene scene = new Scene(myPane, 435, 435, Color.SKYBLUE);
        
        // Sets the Scene for the stage
        stage.setScene(scene);
        
        // Displays the stage
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
