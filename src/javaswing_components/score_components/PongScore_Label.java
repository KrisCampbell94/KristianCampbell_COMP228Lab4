package javaswing_components.score_components;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

// The class of the score that extends the JLabel class
public class PongScore_Label extends JLabel {
    // An Icon array field that'll hold number images.
    private final Icon[] numberIcons;

    // Constructor of Score
    // Initialize numberIcons to carry 12 ImageIcons and calls two methods
    public PongScore_Label(){
        super();
        numberIcons = new Icon[12];
        numberIconSetup();
        setScoreLabel(false,0);
    }

    // A method to set up each number icon as a new image icon
    private void numberIconSetup(){
        for (int i = 0; i < numberIcons.length; i++) {
            numberIcons[i] =
                    new ImageIcon(getClass()
                            .getResource(i+".png"));
        }
    }

    // A method to set the score label and either display it or not
    public void setScoreLabel(boolean isShown, int value){
        if(isShown)
            setIcon(numberIcons[value]);
        else
            setIcon(null);
    }
}
