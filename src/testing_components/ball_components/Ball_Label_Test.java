package testing_components.ball_components;

import javax.swing.*;
import java.awt.*;

public class Ball_Label_Test extends JLabel {
    private int direction;
    private int movement;

    private Point startPosition;

    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    public int getMovement() { return movement; }
    public void setMovement(int movement) { this.movement = movement; }

    public Point getStartPosition() { return startPosition; }
    public void setStartPosition(Point startPosition) { this.startPosition = startPosition; }

    public Ball_Label_Test(){
        super();
        Icon ballIcon = new
                ImageIcon(getClass().
                getResource("ball.jpg"));
        setIcon(ballIcon);
        direction = 0;
        movement = 1;
    }

    private void ballMovementUpdate(int newY, boolean isLeft) {
        if (isLeft)
            setLocation(getX() - 10, getY() + newY);
        else
            setLocation(getX() + 10, getY() + newY);

        //if (getX() <= 10) {
        //    if (direction == 0) direction = 1;
        //    else if (direction == 2) direction = 3;
        //}
        //else if (getX() >= 510) {
        //    if (direction == 1) direction = 0;
        //    else if (direction == 3) direction = 2;
        //}
        if(getY() <= 10){
            if (direction == 0) direction = 2;
            else if (direction == 1) direction = 3;
        }
        else if (getY() >= 390){
            if (direction == 2) direction = 0;
            else if (direction == 3) direction = 1;
        }
    }

    /*
     * Movement 1 : Horizontal = GetY() +  0 [x]
     * Movement 2 : 12Diagonal = GetY() +  3 []
     * Movement 3 : 23Diagonal = GetY() +  5 [x]
     * Movement 4 : 34Diagonal = GetY() +  8 []
     * Movement 5 : 45Diagonal = GetY() + 10 [x]
     * Movement 6 : 57Diagonal = GetY() + 13 []
     * Movement 7 : 68Diagonal = GetY() + 15 [x]
     * Movement 8 : 79Diagonal = GetY() + 18 []
     * Movement 9 : 90Diagonal = GetY() + 20 [x]
     * */
    public void ballUpdate(){
        switch (movement){
            case 0:
                setLocation(getStartPosition());
            case 1:
                // Left == 0
                if (direction == 0 || direction == 2)
                    ballMovementUpdate(0,true);

                // Right == 1
                else if (direction == 1 || direction == 3)
                    ballMovementUpdate(0,false);

                break;
            case 2:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-3,true);
                else if (direction == 2)
                    ballMovementUpdate(3,true);
                // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-3,false);
                else if (direction == 3)
                    ballMovementUpdate(3,false);

                break;
            case 3:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-5,true);
                else if (direction == 2)
                    ballMovementUpdate(5,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-5,false);
                else if (direction == 3)
                    ballMovementUpdate(5,false);
                break;
            case 4:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-8,true);
                else if (direction == 2)
                    ballMovementUpdate(8,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-8,false);
                else if (direction == 3)
                    ballMovementUpdate(8,false);
                break;
            case 5:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-10,true);
                else if (direction == 2)
                    ballMovementUpdate(10,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-10,false);
                else if (direction == 3)
                    ballMovementUpdate(10,false);
                break;
            case 6:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-13,true);
                else if (direction == 2)
                    ballMovementUpdate(13,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-13,false);
                else if (direction == 3)
                    ballMovementUpdate(13,false);
                break;
            case 7:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-15,true);
                else if (direction == 2)
                    ballMovementUpdate(15,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-15,false);
                else if (direction == 3)
                    ballMovementUpdate(15,false);
                break;
            case 8:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-18,true);
                else if (direction == 2)
                    ballMovementUpdate(18,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-18,false);
                else if (direction == 3)
                    ballMovementUpdate(18,false);
                break;
            case 9:
                // UpLeft == 0 || DownLeft == 2
                if (direction == 0)
                    ballMovementUpdate(-20,true);
                else if (direction == 2)
                    ballMovementUpdate(20,true);
                    // UpRight == 1 || DownRight == 3
                else if (direction == 1)
                    ballMovementUpdate(-20,false);
                else if (direction == 3)
                    ballMovementUpdate(20,false);
                break;
        }
    }
}
