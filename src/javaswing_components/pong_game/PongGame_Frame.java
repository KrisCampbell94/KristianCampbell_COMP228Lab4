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

public class PongGame_Frame extends JFrame {

    private final PongPaddle_Label leftPaddle, rightPaddle;
    private final PongBall_Label ball;

    private final PongScore_Label leftScore, rightScore;

    private boolean isWPressed, isSPressed, isIPressed, isKPressed, isSPACEPressed;

    private int gameSpeed = 100;
    private boolean startGame;
    private int[] paddlesScore;
    public int[] getPaddlesScore() { return paddlesScore; }


    public PongGame_Frame(boolean startGame){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        leftPaddle = new PongPaddle_Label();
        setupPaddles(leftPaddle,20);

        rightPaddle = new PongPaddle_Label();
        setupPaddles(rightPaddle,490);

        ball = new PongBall_Label();
        ball.setSize(10,10);
        ball.setLocation(275,220);
        add(ball);
        ball.setStartPosition(new Point(275,220));

        JLabel divider = new JLabel();
        divider.setIcon(new ImageIcon(
                getClass().getResource("divider.png"))
        );
        divider.setSize(10,390);
        divider.setLocation(275,11);
        add(divider);

        leftScore = new PongScore_Label();
        leftScore.setSize(78,101);
        leftScore.setLocation(100,10);
        add(leftScore);

        rightScore = new PongScore_Label();
        rightScore.setSize(78,101);
        rightScore.setLocation(350,10);
        add(rightScore);

        paddlesScore = new int[] {0,0};

        keyboardHandler handler = new keyboardHandler();
        addKeyListener(handler);

        this.startGame = startGame;
    }

    public void updateGame(){
        if(startGame) {
            leftScore.setScoreLabel(false,paddlesScore[0]);
            rightScore.setScoreLabel(false,paddlesScore[1]);

            leftPaddle.paddleUpdate(isWPressed, isSPressed);
            rightPaddle.paddleUpdate(isIPressed, isKPressed);

            checkPaddleAndBallPosition();

            ball.ballUpdate();

            if (gameSpeed < 5) gameSpeed = 5;
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            leftScore.setScoreLabel(true,paddlesScore[0]);
            rightScore.setScoreLabel(true,paddlesScore[1]);
            if(isSPACEPressed)
                startGame = true;
        }
    }

    private void checkPaddleAndBallPosition(){
        // Size Ball Paddle Add
        // 5 | 220 | 220 |  0
        // 4 | 220 | 210 | 10
        // 3 | 220 | 200 | 20
        // 2 | 220 | 190 | 30
        // 1 | 220 | 180 | 40
        // 2 | 220 | 170 | 50
        // 3 | 220 | 160 | 60
        // 4 | 220 | 150 | 70
        // 5 | 220 | 140 | 80

        /*LEFT PADDLE COLLISION*/
        if(ball.getDirection() == 0 || ball.getDirection() == 2){
            if((ball.getX() > 24 && ball.getX() < 36)){
                if(ball.getY() == leftPaddle.getY()) {
                    ball.setMovement(9);
                    ball.setDirection(1);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 10) {
                    ball.setMovement(7);
                    ball.setDirection(1);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 20) {
                    ball.setMovement(5);
                    ball.setDirection(1);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 30) {
                    ball.setMovement(3);
                    ball.setDirection(1);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 0)
                        ball.setDirection(1);
                    else
                        ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 50) {
                    ball.setMovement(3);
                    ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 60) {
                    ball.setMovement(5);
                    ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 70) {
                    ball.setMovement(7);
                    ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == leftPaddle.getY() + 80) {
                    ball.setMovement(9);
                    ball.setDirection(3);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
            }
            else if(ball.getX() <= 0){
                // BALL TOO FAR LEFT
                scoreCount(false);
            }
        }

        /*RIGHT PADDLE COLLISION*/
        else if (ball.getDirection() == 1 || ball.getDirection() == 3){
            if((ball.getX() > 484 && ball.getX() < 496)){
                if(ball.getY() == rightPaddle.getY()) {
                    ball.setMovement(9);
                    ball.setDirection(0);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 10) {
                    ball.setMovement(7);
                    ball.setDirection(0);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 20) {
                    ball.setMovement(5);
                    ball.setDirection(0);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 30) {
                    ball.setMovement(3);
                    ball.setDirection(0);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 1)
                        ball.setDirection(0);
                    else
                        ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 50) {
                    ball.setMovement(3);
                    ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 60) {
                    ball.setMovement(5);
                    ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 70) {
                    ball.setMovement(7);
                    ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
                else if(ball.getY() == rightPaddle.getY() + 80) {
                    ball.setMovement(9);
                    ball.setDirection(2);
                    ball.playSoundEffect("ball_hit_paddle.wav");
                    gameSpeed -=5;
                }
            }
            else if(ball.getX() >= 550){
                // BALL TOO FAR RIGHT
                scoreCount(true);
            }
        }
    }

    private void scoreCount(boolean didLeftPaddleWin){
        ball.playSoundEffect("paddle_miss_ball.wav");
        ball.setMovement(1);
        startGame = false;
        gameSpeed = 100;
        ball.setLocation(ball.getStartPosition());
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
        System.out.println("Left Paddle : " + paddlesScore[0]
            + " | Right Paddle : " + paddlesScore[1]);
    }

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
