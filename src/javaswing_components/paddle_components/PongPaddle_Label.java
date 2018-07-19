package javaswing_components.paddle_components;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

// The class of the paddle that extends the JLabel class
public class PongPaddle_Label extends JLabel {

    // Constructor of the paddle
    // Sets the icon to the png file
    public PongPaddle_Label() {
        super();
        setIcon(new ImageIcon(getClass().
                getResource("paddle.png")));
    }

    // Updates the entire paddle by keyPress
    public void paddleUpdate(boolean upKey, boolean downKey){
        if(upKey && (getY() > 10))
            paddleLocation(-10);
        else if(downKey && (getY() < 320))
            paddleLocation(10);

    }
    // Updates the paddle location
    private void paddleLocation(int y){
        setLocation(getX(),getY() + y);
    }
}
