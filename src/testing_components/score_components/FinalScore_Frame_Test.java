package testing_components.score_components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinalScore_Frame_Test extends JFrame {
    private final JLabel result;

    public FinalScore_Frame_Test(boolean didLeftWin){
        super("PONG");
        getContentPane().setBackground(Color.black);
        setLayout(null);
        result = new JLabel();
        result.setSize(235,19);
        result.setLocation(150,250);
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
