package javafx_components.score_components;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// The class of the score that extends the Label class
public class PongScore_Label extends Label {
    // An ImageView array field that'll hold number images.
    private final ImageView[] numberImages;

    // Constructor of Score
    // Initialize numberImages to carry 12 Images and calls two methods
    public PongScore_Label(){
        super();
        numberImages = new ImageView[12];
        numberIconSetup();
        setScoreLabel(false,0);
    }

    // A method to set up each number ImageView as a new image
    private void numberIconSetup(){
        for (int i = 0; i < numberImages.length; i++) {
            numberImages[i] =
                    new ImageView(new Image(getClass()
                            .getResourceAsStream(i+".png"),78,101,false,false));
        }
    }

    // A method to set the score label and either display it or not
    public void setScoreLabel(boolean isShown, int value){
        if(isShown)
            setGraphic(numberImages[value]);
        else
            setGraphic(null);
    }
}
