package javafx_components.score_components;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// The class of the score that extends the JLabel class
public class PongScore_Label extends Label {
    // An Icon array field that'll hold number images.
    private final ImageView[] numberIcons;

    // Constructor of Score
    // Initialize numberIcons to carry 12 ImageIcons and calls two methods
    public PongScore_Label(){
        super();
        numberIcons = new ImageView[12];
        numberIconSetup();
        setScoreLabel(false,0);
    }

    // A method to set up each number icon as a new image icon
    private void numberIconSetup(){
        for (int i = 0; i < numberIcons.length; i++) {
            numberIcons[i] =
                    new ImageView(new Image(getClass()
                            .getResourceAsStream(i+".png")));
        }
    }

    // A method to set the score label and either display it or not
    public void setScoreLabel(boolean isShown, int value){
        if(isShown)
            setGraphic(numberIcons[value]);
        else
            setGraphic(null);
    }
}
