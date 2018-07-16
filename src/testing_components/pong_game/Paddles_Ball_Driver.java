package testing_components.pong_game;

public class Paddles_Ball_Driver {
    public static void main(String[] args) {
        Paddles_Ball_JavaSwing_Test frame = new Paddles_Ball_JavaSwing_Test();
        for (int i = 0; i >= 0; i++) {
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setSize(550, 450);
            frame.setVisible(true);
            frame.updateGame();
        }
    }
}
