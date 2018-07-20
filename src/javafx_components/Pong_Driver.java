package javafx_components;

// Imports the packages for any classes that extends JFrame
import javaswing_components.pong_game.PongGame_Frame;
import javaswing_components.title_screen_components.PongFinalScore_Frame;
import javaswing_components.title_screen_components.PongTitleScreen_Frame;

// Class to Start PONG; uses the main method
public class Pong_Driver {
    public static void main(String[] args) {
        // A boolean for the while loop stop only when it's false
        boolean continueGame = true;
        while (continueGame){
            // Initializes the titleFrame for PONG
            PongTitleScreen_Frame titleFrame = new PongTitleScreen_Frame();

            // An integer for the while loops of the title screen and the game itself
            // Anything necessary for frames that have to be active until otherwise
            // Ergo, loop infinitely until an action happens
            int gameLoop = 0;
            while (gameLoop >= 0) {
                // Methods to set the default close operation, size, and visibility of the current frame
                titleFrame.setDefaultCloseOperation(titleFrame.EXIT_ON_CLOSE);
                titleFrame.setSize(550, 450);
                titleFrame.setVisible(true);

                // Break out of this while loop IF either Space or Q is pressed
                if(titleFrame.getIsSPACEPressed() || titleFrame.getIsQPressed())
                    break;
                gameLoop++;
            }
            // Closes the title screen frame, but not the application
            titleFrame.setVisible(false);

            // If Space is pressed, then start the game
            if(titleFrame.getIsSPACEPressed()) {
                // Sets up the actual game frame and sets start game to true
                // Ergo the game automatically starts
                PongGame_Frame gameFrame = new PongGame_Frame(true);

                // Loops forever until one player wins by scoring 11 points
                while (gameLoop >= 0) {
                    gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
                    gameFrame.setSize(550, 450);
                    gameFrame.setVisible(true);
                    if (gameFrame.getPaddlesScore()[0] == 11 ||
                            gameFrame.getPaddlesScore()[1] == 11)
                        break;
                    // Continually updates the game
                    gameFrame.updateGame();
                    gameLoop++;
                }
                gameFrame.setVisible(false);

                // Sets up the final score frame to call out the winner
                PongFinalScore_Frame scoreFrame;
                if (gameFrame.getPaddlesScore()[0] == 11)
                    scoreFrame = new PongFinalScore_Frame(true);
                else
                    scoreFrame = new PongFinalScore_Frame(false);

                scoreFrame.setDefaultCloseOperation(scoreFrame.EXIT_ON_CLOSE);
                scoreFrame.setSize(550, 450);
                scoreFrame.setVisible(true);
                // After approximately 5 seconds of waiting time, the frame closes and loops back to the title screen
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                scoreFrame.setVisible(false);
            }
            // If space isn't pressed but Q, then continueGame equals to false
            // Ergo, close the entire application
            else
                continueGame = false;
        }
        // Exits the program under the assumption that the program worked properly.
        System.exit(0);
    }
}
