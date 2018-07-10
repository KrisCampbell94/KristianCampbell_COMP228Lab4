package testing_components.ball_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ball_JavaSwing_Test extends JFrame{
    private final JLabel ball;
    private final JLabel divider;
    private int ballDirection;
    public Ball_JavaSwing_Test(){
        super("Ball Testing Grounds");
        getContentPane().setBackground(Color.black);
        setLayout(null);
        Icon ballIcon = new ImageIcon(getClass().getResource("ball.jpg"));
        Icon dividerIcon = new ImageIcon(getClass().getResource("divider.png"));

        divider = new JLabel();
        divider.setIcon(dividerIcon);
        divider.setSize(10,390);
        divider.setLocation(275,10);
        add(divider);

        ball = new JLabel();
        ball.setIcon(ballIcon);
        ball.setSize(10,10);
        ball.setLocation(275,225);
        add(ball);
        ballDirection = 0;
    }

    public void moveBall() throws InterruptedException {
        for (int i = 0; i >= 0; i++) {
            // Up Left == 0
            if(ballDirection == 0){
                ball.setLocation(ball.getX() - 10,ball.getY() - 10);
                if(ball.getY() <= 10)
                    ballDirection = 2;
                if(ball.getX() <= 10)
                    ballDirection = 1;
            }
            // Up Right == 1
            else if(ballDirection == 1){
                ball.setLocation(ball.getX() + 10,ball.getY() - 10);
                if(ball.getY() <= 10)
                    ballDirection = 3;
                if(ball.getX() >= 510)
                    ballDirection = 0;
            }
            // Down Left == 2
            else if(ballDirection == 2){
                ball.setLocation(ball.getX() - 10,ball.getY() + 10);
                if(ball.getY() >= 390)
                    ballDirection = 0;
                if(ball.getX() <= 10)
                    ballDirection = 3;
            }
            // Down Right == 3
            else if(ballDirection == 3){
                ball.setLocation(ball.getX() + 10,ball.getY() + 10);
                if(ball.getY() >= 390)
                    ballDirection = 1;
                if(ball.getX() >= 510)
                    ballDirection = 2;
            }
            Thread.sleep(100);
            System.out.println(ball.getLocation());
        }
    }
}
