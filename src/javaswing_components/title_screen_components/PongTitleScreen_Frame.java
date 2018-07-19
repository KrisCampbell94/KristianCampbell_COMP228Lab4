package javaswing_components.title_screen_components;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// The class of the Title Screen that extends the JFrame class
public class PongTitleScreen_Frame extends JFrame {

    // A boolean to ask if the space key is pressed
    private boolean isSPACEPressed;
    public boolean getIsSPACEPressed() { return isSPACEPressed; }

    // A boolean to ask if the Q key is pressed
    private boolean isQPressed;
    public boolean getIsQPressed(){return isQPressed;}

    // Constructor of the class
    public PongTitleScreen_Frame(){
        // Sets the title, background and layout respectively
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        // Creates and sets the JLabel for title
        // Displays the title of PONG through image, size, and location
        JLabel title = new JLabel();
        title.setIcon(new ImageIcon(
                getClass().getResource("Title.png")
        ));
        title.setSize(400,119);
        title.setLocation(70,50);
        add(title);

        // Creates and sets the parameters for the start message
        JLabel startMessage = new JLabel();
        startMessage.setIcon(new ImageIcon(
                getClass().getResource("Space.png")
        ));
        startMessage.setSize(235,19);
        startMessage.setLocation(150,250);
        add(startMessage);

        // Creates and sets the parameters for the quit message
        JLabel quitMessage = new JLabel();
        quitMessage.setIcon(new ImageIcon(
                getClass().getResource("Quit.png")
        ));
        quitMessage.setSize(235,19);
        quitMessage.setLocation(150,300);
        add(quitMessage);

        // Adds a keyboard handler to activate key events
        keyboardHandler handler = new keyboardHandler();
        addKeyListener(handler);

    }

    // The keyboard handler implements key listener
    // Made to detect key signatures made from the user
    // Ergo it knows when a key is pressed or not
    private class keyboardHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {  }

        // If a key is pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            changeKeyInput(true,e);
        }

        // If a key is released
        @Override
        public void keyReleased(KeyEvent e) {
            changeKeyInput(false,e);
        }

        // Changes the key input to true or false for the fields isSPACEPressed and isQPressed
        // This activates universal play and it's use is specifically shown within the game
        private void changeKeyInput(boolean toggle, KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) isSPACEPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_Q) isQPressed = toggle;
        }
    }
}
