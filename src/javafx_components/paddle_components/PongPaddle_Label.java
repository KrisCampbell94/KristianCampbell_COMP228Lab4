package javafx_components.paddle_components;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// The class of the paddle that extends the Label class
public class PongPaddle_Label extends Label {

    // Constructor of the paddle
    // Sets the graphic to the png file
    public PongPaddle_Label() {
        super();
        setGraphic(new ImageView(
                        new Image(
                                getClass().getResourceAsStream("paddle.png"),15,85,false,false)
                )
        );
    }

    // Updates the entire paddle by keyPress
    public void paddleUpdate(boolean upKey, boolean downKey){
        if(upKey && (getTranslateY() > 10))
            paddleLocation(-10);
        else if(downKey && (getTranslateY() < 320))
            paddleLocation(10);

    }
    // Updates the paddle location
    private void paddleLocation(int y){
        setTranslateY(getTranslateY() + y);
    }
}
