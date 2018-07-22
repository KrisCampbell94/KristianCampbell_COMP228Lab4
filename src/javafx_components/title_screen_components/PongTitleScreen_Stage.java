package javafx_components.title_screen_components;

// Imports each specific JavaFX constructor
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx_components.pong_game.PongGame_Stage;

// The class of the Title Screen that extends the Stage class
public class PongTitleScreen_Stage extends Stage {

    // A boolean to ask if the space key is pressed
    private boolean isSPACEPressed;

    // A boolean to ask if the Q key is pressed
    private boolean isQPressed;

    // A timeline to be used for keyframes
    // Basically continuous looping within the stage
    private Timeline titleTime;

    // Constructor of the class
    public PongTitleScreen_Stage(){
        // Sets the title
        super();
        setTitle("PONG - By : Kris Campbell | 2018");
        // Creates a simple pane object to store all the Labels and set the background colour
        Pane aPane = new Pane();
        // Sets background colour to black
        aPane.setStyle("-fx-background-color: #000000");

        // Creates and sets the Label for title
        // Displays the title of PONG through image, size, and location
        Label title = new Label();
        title.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream
                        ("Title.png"),400,119,false,false))
        );
        title.setTranslateX(70);
        title.setTranslateY(50);

        // Creates and sets the parameters for the start message
        Label startMessage = new Label();
        startMessage.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream
                        ("Space.png"),239,19,false,false))
        );
        startMessage.setTranslateX(150);
        startMessage.setTranslateY(250);

        // Creates and sets the parameters for the quit message
        Label quitMessage = new Label();
        quitMessage.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream
                        ("Quit.png"),239,19,false,false))
        );
        quitMessage.setTranslateX(150);
        quitMessage.setTranslateY(300);

        // Grabs all of the labels and puts them within the pane object
        aPane.getChildren().addAll(title,startMessage,quitMessage);

        // Creates a new scene, setting the dimensions and the object associated with it
        Scene scene = new Scene(aPane,525,425);
        // Sets the scene of the stage class to the newly created scene
        setScene(scene);
        // Creates the handlers of the scene for specified key events
        scene.setOnKeyPressed(event -> changeKeyInput(true,event));
        scene.setOnKeyReleased(event -> changeKeyInput(false,event));

        // Initializes the timeline for the stage with the update duration of 10 milliseconds
        titleTime = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            // If space key is pressed, then create a new stage with the pong game
            // NOTE: Stop the timeline object and close the window; infinite stage creations
            if(isSPACEPressed) {
                new PongGame_Stage(true);
                titleTime.stop();
                close();
            }
            // Quit the entire application
            else if(isQPressed)
                System.exit(0);
        }));
        // Set the loop/count cycle to indefinitely/forever
        titleTime.setCycleCount(Timeline.INDEFINITE);
        // Plays the timeline
        titleTime.play();
        // Shows the stage
        show();
    }
    // Changes the key input to true or false for the fields isSPACEPressed and isQPressed
    // This activates universal play and it's use is specifically shown within the game
    private void changeKeyInput(boolean toggle, KeyEvent e){
        if(e.getCode() == KeyCode.SPACE) isSPACEPressed = toggle;
        if(e.getCode() == KeyCode.Q) isQPressed = toggle;
    }
}
