package testing_components.ball_components;

public class Ball_Driver {
    public static void main(String[] args) throws InterruptedException  {
        Ball_JavaSwing_Test frame = new Ball_JavaSwing_Test();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(550,450);
        frame.setVisible(true);
        frame.moveBall();
    }
}
