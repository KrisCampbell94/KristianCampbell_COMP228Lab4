package testing_components.title_screen_components;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class TitleScreen_Test extends JFrame {
    private final JLabel title;
    private final JLabel message;
    private final Icon titleIcon;
    private final Icon messageIcon;

    private boolean isSPACEPressed;
    public boolean isSPACEPressed() { return isSPACEPressed; }

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

        messageIcon = new ImageIcon(
                getClass().getResource("PRESS SPACE.png")
        );
        message = new JLabel();
        message.setIcon(messageIcon);
        message.setSize(248,35);
        message.setLocation(150,300);
        add(message);

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
        }

    }
}
