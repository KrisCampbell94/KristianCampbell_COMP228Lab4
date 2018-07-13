package testing_components.paddle_ball_components;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import testing_components.paddle_components.LeftPaddle_JavaSwing_Test;
import testing_components.paddle_components.Paddle_Label_Test;

public class Paddles_Ball_JavaSwing_Test extends JFrame {
    private final Paddle_Label_Test leftPaddle;
    private final Paddle_Label_Test rightPaddle;
    private final JLabel divider;

    private final keyboardHandler handler;

    private boolean isWPressed;
    private boolean isSPressed;
    private boolean isIPressed;
    private boolean isKPressed;

    private int gameSpeed;

    public Paddles_Ball_JavaSwing_Test(){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        leftPaddle = new Paddle_Label_Test();
        setupPaddles(leftPaddle,20);

        rightPaddle = new Paddle_Label_Test();
        setupPaddles(rightPaddle,490);

        Icon dividerIcon = new ImageIcon(getClass().getResource("divider.png"));
        divider = new JLabel();
        divider.setIcon(dividerIcon);
        divider.setSize(10,390);
        divider.setLocation(275,10);
        add(divider);

        handler = new keyboardHandler();
        addKeyListener(handler);

        gameSpeed = 100;
    }

    public void updateGame(){
        leftPaddle.paddleUpdate(isWPressed,isSPressed);
        rightPaddle.paddleUpdate(isIPressed,isKPressed);

        if(gameSpeed < 10) gameSpeed = 10;
        try {
            Thread.sleep(gameSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setupPaddles(Paddle_Label_Test paddle, int x){
        paddle.setSize(25,75);
        paddle.setLocation(x,150);
        paddle.setVisible(true);
        add(paddle);
    }

    private class keyboardHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

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
        }

    }
}
