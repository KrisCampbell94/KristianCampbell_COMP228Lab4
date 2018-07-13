package testing_components.ball_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball_Label_Test extends JLabel {
    public int ballDirection;
    public int ballMovement;
    public Ball_Label_Test(){
        super();
        Icon ballIcon = new
                ImageIcon(getClass().
                getResource("ball.jpg"));
        setIcon(ballIcon);
        ballDirection = 0;
        ballMovement = 1;
    }

    private int directionChange(int newValue){
        ballDirection = newValue;
        return - 5;
    }
    /*
     * Movement 1 : Horizontal = GetY() + 0
     * Movement 2 : 12Diagonal = GetY() + 3
     * Movement 3 : 23Diagonal = GetY() + 5
     * Movement 4 : 34Diagonal = GetY() + 8
     * Movement 5 : 45Diagonal = GetY() + 10
     * Movement 6 : 57Diagonal = GetY() + 13
     * Movement 7 : 68Diagonal = GetY() + 15
     * Movement 8 : 79Diagonal = GetY() + 18
     * */
    public void ballUpdate(int newSpeed){
        switch (ballMovement){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }
}
