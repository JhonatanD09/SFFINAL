package views;

import javax.swing.*;
import java.awt.*;

public class JButtonMenu extends JButton{

    public JButtonMenu(String text, Icon rescaled){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JLabel txt = new JLabel(text);
        txt.setFont(new Font("gerogia", 0, 25));
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(txt, BorderLayout.NORTH);
        buttonPanel.add(new JLabel(rescaled), BorderLayout.CENTER);
        buttonPanel.setBackground(Color.WHITE);
        this.add(buttonPanel);
        this.setBorder(new RoundedBorder(30));
        this.setBackground(Color.WHITE);
    }

    public JButtonMenu(String text, Icon rescaled, int numb){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JLabel txt = new JLabel(text, JLabel.CENTER);
        txt.setFont(new Font("gerogia", 0, 17));
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(txt, BorderLayout.CENTER);
        buttonPanel.add(new JLabel(rescaled), BorderLayout.EAST);
        buttonPanel.setBackground(Color.WHITE);
        this.add(buttonPanel);
        this.setBorder(new RoundedBorder(30));
        this.setBackground(Color.WHITE);
    }
    
}
