package javafx_components.driver_components;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx_components.title_screen_components.PongFinalScore_Stage;

public class PongFinalScore_Driver extends Application {
    public static void main(String[] args)  {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        new PongFinalScore_Stage(true);
    }
}
