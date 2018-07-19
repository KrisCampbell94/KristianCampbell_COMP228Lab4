package javaswing_components.extra_setup;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LeftPaddle_JavaSwing_Test extends JPanel {
    private final JLabel leftPaddle;

    public final keyboardHandler handler;

    private boolean isWPressed;
    private boolean isSPressed;

    public LeftPaddle_JavaSwing_Test(){
        super(new BorderLayout());
        //setBackground(Color.black);
        //setSize(25,400);
        //setLocation(99,99);

        Icon paddleIcon =
                new ImageIcon(getClass().
                        getResource("paddle.png"));

        leftPaddle = new JLabel();
        leftPaddle.setIcon(paddleIcon);
        //leftPaddle.setSize(25,75);
        //leftPaddle.setLocation(20,150);
        add(leftPaddle);

        handler = new keyboardHandler();
        addKeyListener(handler);
    }

    public void LeftPaddleUpdate(){
        if(isWPressed && (leftPaddle.getY() > 10))
            paddleLocation(-10);
        else if(isSPressed && (leftPaddle.getY() < 320))
            paddleLocation(10);
    }
    private void paddleLocation(int y){
        leftPaddle.setLocation(20,leftPaddle.getY() + y);
        System.out.println(leftPaddle.getLocation());
    }
    private class keyboardHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            changeKeyInput(true,e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            //pressed.remove(e.getKeyChar());
            changeKeyInput(false,e);
        }
        private void changeKeyInput(boolean toggle, KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) isWPressed = toggle;
            if (e.getKeyCode() == KeyEvent.VK_S) isSPressed = toggle;
        }
    }

}
