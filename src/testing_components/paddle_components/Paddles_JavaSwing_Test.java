package testing_components.paddle_components;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
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


        keyboardHandler handler = new keyboardHandler();
        addKeyListener(handler);
        leftPaddle.addKeyListener(handler);
        rightPaddle.addKeyListener(handler);
    }

    private class keyboardHandler implements KeyListener{

        private final Set<Character> pressed = new HashSet<>();

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            pressed.add(e.getKeyChar());

            if(pressed.size() == 1) {
                if ((pressed.contains('w') || pressed.contains('W')) && (leftPaddle.getY() > 10))
                    paddleLocation(true, -10);
                else if ((pressed.contains('s') || pressed.contains('S')) && (leftPaddle.getY()  < 320))
                    paddleLocation(true, 10);

                if ((pressed.contains('i') || pressed.contains('I')) && (rightPaddle.getY() > 10))
                    paddleLocation(false, -10);
                else if ((pressed.contains('k') || pressed.contains('K')) && (rightPaddle.getY()  < 320))
                    paddleLocation(false, 10);
            }

            else if(pressed.size() > 1){
                if((pressed.contains('W') && pressed.contains('I'))
                        || (pressed.contains('w') && pressed.contains('i'))){
                    if(rightPaddle.getY() > 10)
                        paddleLocation(false, -10);

                    if(leftPaddle.getY() > 10)
                        paddleLocation(true, -10);
                }
                else if((pressed.contains('W') && pressed.contains('K'))
                        || (pressed.contains('w') && pressed.contains('k'))){
                    if(rightPaddle.getY() < 320)
                        paddleLocation(false, 10);

                    if(leftPaddle.getY() > 10)
                        paddleLocation(true, -10);
                }
                else if((pressed.contains('S') && pressed.contains('I'))
                        || (pressed.contains('s') && pressed.contains('i'))){
                    if(rightPaddle.getY() > 10)
                        paddleLocation(false, -10);

                    if(leftPaddle.getY() < 320)
                        paddleLocation(true, 10);
                }
                else if((pressed.contains('S') && pressed.contains('K'))
                        || (pressed.contains('s') && pressed.contains('k'))){
                    if(rightPaddle.getY() != 320)
                        paddleLocation(false, 10);

                    if(leftPaddle.getY() != 320)
                        paddleLocation(true, 10);
                }
            }
            System.out.println(leftPaddle.getLocation() + " " + rightPaddle.getLocation());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyChar());
        }

        private void paddleLocation(boolean isLeft, int y){
            if(isLeft)
                leftPaddle.setLocation(20,leftPaddle.getY() + y);
            else
                rightPaddle.setLocation(490,rightPaddle.getY() + y);

        }
    }
}
