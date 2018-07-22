package javafx_components.driver_components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx_components.ball_components.PongBall_Label;

public class PongBall_Driver extends Application {
    public static void main(String[] args)  {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("PONG BALL TEST");
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: #000000");

        PongBall_Label aBall = new PongBall_Label();
        aBall.setTranslateY(220);
        aBall.setTranslateX(275);

        aPane.getChildren().add(aBall);

        Timeline ballTime = new Timeline(new KeyFrame(Duration.millis(100), event -> aBall.ballUpdate()));
        ballTime.setCycleCount(Timeline.INDEFINITE);
        ballTime.play();

        Scene aScene = new Scene(aPane, 550, 450);
        stage.setScene(aScene);
        aScene.setOnKeyPressed(
                event -> {
                    if(event.getCode() == KeyCode.DIGIT1) aBall.setMovement(1);
                    else if (event.getCode() == KeyCode.DIGIT3) aBall.setMovement(3);
                    else if (event.getCode() == KeyCode.DIGIT5) aBall.setMovement(5);
                    else if (event.getCode() == KeyCode.DIGIT7) aBall.setMovement(7);
                    else if (event.getCode() == KeyCode.DIGIT9) aBall.setMovement(9);
                });
        stage.show();

        aBall.ballUpdate();
    }
}
