package views;

import javax.swing.*;

import controllers.Commands;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelListOrder extends JPanel{
    
    public JPanelListOrder(String searchCrit, String numSearch, ArrayList<Object[]> ordersList, ActionListener listener){

        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        this.setBackground(Color.WHITE);

        JLabel indicator = new JLabel(searchCrit, JLabel.CENTER);
        indicator.setOpaque(false);

        JLabel searchVal = new JLabel(numSearch, JLabel.CENTER);
        searchVal.setOpaque(false);
        searchVal.setBorder(new RoundedBorder(15));

        JLabel oopsLabel = new JLabel("¡Ooops!, parece que no encontraste la orden que buscabas, ¿Quieres regresar?", JLabel.CENTER);
        searchVal.setOpaque(false);
        searchVal.setBorder(new RoundedBorder(15));

        JButton returnButton = new JButton("Regresar");
        returnButton.setBackground(Color.WHITE);
        returnButton.setBorder(new RoundedBorder(15));
    	returnButton.setActionCommand(Commands.BACK_RESGISTER_ORDER.name());
        returnButton.addActionListener(listener);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        this.add(indicator, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        this.add(searchVal, gbc);

        JPanel buttonListContainer = new JPanel(new GridLayout(ordersList.size(), 1, 10, 15));
        buttonListContainer.setBackground(Color.WHITE);
        
        for (int i = 0; i < ordersList.size(); i++) {
            Object[] order = ordersList.get(i);
            JPanelButtonList buttonForList = new JPanelButtonList(order, listener);
            buttonListContainer.add(buttonForList, gbc);
        }
        JScrollPane scrull = new JScrollPane(buttonListContainer);
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 9.0;
        gbc.fill = gbc.BOTH;
        this.add(scrull, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        this.add(oopsLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        this.add(returnButton, gbc);


    }
}
