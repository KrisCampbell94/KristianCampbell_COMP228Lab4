package testing_components.pong_game;

public class Pong_Game_Driver {
    public static void main(String[] args) {
        Pong_Game_Test frame = new Pong_Game_Test(false);
        for (int i = 0; i >= 0; i++) {
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setSize(550, 450);
            frame.setVisible(true);
            frame.updateGame();
        }
    }
}
