package javafx_components.ball_components;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.awt.Point;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



// The class of the ball that extends the Label class
public class PongBall_Label extends Label {
    // The 8 directions of the ball
    private int direction;
    // The different movements/angles of the ball
    // Refer to the Movement algorithm on Line 74
    private int movement;

    // The starting position of the ball
    private Point startPosition;

    // Properties of direction
    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    // Properties of movement
    public int getMovement() { return movement; }
    public void setMovement(int movement) { this.movement = movement; }

    // Properties of the starting position
    public Point getStartPosition() { return startPosition; }
    public void setStartPosition(Point startPosition) { this.startPosition = startPosition; }

    // Constructor of the ball
    // Sets up the Graphic, direction, and movement
    public PongBall_Label(){
        super();
        setGraphic(new ImageView(
                new Image(
                        getClass().getResourceAsStream("ball.jpg"),10,10,false,false)
                )
        );
        direction = 0;
        movement = 1;
    }

    // The method to update the ball's motion around the screen
    // with parameters to insert a new value for Y and to ask if the ball is moving left
    private void ballMovementUpdate(int newY, boolean isLeft) {
        if (isLeft)
            setTranslateX(getTranslateX() - 10);
        else
            setTranslateX(getTranslateX() + 10);

        setTranslateY(getTranslateY() + newY);
        // If ball hits the top of the border
        if(getTranslateY() <= 10){
            if (getDirection() == 0) setDirection(2);
            else if (getDirection() == 1) setDirection(3);
            playSoundEffect("ball_hit_wall.wav");
        }
        // If ball hits the bottom of the border
        else if (getTranslateY() >= 390){
            if (getDirection() == 2) setDirection(0);
            else if (getDirection() == 3) setDirection(1);
            playSoundEffect("ball_hit_wall.wav");
        }
    }

    // Movement 0 : Starting Point
    // Movement 1 : Horizontal = GetY() +  0 [x]
    // Movement 2 : 12Diagonal = GetY() +  3 []
    // Movement 3 : 23Diagonal = GetY() +  5 [x]
    // Movement 4 : 34Diagonal = GetY() +  8 []
    // Movement 5 : 45Diagonal = GetY() + 10 [x]
    // Movement 6 : 57Diagonal = GetY() + 13 []
    // Movement 7 : 68Diagonal = GetY() + 15 [x]
    // Movement 8 : 79Diagonal = GetY() + 18 []
    // Movement 9 : 90Diagonal = GetY() + 20 [x]

    // Updates the ball's movement
    public void ballUpdate(){
        // Activates a switch for movement
        // Refer to the Movement algorithm on Line 74
        switch (getMovement()){
            case 0:
                setTranslateX(getStartPosition().x);
                setTranslateY(getStartPosition().y);
                break;
            case 1:
                // Left == 0
                if (getDirection() == 0 || getDirection() == 2)
                    ballMovementUpdate(0,true);
                // Right == 1
                else if (getDirection() == 1 || getDirection() == 3)
                    ballMovementUpdate(0,false);
                break;
            case 3:
                // UpLeft == 0 || DownLeft == 2
                if (getDirection() == 0)
                    ballMovementUpdate(-5,true);
                else if (getDirection() == 2)
                    ballMovementUpdate(5,true);
                    // UpRight == 1 || DownRight == 3
                else if (getDirection() == 1)
                    ballMovementUpdate(-5,false);
                else if (getDirection() == 3)
                    ballMovementUpdate(5,false);
                break;
            case 5:
                // UpLeft == 0 || DownLeft == 2
                if (getDirection() == 0)
                    ballMovementUpdate(-10,true);
                else if (getDirection() == 2)
                    ballMovementUpdate(10,true);
                    // UpRight == 1 || DownRight == 3
                else if (getDirection() == 1)
                    ballMovementUpdate(-10,false);
                else if (getDirection() == 3)
                    ballMovementUpdate(10,false);
                break;
            case 7:
                // UpLeft == 0 || DownLeft == 2
                if (getDirection() == 0)
                    ballMovementUpdate(-15,true);
                else if (getDirection() == 2)
                    ballMovementUpdate(15,true);
                    // UpRight == 1 || DownRight == 3
                else if (getDirection() == 1)
                    ballMovementUpdate(-15,false);
                else if (getDirection() == 3)
                    ballMovementUpdate(15,false);
                break;
            case 9:
                // UpLeft == 0 || DownLeft == 2
                if (getDirection() == 0)
                    ballMovementUpdate(-20,true);
                else if (getDirection() == 2)
                    ballMovementUpdate(20,true);
                    // UpRight == 1 || DownRight == 3
                else if (getDirection() == 1)
                    ballMovementUpdate(-20,false);
                else if (getDirection() == 3)
                    ballMovementUpdate(20,false);
                break;
        }
    }

    // Plays the specified sound file
    public void playSoundEffect(String wavFile){
        // Activates a try/catch statement for file checking
        try{
            // Gets the file from within the package
            URL url = getClass().getResource(wavFile);
            // Streams the file
            AudioInputStream input = AudioSystem.
                    getAudioInputStream(url);
            // Gets the stream and plays the file once
            Clip clip = AudioSystem.getClip();
            clip.open(input);
            clip.start();

        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}
