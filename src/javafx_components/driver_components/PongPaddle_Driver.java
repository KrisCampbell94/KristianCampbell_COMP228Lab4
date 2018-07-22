package javafx_components.driver_components;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx_components.paddle_components.PongPaddle_Label;


public class PongPaddle_Driver  extends Application  {
    private static boolean isWPressed, isSPressed, isIPressed, isKPressed;
    public static void main(String[] args)  {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("PONG PADDLE TEST");
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: #000000");

        PongPaddle_Label leftPaddle = new PongPaddle_Label();
        // 20, 150
        leftPaddle.setTranslateX(20);
        leftPaddle.setTranslateY(150);
        aPane.getChildren().add(leftPaddle);

        PongPaddle_Label rightPaddle = new PongPaddle_Label();
        rightPaddle.setTranslateX(490);
        rightPaddle.setTranslateY(150);
        aPane.getChildren().add(rightPaddle);

        //aPane.setOnKeyPressed(event -> changeKeyInput(true,event));

        Scene aScene = new Scene(aPane, 550,450);
        stage.setScene(aScene);
        aScene.setOnKeyPressed(event -> changeKeyInput(true,event));
        aScene.setOnKeyReleased(event -> changeKeyInput(false,event));

        //stage.setOnShown(event -> leftPaddle.paddleUpdate(isWPressed,isSPressed));
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            //System.out.println("this is called every 100 milliseconds on UI thread");
            leftPaddle.paddleUpdate(isWPressed,isSPressed);
            rightPaddle.paddleUpdate(isIPressed,isKPressed);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        for (int i = 0; i < 10; i++) {
            stage.show();
        }

    }

    private void changeKeyInput(boolean toggle, KeyEvent e) {
        if (e.getCode() == KeyCode.W) isWPressed = toggle;
        if (e.getCode() == KeyCode.S) isSPressed = toggle;

        if (e.getCode() == KeyCode.I) isIPressed = toggle;
        if (e.getCode() == KeyCode.K) isKPressed = toggle;
    }
}
