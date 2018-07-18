package testing_components.title_screen_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen_Test extends JFrame {
    private final JLabel title;
    private final JLabel startMessage;
    private final JLabel quitMessage;
    private final Icon titleIcon;
    private final Icon startMessageIcon;
    private final Icon quitMessageIcon;

    private boolean isSPACEPressed;
    public boolean getIsSPACEPressed() { return isSPACEPressed; }

    private boolean isQPressed;
    public boolean getIsQPressed(){return isQPressed;}

    private keyboardHandler handler;

    public TitleScreen_Test(){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);

        titleIcon = new ImageIcon(
                getClass().getResource("Title.png")
        );
        title = new JLabel();
        title.setIcon(titleIcon);
        title.setSize(400,119);
        title.setLocation(70,50);
        add(title);

        startMessageIcon = new ImageIcon(
                getClass().getResource("Space.png")
        );
        startMessage = new JLabel();
        startMessage.setIcon(startMessageIcon);
        startMessage.setSize(235,19);
        startMessage.setLocation(150,250);
        add(startMessage);

        quitMessageIcon = new ImageIcon(
                getClass().getResource("Quit.png")
        );
        quitMessage = new JLabel();
        quitMessage.setIcon(quitMessageIcon);
        quitMessage.setSize(235,19);
        quitMessage.setLocation(150,300);
        add(quitMessage);

        handler = new keyboardHandler();
        addKeyListener(handler);

    }

    private class keyboardHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {  }

        @Override
        public void keyPressed(KeyEvent e) {
            changeKeyInput(true,e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            changeKeyInput(false,e);
        }

        private void changeKeyInput(boolean toggle, KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) isSPACEPressed = toggle;
            if(e.getKeyCode() == KeyEvent.VK_Q) isQPressed = toggle;
        }

    }
}
