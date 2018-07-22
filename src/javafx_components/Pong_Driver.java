package javafx_components;

// Imports the packages for any classes and constructors that operates JavaFX
import javafx.application.Application;
import javafx.stage.Stage;
import javafx_components.title_screen_components.PongTitleScreen_Stage;

// Class to Start PONG; uses the main method and extends the Application of JavaFX
public class Pong_Driver extends Application {
    // The main method launches the JavaFX stage located in the overridden start method
    public static void main(String[] args)  {
        launch(args);
    }
    // Starts the application by launching the title screen of the game
    @Override
    public void start(Stage primaryStage){
        new PongTitleScreen_Stage();
    }
}
