package views;

import javax.swing.*;

import controllers.Commands;

import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelButtonList extends JPanel{

    public JPanelButtonList(Object[] order, ActionListener listener){
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(1, 3, 10, 10));
        JLabel orderNum = new JLabel("numero de orden: "+order[0], JLabel.CENTER);
        JLabel orderDate = new JLabel("fecha de ingreso: "+order[1], JLabel.CENTER);
        JButton selection = new JButton("Seleccionar");
        selection.setName(""+order[0]);
        selection.setBackground(Color.WHITE);
        selection.setBorder(new RoundedBorder(15));
        selection.setActionCommand(Commands.SEARCH_ORDER_BY_ID.name());
        selection.addActionListener(listener);
        this.add(orderNum);
        this.add(orderDate);
        this.add(selection);
        this.setPreferredSize(new Dimension(80, 20));
    }
    
}
