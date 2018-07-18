package testing_components.title_screen_components;

import testing_components.pong_game.Pong_Game_Test;
import testing_components.score_components.FinalScore_Frame_Test;

public class TitleScreen_Driver {
    public static void main(String[] args) {
        TitleScreen_Test titleFrame = new TitleScreen_Test();

        for (int i = 0; i >= 0 ; i++) {
            titleFrame.setDefaultCloseOperation(titleFrame.EXIT_ON_CLOSE);
            titleFrame.setSize(550, 450);
            titleFrame.setVisible(true);

            if(titleFrame.getIsSPACEPressed() || titleFrame.getIsQPressed())
                break;
        }
        titleFrame.setVisible(false);
        if(titleFrame.getIsSPACEPressed()){
            Pong_Game_Test gameFrame = new Pong_Game_Test(true);
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
            FinalScore_Frame_Test scoreFrame;
            if(gameFrame.getPaddlesScore()[0] == 11)
                scoreFrame = new FinalScore_Frame_Test(true);
            else
                scoreFrame = new FinalScore_Frame_Test(false);
            scoreFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
            scoreFrame.setSize(550, 450);
            scoreFrame.setVisible(true);
        }
        else if (titleFrame.getIsQPressed()){
            System.exit(0);
        }
    }
}
