package testing_components.ball_components;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class Ball_JavaSwing_Test extends JFrame{
    private final JLabel ball;
    private final JLabel divider;

    private int ballDirection;
    private int ballMovement;

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
        ballMovement = 1;

        keyboardHandler handler = new keyboardHandler();
        addKeyListener(handler);
    }

    /*
    * Horizontal = GetY() + 0
    * 12Diagonal = GetY() + 3
    * 23Diagonal = GetY() + 5
    * 34Diagonal = GetY() + 8
    * 45Diagonal = GetY() + 10
    * 57Diagonal = GetY() + 13
    * 68Diagonal = GetY() + 15
    * 79Diagonal = GetY() + 18
    * Vertical = GetY() + 20 && GetX() + 0
    * */
   // // Y + 0
   // private void moveBall_Horizontal() throws InterruptedException{
   //     for (int i = 0; i >= 0; i++) {
   //         // Left == 0
   //         if (ballDirection == 0) {
   //             ball.setLocation(ball.getX() - 10, ball.getY());
   //             if (ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Right == 1
   //         else if (ballDirection == 1) {
   //             ball.setLocation(ball.getX() + 10, ball.getY());
   //             if (ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 3
   // private void moveBall_12Diagonal() throws InterruptedException{
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 3);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 3);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 3);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 3);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 5
   // private void moveBall_23Diagonal() throws InterruptedException{
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 5);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 5);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 5);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 5);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 8
   // private void moveBall_34Diagonal() throws InterruptedException{
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 8);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 8);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 8);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 8);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 10
   // private void moveBall_45Diagonal() throws InterruptedException {
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 10);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 10);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 10);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 10);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 13
   // private void moveBall_57Diagonal() throws InterruptedException {
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 13);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 13);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 13);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 13);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 15
   // private void moveBall_68Diagonal() throws InterruptedException {
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 15);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 15);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 15);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 15);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }
   // // Y + 18
   // private void moveBall_79Diagonal() throws InterruptedException {
   //     for (int i = 0; i >= 0; i++) {
   //         // Up Left == 0
   //         if(ballDirection == 0){
   //             ball.setLocation(ball.getX() - 10,ball.getY() - 18);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 2;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 1;
   //         }
   //         // Up Right == 1
   //         else if(ballDirection == 1){
   //             ball.setLocation(ball.getX() + 10,ball.getY() - 18);
   //             if(ball.getY() <= 10)
   //                 ballDirection = 3;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 0;
   //         }
   //         // Down Left == 2
   //         else if(ballDirection == 2){
   //             ball.setLocation(ball.getX() - 10,ball.getY() + 18);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 0;
   //             if(ball.getX() <= 10)
   //                 ballDirection = 3;
   //         }
   //         // Down Right == 3
   //         else if(ballDirection == 3){
   //             ball.setLocation(ball.getX() + 10,ball.getY() + 18);
   //             if(ball.getY() >= 390)
   //                 ballDirection = 1;
   //             if(ball.getX() >= 510)
   //                 ballDirection = 2;
   //         }
   //         Thread.sleep(100);
   //         System.out.println(ball.getLocation());
   //     }
   // }

    public void getBallMovement() throws InterruptedException{
        for (int i = 0; i >= 0; i++) {
            switch (ballMovement){

                case 1:
                    // Left == 0
                    if (ballDirection == 0 || ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY());
                        if (ball.getX() <= 10 ) {
                            if(ballDirection == 0) ballDirection = 1;
                            else ballDirection = 3;
                        }
                    }
                    // Right == 1
                    else if (ballDirection == 1 || ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY());
                        if (ball.getX() >= 510) {
                            if(ballDirection == 1) ballDirection = 0;
                            else ballDirection = 2;
                        }
                    }
                    break;

                case 2:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 3);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 3);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 3);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 3);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 3:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 5);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 5);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 5);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 5);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 4:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 8);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 8);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 8);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 8);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 5:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 10);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 10);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 10);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 10);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 6:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 13);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 13);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 13);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 13);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 7:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 15);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 15);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 15);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 15);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

                case 8:
                    //Up Left == 0
                    if (ballDirection == 0) {
                        ball.setLocation(ball.getX() - 10, ball.getY() - 18);
                        if (ball.getY() <= 10) ballDirection = 2;
                        if (ball.getX() <= 10) ballDirection = 1;
                    }
                    // Up Right == 1
                    else if (ballDirection == 1) {
                        ball.setLocation(ball.getX() + 10, ball.getY() - 18);
                        if (ball.getY() <= 10) ballDirection = 3;
                        if (ball.getX() >= 510) ballDirection = 0;
                    }
                    // Down Left == 2
                    else if (ballDirection == 2) {
                        ball.setLocation(ball.getX() - 10, ball.getY() + 18);
                        if (ball.getY() >= 390) ballDirection = 0;
                        if (ball.getX() <= 10) ballDirection = 3;
                    }
                    // Down Right == 3
                    else if (ballDirection == 3) {
                        ball.setLocation(ball.getX() + 10, ball.getY() + 18);
                        if (ball.getY() >= 390) ballDirection = 1;
                        if (ball.getX() >= 510) ballDirection = 2;
                    }
                    break;

            }
            Thread.sleep(100);
            System.out.println(ball.getLocation());
        }
    }

    private class keyboardHandler implements KeyListener {
        private final Set<Character> pressed = new HashSet<>();

        @Override
        public void keyTyped(KeyEvent e) {        }

        @Override
        public void keyPressed(KeyEvent e) {
            pressed.add(e.getKeyChar());
            if (pressed.size() == 1) {

                if (pressed.contains('1')) ballMovement = 1;

                else if (pressed.contains('2')) ballMovement = 2;

                else if (pressed.contains('3')) ballMovement = 3;

                else if (pressed.contains('4')) ballMovement = 4;

                else if (pressed.contains('5')) ballMovement = 5;

                else if (pressed.contains('6')) ballMovement = 6;

                else if (pressed.contains('7')) ballMovement = 7;

                else if (pressed.contains('8')) ballMovement = 8;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            pressed.remove(e.getKeyChar());
        }
    }
}
