package javaswing_components.extra_setup.sound_effects;

import com.sun.tools.javac.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Sound_Driver {
    public static void main(String[] args) {
        playSound("paddle_miss_ball.wav");
    }

    public static synchronized void playSound(String filePath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream(filePath));
                    clip.open(inputStream);
                    clip.start();
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        }).start();
    }
}
