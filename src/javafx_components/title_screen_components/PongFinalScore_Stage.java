package javafx_components.title_screen_components;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

// The class of the Final Score that extends the Stage class
public class PongFinalScore_Stage extends Stage {
    private final Timeline finalScoreTime;

    // Constructor of the class
    // Ask if the left paddle won. If not, then the right paddle won
    public PongFinalScore_Stage(boolean didLeftWin){
        super();
        setTitle("PONG");
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: #000000");

        Label result = new Label();
        result.setTranslateX(155);
        result.setTranslateY(190);
        if(didLeftWin)
            result.setGraphic(
                    new ImageView(new Image(getClass().
                    getResourceAsStream("LeftWins.png"),235,19,false,false))
            );
        else
            result.setGraphic(
                    new ImageView(new Image(getClass().
                            getResourceAsStream("RightWins.png"),235,19,false,false))
            );
        aPane.getChildren().add(result);
        Scene aScene = new Scene(aPane, 525,425);
        setScene(aScene);

        finalScoreTime = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                new PongTitleScreen_Stage();
                finalScoreTime.stop();
                close();
            }
        }));
        finalScoreTime.setCycleCount(Timeline.INDEFINITE);
        finalScoreTime.play();
        show();
    }
}
