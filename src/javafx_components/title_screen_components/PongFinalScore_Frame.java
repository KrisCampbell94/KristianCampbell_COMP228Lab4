package javafx_components.title_screen_components;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

// The class of the Final Score that extends the JFrame class
public class PongFinalScore_Frame extends JFrame {

    // Constructor of the class
    // Ask if the left paddle won. If not, then the right paddle won
    public PongFinalScore_Frame(boolean didLeftWin){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);
        JLabel result = new JLabel();
        result.setSize(235,19);
        result.setLocation(150,150);
        if(didLeftWin)
            result.setIcon(new ImageIcon(
                    getClass().getResource("LeftWins.png")
            ));
        else
            result.setIcon(new ImageIcon(
                    getClass().getResource("RightWins.png")
            ));
        add(result);
    }
}
