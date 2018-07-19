package javaswing_components.pong_game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javaswing_components.ball_components.PongBall_Label;
import javaswing_components.paddle_components.PongPaddle_Label;
import javaswing_components.score_components.PongScore_Label;

// The class of the Game Screen that extends the JFrame class
public class PongGame_Frame extends JFrame {

    // Creates the fields for the paddles, ball, and the scores
    private final PongPaddle_Label leftPaddle, rightPaddle;
    private final PongBall_Label ball;
    private final PongScore_Label leftScore, rightScore;

    // Boolean fields to check if W, S, I, K, or SPACE is pressed
    private boolean isWPressed, isSPressed, isIPressed, isKPressed, isSPACEPressed;

    // The speed of the game in milliseconds
    private int gameSpeed = 100;
    // Checks if the game has started
    private boolean startGame;
    // An array for the score of each paddles
    private int[] paddlesScore;
    public int[] getPaddlesScore() { return paddlesScore; }

    // Constructor of the class
    // With the parameter to set startGame
    public PongGame_Frame(boolean startGame){
        // Sets up the frame itself
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        // Sets up the paddles through initialization and method calling
        leftPaddle = new PongPaddle_Label();
        setupPaddles(leftPaddle,20);
        rightPaddle = new PongPaddle_Label();
        setupPaddles(rightPaddle,490);

        // Sets up the ball as well as the starting position
        ball = new PongBall_Label();
        ball.setSize(10,10);
        ball.setLocation(275,220);
        add(ball);
        ball.setStartPosition(new Point(275,220));

        // Sets up the divider and displays it in the frame
        JLabel divider = new JLabel();
        divider.setIcon(new ImageIcon(
                getClass().getResource("divider.png"))
        );
        divider.setSize(10,390);
        divider.setLocation(275,11);
        add(divider);

        // Sets up the left score and the right score labels
        leftScore = new PongScore_Label();
        leftScore.setSize(78,101);
        leftScore.setLocation(100,10);
        add(leftScore);
        rightScore = new PongScore_Label();
        rightScore.setSize(78,101);
        rightScore.setLocation(350,10);
        add(rightScore);

        // Sets up the score array as an int that holds 2 values, each starting as 0
        paddlesScore = new int[] {0,0};

        // Sets up the keyboard handler
        keyboardHandler handler = new keyboardHandler();
        addKeyListener(handler);

        this.startGame = startGame;
    }

    // This method continually updates the game
    // It calls each paddles and ball update methods
    public void updateGame(){
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

            // Check to see if the game's speed is consistently at its lowest point.
            // Ergo 5 milliseconds.
            if (gameSpeed < 5) gameSpeed = 5;
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            // Below uses an algorithm that can be explained on Line 126
            if((ball.getX() > 24 && ball.getX() < 36)){
                if(ball.getY() == leftPaddle.getY())
                    setBallLocationSpeed(9,1);

                else if(ball.getY() == leftPaddle.getY() + 10)
                    setBallLocationSpeed(7,1);

                else if(ball.getY() == leftPaddle.getY() + 20)
                    setBallLocationSpeed(5,1);

                else if(ball.getY() == leftPaddle.getY() + 30)
                    setBallLocationSpeed(3,1);

                else if(ball.getY() == leftPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 0)
                        ball.setDirection(1);
                    else
                        ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }

                else if(ball.getY() == leftPaddle.getY() + 50)
                    setBallLocationSpeed(3,3);

                else if(ball.getY() == leftPaddle.getY() + 60)
                    setBallLocationSpeed(5,3);

                else if(ball.getY() == leftPaddle.getY() + 70)
                    setBallLocationSpeed(7,3);

                else if(ball.getY() == leftPaddle.getY() + 80)
                    setBallLocationSpeed(9,3);
            }
            // If the ball is too far to the left
            else if(ball.getX() <= 0)
                scoreCount(false);
        }

        // RIGHT PADDLE COLLISION
        else if (ball.getDirection() == 1 || ball.getDirection() == 3){
            if((ball.getX() > 484 && ball.getX() < 496)){
                if(ball.getY() == rightPaddle.getY())
                    setBallLocationSpeed(9,0);

                else if(ball.getY() == rightPaddle.getY() + 10)
                    setBallLocationSpeed(7,0);

                else if(ball.getY() == rightPaddle.getY() + 20)
                    setBallLocationSpeed(5,0);

                else if(ball.getY() == rightPaddle.getY() + 30)
                    setBallLocationSpeed(3,0);

                else if(ball.getY() == rightPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 1)
                        ball.setDirection(0);
                    else
                        ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 50)
                    setBallLocationSpeed(3,2);

                else if(ball.getY() == rightPaddle.getY() + 60)
                    setBallLocationSpeed(5,2);

                else if(ball.getY() == rightPaddle.getY() + 70)
                    setBallLocationSpeed(7,2);

                else if(ball.getY() == rightPaddle.getY() + 80)
                    setBallLocationSpeed(9,2);

            }
            // If the ball is too far to the right
            else if(ball.getX() >= 550)
                scoreCount(true);
        }
    }
    // A method to setup the ball movement, direction, game speed, and play a sound effect
    private void setBallLocationSpeed(int movement, int direction){
        ball.setMovement(movement);
        ball.setDirection(direction);
        ball.playSoundEffect("ball_hit_paddle.wav");
        gameSpeed -=5;
    }

    // A method to add the score to either the left paddle or the right using said parameter
    private void scoreCount(boolean didLeftPaddleWin){
        // Plays the sound effect of paddle missing the ball
        ball.playSoundEffect("paddle_miss_ball.wav");
        // Sets the movement of the ball to 1
        ball.setMovement(1);
        // Sets the game to false, ergo it won't play until otherwise
        startGame = false;
        // Resets the gameSpeed to 100 milliseconds
        gameSpeed = 100;
        // Resets the ball location
        ball.setLocation(ball.getStartPosition());
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

    // The method for the construction of the frame to setup each paddle
    private void setupPaddles(PongPaddle_Label paddle, int x){
        paddle.setSize(15,85);
        paddle.setLocation(x,150);
        paddle.setVisible(true);
        add(paddle);
    }

    // The keyboard handler implements key listener
    // More information at location: javaswing_components.title_screen_components.PongTitleScreen_Frame Line 63
    private class keyboardHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {  }

        @Override
        public void keyPressed(KeyEvent e) {
            changeKeyInput(true,e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            changeKeyInput(false,e);
        }

        private void changeKeyInput(boolean toggle, KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_W) isWPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_S) isSPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_I) isIPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_K) isKPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_SPACE) isSPACEPressed = toggle;
        }

    }
}
