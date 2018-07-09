package testing_components.leftpaddle_components;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paddles_JavaSwing_Test extends JFrame {
    private final JLabel leftPaddle;
    private final JLabel rightPaddle;

    public Paddles_JavaSwing_Test(){
        super("Paddles Testing Grounds");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        Icon paddleIcon =
                new ImageIcon(getClass().
                        getResource("leftPaddle.png"));
        leftPaddle = new JLabel();
        leftPaddle.setIcon(paddleIcon);
        leftPaddle.setSize(25,75);
        leftPaddle.setLocation(20,150);
        add(leftPaddle);

        rightPaddle = new JLabel();
        rightPaddle.setIcon(paddleIcon);
        rightPaddle.setSize(25,75);
        rightPaddle.setLocation(490,150);
        add(rightPaddle);


        KeyboardHandler handler = new KeyboardHandler();
        addKeyListener(handler);
        leftPaddle.addKeyListener(handler);
    }

    private class KeyboardHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
            int id = e.getID();

            if(id == KeyEvent.KEY_TYPED){
                if((e.getKeyChar() == 'w' || e.getKeyChar() == 'W')
                        && leftPaddle.getY() != 10){
                    System.out.println("You pressed W");
                    int y = leftPaddle.getY() - 10;
                    leftPaddle.setLocation(20,y);
                }
                else if ((e.getKeyChar() == 's' || e.getKeyChar() == 'S')
                        && leftPaddle.getY() != 320) {
                    System.out.println("You pressed S");
                    int y = leftPaddle.getY() + 10;
                    leftPaddle.setLocation(20,y);
                }
            }
            System.out.println(leftPaddle.getLocation());
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
