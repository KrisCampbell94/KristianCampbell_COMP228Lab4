package javaswing_components.extra_setup.keylistener_components;

import java.awt.event.*;
import javax.swing.*;

public class KeyListener_JavaSwing_Test extends JFrame {
    private final JLabel label1;

    public KeyListener_JavaSwing_Test(){
        super("Key Listener Testing Grounds");

        label1 = new JLabel("Type any key.");
        add(label1);
        KeyboardHandler handler = new KeyboardHandler();
        addKeyListener(handler);
    }


    private class KeyboardHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            label1.setText(this.toString(e,"TYPED: "));
        }

        @Override
        public void keyPressed(KeyEvent e) {
            label1.setText(this.toString(e,"PRESSED: "));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            label1.setText(this.toString(e,"RELEASED: "));
        }

        public String toString( KeyEvent e, String keyStatus) {
            int id = e.getID();
            String key;
            if(id == KeyEvent.KEY_TYPED)
                key = "Key = " + e.getKeyChar();
            else
                key = "KeyCode = " + e.getKeyCode();

            return String.format("%s %s",keyStatus,key);
        }
    }
}
