package javafx_components.driver_components;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx_components.pong_game.PongGame_Stage;

public class PongGame_Driver extends Application {
    public static void main(String[] args)  {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        new PongGame_Stage(false);
    }
}
