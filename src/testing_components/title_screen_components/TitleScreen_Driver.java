package testing_components.title_screen_components;

import testing_components.pong_game.Pong_Game_Test;

public class TitleScreen_Driver {
    public static void main(String[] args) {
        TitleScreen_Test titleFrame = new TitleScreen_Test();

        for (int i = 0; i >= 0 ; i++) {
            titleFrame.setDefaultCloseOperation(titleFrame.EXIT_ON_CLOSE);
            titleFrame.setSize(550, 450);
            titleFrame.setVisible(true);

            if(titleFrame.isSPACEPressed())
                break;
        }
        titleFrame.setVisible(false);

        Pong_Game_Test gameFrame = new Pong_Game_Test();
        for (int i = 0; i >= 0; i++) {
            gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
            gameFrame.setSize(550, 450);
            gameFrame.setVisible(true);
            if(gameFrame.getPaddlesScore()[0] == 11 ||
                    gameFrame.getPaddlesScore()[1] == 11)
                break;
            gameFrame.updateGame();
        }
        gameFrame.setVisible(false);
        if(gameFrame.getPaddlesScore()[0] == 11)
            System.out.println("Left Player WINS.");
        else
            System.out.println("Right Player WINS.");
    }
}
