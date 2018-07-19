package javaswing_components.extra_setup.keylistener_components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputListener implements KeyListener {
    public static boolean isWPressed = false;
    public static boolean isSPressed = false;
    public static boolean isIPressed = false;
    public static boolean isKPressed = false;
    @Override
    public void keyPressed(KeyEvent e) {
        changeKeyInput(true,e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        changeKeyInput(false,e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void changeKeyInput(boolean toggle, KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_W) isWPressed = toggle;
        if(e.getKeyCode() == KeyEvent.VK_S) isSPressed = toggle;
        if(e.getKeyCode() == KeyEvent.VK_I) isIPressed = toggle;
        if(e.getKeyCode() == KeyEvent.VK_K) isKPressed = toggle;
    }
}
