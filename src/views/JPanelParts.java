package views;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Color;
import controllers.Controller;

public class JPanelParts extends JPanel {
    private Controller controller;
    
    public JPanelParts(Controller controller){
        this.controller = controller;
        init();
    }

    public void init(){
        setLayout(new GridLayout(1,7));
        setParts();
        setQuantity();
        setMeasures();
    }

    public void setParts(){
        JPanel parts = new JPanel();
        parts.setLayout(new GridLayout(11, 1));
        parts.setBackground(Color.white);
        parts.add(new JLabel("Partes recibidas", JLabel.CENTER));
        for(int i = 0; i < 10; i++){
            JCheckBox checkBox = new JCheckBox("Parte");
            checkBox.setBackground(Color.WHITE);
            parts.add(checkBox);
        }
        add(whitePanel());
        add(parts);
        add(whitePanel());
    }

    public void setQuantity(){
        JPanel quantity = new JPanel();
        quantity.setLayout(new GridLayout(21, 1));
        quantity.setBackground(Color.white);
        quantity.add(new JLabel("Cantidad", JLabel.CENTER));
        for(int i = 0; i < 10; i++){
            quantity.add(whitePanel());
            quantity.add(new JSpinner());
        }
        add(whitePanel());
        add(quantity);
        add(whitePanel());
    }

    public void setMeasures(){
        JPanel measures = new JPanel();
        measures.setLayout(new GridLayout(21, 1));
        measures.setBackground(Color.white);
        measures.add(new JLabel("Medidas", JLabel.CENTER));
        for(int i = 0; i < 10; i++){
            measures.add(whitePanel());
            measures.add(new JTextField());
        }
        add(whitePanel());
        add(measures);
        add(whitePanel());
    }

    public JPanel whitePanel(){
        JPanel emptyLayout = new JPanel();
        emptyLayout.setBackground(Color.WHITE);
        return emptyLayout;
    }
}
