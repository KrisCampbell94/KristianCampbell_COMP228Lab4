package testing_components.paddle_components;

import javax.swing.*;

public class Paddle_Label_Test extends JLabel {
    private boolean isUpPressed;
    private boolean isDownPressed;

    public Paddle_Label_Test() {
        super();
        Icon paddleIcon =
                new ImageIcon(getClass().
                        getResource("leftPaddle.png"));
        setIcon(paddleIcon);
        //handler = new keyboardHandler();
    }
    public void paddleUpdate(boolean upKey, boolean downKey){
        isUpPressed = upKey;
        isDownPressed = downKey;
        if(isUpPressed && (getY() > 10))
            paddleLocation(-10);
        else if(isDownPressed && (getY() < 320))
            paddleLocation(10);

    }
    private void paddleLocation(int y){
        setLocation(getX(),getY() + y);
        //System.out.println(getLocation());
    }
}
