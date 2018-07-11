package testing_components.ball_components;

public class Ball_Driver {
    public static void main(String[] args) throws InterruptedException  {
        Ball_JavaSwing_Test frame = new Ball_JavaSwing_Test();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(550,450);
        frame.setVisible(true);
        //frame.moveBall_Horizontal();
        //frame.moveBall_12Diagonal();
        //frame.moveBall_23Diagonal();
        //frame.moveBall_34Diagonal();
        //frame.moveBall_45Diagonal();
        //frame.moveBall_57Diagonal();
        //frame.moveBall_68Diagonal();
        //frame.moveBall_79Diagonal();

        frame.getBallMovement();
    }
}
