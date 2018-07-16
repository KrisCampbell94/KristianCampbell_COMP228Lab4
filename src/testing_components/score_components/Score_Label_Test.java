package testing_components.score_components;

import javax.swing.*;

public class Score_Label_Test extends JLabel {
    private final Icon[] numberIcons;

    public Score_Label_Test(){
        super();
        numberIcons = new Icon[12];
        numberIconSetup();
        setScoreLabel(false,0);
    }
    private void numberIconSetup(){
        for (int i = 0; i < numberIcons.length; i++) {
            numberIcons[i] =
                    new ImageIcon(getClass()
                            .getResource(i+".png"));
        }
    }

    public void setScoreLabel(boolean isShown, int value){
        if(isShown)
            setIcon(numberIcons[value]);
        else
            setIcon(null);
    }
}
