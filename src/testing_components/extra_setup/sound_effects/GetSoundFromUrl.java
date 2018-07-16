package testing_components.extra_setup.sound_effects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.net.URL;

/* URL WORKS MUCH BETTER! */
public class GetSoundFromUrl {
    public static void main(String[] args) throws Exception {
        URL url = new URL(
                "http://cs.au.dk/~dsound/" +
                        "DigitalAudio.dir/Greenfoot/" +
                        "Pong.dir/sounds_ping_pong_" +
                        "8bit/ping_pong_8bit_plop.wav");
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream =
                AudioSystem.getAudioInputStream(url);
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JOptionPane.showMessageDialog(null,"Close to Exit!");
            }
        });
    }
}
