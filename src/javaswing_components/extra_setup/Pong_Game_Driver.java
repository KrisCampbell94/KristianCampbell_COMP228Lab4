package javaswing_components.extra_setup;

import javaswing_components.pong_game.PongGame_Frame;

public class Pong_Game_Driver {
    public static void main(String[] args) {
        PongGame_Frame frame = new PongGame_Frame(false);
        for (int i = 0; i >= 0; i++) {
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            frame.setSize(550, 450);
            frame.setVisible(true);
            frame.updateGame();
        }
    }
}
