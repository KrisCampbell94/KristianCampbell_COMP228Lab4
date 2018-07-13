package testing_components.paddle_ball_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import testing_components.ball_components.Ball_Label_Test;
import testing_components.paddle_components.Paddle_Label_Test;

public class Paddles_Ball_JavaSwing_Test extends JFrame {
    private final Paddle_Label_Test leftPaddle;
    private final Paddle_Label_Test rightPaddle;
    private final Ball_Label_Test ball;
    private final JLabel divider;

    private final keyboardHandler handler;

    private boolean isWPressed;
    private boolean isSPressed;
    private boolean isIPressed;
    private boolean isKPressed;
    private boolean isSPACEPressed;

    private int gameSpeed = 100;
    private boolean startGame = false;

    public Paddles_Ball_JavaSwing_Test(){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        leftPaddle = new Paddle_Label_Test();
        setupPaddles(leftPaddle,20);

        rightPaddle = new Paddle_Label_Test();
        setupPaddles(rightPaddle,490);

        ball = new Ball_Label_Test();
        ball.setSize(10,10);
        ball.setLocation(275,220);
        add(ball);
        ball.setStartPosition(new Point(275,220));

        Icon dividerIcon = new ImageIcon(getClass().getResource("divider.png"));
        divider = new JLabel();
        divider.setIcon(dividerIcon);
        divider.setSize(10,390);
        divider.setLocation(275,10);
        add(divider);

        handler = new keyboardHandler();
        addKeyListener(handler);
    }

    public void updateGame(){
        leftPaddle.paddleUpdate(isWPressed,isSPressed);
        rightPaddle.paddleUpdate(isIPressed,isKPressed);

        checkPaddleAndBallPosition();

        ball.ballUpdate();

        if(gameSpeed < 5) gameSpeed = 5;
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkPaddleAndBallPosition(){
        /* * Size Ball Paddle Add
           *  5 | 220 | 220 |  0
           *  4 | 220 | 210 | 10
           *  3 | 220 | 200 | 20
           *  2 | 220 | 190 | 30
           *  1 | 220 | 180 | 40
           *  2 | 220 | 170 | 50
           *  3 | 220 | 160 | 60
           *  4 | 220 | 150 | 70
           *  5 | 220 | 140 | 80
        * */

        // LEFT PADDLE COLLISION
        if(ball.getDirection() == 0 || ball.getDirection() == 2){
            if((ball.getX() > 24 && ball.getX() < 36)){
                if(ball.getY() == leftPaddle.getY()) {
                    ball.setMovement(9);
                    ball.setDirection(1);
                }
                else if(ball.getY() == leftPaddle.getY() + 10) {
                    ball.setMovement(7);
                    ball.setDirection(1);
                }
                else if(ball.getY() == leftPaddle.getY() + 20) {
                    ball.setMovement(5);
                    ball.setDirection(1);
                }
                else if(ball.getY() == leftPaddle.getY() + 30) {
                    ball.setMovement(3);
                    ball.setDirection(1);
                }
                else if(ball.getY() == leftPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 0)
                        ball.setDirection(1);
                    else
                        ball.setDirection(3);
                }
                else if(ball.getY() == leftPaddle.getY() + 50) {
                    ball.setMovement(3);
                    ball.setDirection(3);
                }
                else if(ball.getY() == leftPaddle.getY() + 60) {
                    ball.setMovement(5);
                    ball.setDirection(3);
                }
                else if(ball.getY() == leftPaddle.getY() + 70) {
                    ball.setMovement(7);
                    ball.setDirection(3);
                }
                else if(ball.getY() == leftPaddle.getY() + 80) {
                    ball.setMovement(9);
                    ball.setDirection(3);
                }
                gameSpeed -=5;
            }
            else if(ball.getX() <= 0){
                // BALL TOO FAR LEFT
            }
        }

        // RIGHT PADDLE COLLISION
        else if (ball.getDirection() == 1 || ball.getDirection() == 3){
            if((ball.getX() > 484 && ball.getX() < 496)){
                if(ball.getY() == rightPaddle.getY()) {
                    ball.setMovement(9);
                    ball.setDirection(0);
                }
                else if(ball.getY() == rightPaddle.getY() + 10) {
                    ball.setMovement(7);
                    ball.setDirection(0);
                }
                else if(ball.getY() == rightPaddle.getY() + 20) {
                    ball.setMovement(5);
                    ball.setDirection(0);
                }
                else if(ball.getY() == rightPaddle.getY() + 30) {
                    ball.setMovement(3);
                    ball.setDirection(0);
                }
                else if(ball.getY() == rightPaddle.getY() + 40) {
                    ball.setMovement(1);
                    if(ball.getDirection() == 1)
                        ball.setDirection(0);
                    else
                        ball.setDirection(2);
                }
                else if(ball.getY() == rightPaddle.getY() + 50) {
                    ball.setMovement(3);
                    ball.setDirection(2);
                }
                else if(ball.getY() == rightPaddle.getY() + 60) {
                    ball.setMovement(5);
                    ball.setDirection(2);
                }
                else if(ball.getY() == rightPaddle.getY() + 70) {
                    ball.setMovement(7);
                    ball.setDirection(2);
                }
                else if(ball.getY() == rightPaddle.getY() + 80) {
                    ball.setMovement(9);
                    ball.setDirection(2);
                }
                gameSpeed -=5;
            }
            else if(ball.getX() >= 550){
                // BALL TOO FAR RIGHT
            }
        }

    }

    private void setupPaddles(Paddle_Label_Test paddle, int x){
        paddle.setSize(15,85);
        paddle.setLocation(x,150);
        paddle.setVisible(true);
        add(paddle);
    }

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
