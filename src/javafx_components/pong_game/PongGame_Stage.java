package javafx_components.pong_game;


import java.awt.Point;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx_components.ball_components.PongBall_Label;
import javafx_components.paddle_components.PongPaddle_Label;
import javafx_components.score_components.PongScore_Label;
import javafx_components.title_screen_components.PongFinalScore_Stage;

// The class of the Game Screen that extends the Stage class
public class PongGame_Stage extends Stage {

    // Creates the fields for the paddles, ball, and the scores
    private final PongPaddle_Label leftPaddle, rightPaddle;
    private final PongBall_Label ball;
    private final PongScore_Label leftScore, rightScore;

    // Boolean fields to check if W, S, I, K, or SPACE is pressed
    private boolean isWPressed, isSPressed, isIPressed, isKPressed, isSPACEPressed;

    // The speed of the game in rate
    private double gameSpeed = 1;
    // Checks if the game has started
    private boolean startGame;
    // An array for the score of each paddles
    private int[] paddlesScore;

    private Timeline gameTime;

    // Constructor of the class
    // With the parameter to set startGame
    public PongGame_Stage(boolean startGame){
        super();
        setTitle("PONG");
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: #000000");

        ball = new PongBall_Label();
        ball.setTranslateY(210);
        ball.setTranslateX(265);
        ball.setStartPosition(
                new Point((int)ball.getTranslateX(),
                        (int)ball.getTranslateY())
        );

        leftPaddle = new PongPaddle_Label();
        leftPaddle.setTranslateX(20);
        leftPaddle.setTranslateY(170);

        rightPaddle = new PongPaddle_Label();
        rightPaddle.setTranslateX(490);
        rightPaddle.setTranslateY(170);

        Label divider = new Label();
        divider.setGraphic(
                new ImageView(new Image(getClass().getResourceAsStream
                        ("divider.png"),10,390,false,false
                )));
        divider.setTranslateX(265);
        divider.setTranslateY(12);

        leftScore = new PongScore_Label();
        leftScore.setTranslateX(100);
        leftScore.setTranslateY(10);
        rightScore = new PongScore_Label();
        rightScore.setTranslateX(350);
        rightScore.setTranslateY(10);

        paddlesScore = new int[] {0,0};

        this.startGame = startGame;

        aPane.getChildren().addAll(ball,leftPaddle,
                rightPaddle,divider,leftScore,rightScore);

        Scene scene = new Scene(aPane,525,425);
        setScene(scene);
        scene.setOnKeyPressed(event -> changeKeyInput(true,event));
        scene.setOnKeyReleased(event -> changeKeyInput(false,event));

        gameTime = new Timeline(new KeyFrame(Duration.millis(100), event -> {
                    if(paddlesScore[0] == 11){
                        new PongFinalScore_Stage(true);
                        gameTime.stop();
                        close();
                    }
                    else if (paddlesScore[1] == 11){
                        new PongFinalScore_Stage(false);
                        gameTime.stop();
                        close();
                    }
                    else updateGame();
                }));
        gameTime.setCycleCount(Timeline.INDEFINITE);
        gameTime.play();
        show();
    }

    // This method continually updates the game
    // It calls each paddles and ball update methods
    private void updateGame(){
        // If the game is being played
        if(startGame) {
            // When the game is played, the score isn't shown
            leftScore.setScoreLabel(false,paddlesScore[0]);
            rightScore.setScoreLabel(false,paddlesScore[1]);

            // Updates the each paddle
            leftPaddle.paddleUpdate(isWPressed, isSPressed);
            rightPaddle.paddleUpdate(isIPressed, isKPressed);

            checkPaddleAndBallPosition();

            // Updates the ball
            ball.ballUpdate();

            // Check to see if the game's speed is consistently at its highest point
            // Ergo the game being 6 times as fast
            if (gameSpeed > 6) gameSpeed = 6;
            gameTime.setRate(gameSpeed);
        }
        else{
            // The score is shown when the game isn't played
            leftScore.setScoreLabel(true,paddlesScore[0]);
            rightScore.setScoreLabel(true,paddlesScore[1]);
            // Continues to loop until space is pressed
            // Ergo, the game starts
            if(isSPACEPressed)
                startGame = true;
        }
    }

    // The method to check the paddle and ball position
    // This checks to see if the ball needs to be bounced off of the paddle or not
    // If not, then give the opposing paddle a point
    private void checkPaddleAndBallPosition(){
        // Size Ball Paddle Add
        // +5 | 220 | 220 |  0
        // +4 | 220 | 210 | 10
        // +3 | 220 | 200 | 20
        // +2 | 220 | 190 | 30
        //  1 | 220 | 180 | 40
        // -2 | 220 | 170 | 50
        // -3 | 220 | 160 | 60
        // -4 | 220 | 150 | 70
        // -5 | 220 | 140 | 80

        // LEFT PADDLE COLLISION
        if(ball.getDirection() == 0 || ball.getDirection() == 2){
            // This checks the ball's x-coordinate in relation to the paddle's width
            // Below uses an algorithm that can be explained on Line 150
            if((ball.getTranslateX() > 24 && ball.getTranslateX() < 36)){
                if(ball.getTranslateY() == leftPaddle.getTranslateY())
                    setBallLocationSpeed(9,1);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 10)
                    setBallLocationSpeed(7,1);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 20)
                    setBallLocationSpeed(5,1);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 30)
                    setBallLocationSpeed(3,1);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 0)
                        ball.setDirection(1);
                    else
                        ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed +=0.1;
                }

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 50)
                    setBallLocationSpeed(3,3);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 60)
                    setBallLocationSpeed(5,3);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 70)
                    setBallLocationSpeed(7,3);

                else if(ball.getTranslateY() == leftPaddle.getTranslateY() + 80)
                    setBallLocationSpeed(9,3);
            }
            // If the ball is too far to the left
            else if(ball.getTranslateX() <= 0)
                scoreCount(false);
        }

        // RIGHT PADDLE COLLISION
        else if (ball.getDirection() == 1 || ball.getDirection() == 3){
            if((ball.getTranslateX() > 484 && ball.getTranslateX() < 496)){
                if(ball.getTranslateY() == rightPaddle.getTranslateY())
                    setBallLocationSpeed(9,0);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 10)
                    setBallLocationSpeed(7,0);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 20)
                    setBallLocationSpeed(5,0);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 30)
                    setBallLocationSpeed(3,0);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 1)
                        ball.setDirection(0);
                    else
                        ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed +=0.1;
                }
                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 50)
                    setBallLocationSpeed(3,2);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 60)
                    setBallLocationSpeed(5,2);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 70)
                    setBallLocationSpeed(7,2);

                else if(ball.getTranslateY() == rightPaddle.getTranslateY() + 80)
                    setBallLocationSpeed(9,2);

            }
            // If the ball is too far to the right
            else if(ball.getTranslateX() >= 550)
                scoreCount(true);
        }
    }
    // A method to setup the ball movement, direction, game speed, and play a sound effect
    private void setBallLocationSpeed(int movement, int direction){
        ball.setMovement(movement);
        ball.setDirection(direction);
        ball.playSoundEffect("ball_hit_paddle.wav");
        gameSpeed +=0.1;
    }

    // A method to add the score to either the left paddle or the right using said parameter
    private void scoreCount(boolean didLeftPaddleWin){
        // Plays the sound effect of paddle missing the ball
        ball.playSoundEffect("paddle_miss_ball.wav");
        // Sets the movement of the ball to 1
        ball.setMovement(1);
        // Sets the game to false, ergo it won't play until otherwise
        startGame = false;
        // Resets the gameSpeed to rate multiplier of 1
        gameSpeed = 1;
        // Resets the ball location
        ball.setTranslateX(ball.getStartPosition().getX());
        ball.setTranslateY(ball.getStartPosition().getY());
        // If left paddle won, change direction of ball and give one point to it
        // If not, give one point to right paddle
        if(didLeftPaddleWin) {
            paddlesScore[0] += 1;
            if(ball.getDirection() == 0)
                ball.setDirection(1);
            else
                ball.setDirection(3);
        }
        else {
            paddlesScore[1] += 1;
            if(ball.getDirection() == 1)
                ball.setDirection(0);
            else
                ball.setDirection(2);
        }
    }

    private void changeKeyInput(boolean toggle, KeyEvent e){
        if(e.getCode() == KeyCode.W) isWPressed = toggle;
        if(e.getCode() == KeyCode.S) isSPressed = toggle;
        if(e.getCode() == KeyCode.I) isIPressed = toggle;
        if(e.getCode() == KeyCode.K) isKPressed = toggle;
        if(e.getCode() == KeyCode.SPACE) isSPACEPressed = toggle;
    }
}
