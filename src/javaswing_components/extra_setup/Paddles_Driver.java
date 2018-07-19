package javaswing_components.extra_setup;

public class Paddles_Driver {
    public static void main(String[] args) {
        Paddles_JavaSwing_Test frame = new Paddles_JavaSwing_Test();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(550,450);
        frame.setVisible(true);
        //frame.paddleUpdate();
    }
}
