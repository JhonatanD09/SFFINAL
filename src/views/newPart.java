package views;

import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;

import java.awt.*;

public class newPart extends JPanel{
     public JCheckBox cBox;
     public JSpinner localSpinner;
     public JTextField textF;
     private String name;
    
    public newPart(String name){
    	this.name = name;
    	setName(name);
        this.setBackground(Color.WHITE);
        GridLayout grid = new GridLayout(1, 3, 15, 10);
        this.setLayout(grid);
        cBox = new JCheckBox(name);
        cBox.setBackground(Color.WHITE);
        SpinnerModel sm = new SpinnerNumberModel(0, 0, 9, 1);
        localSpinner = new JSpinner(sm);
        ((DefaultEditor) localSpinner.getEditor()).getTextField().setEditable(false);
        textF = new JTextField();
        this.add(cBox);
        this.add(localSpinner);
        this.add(textF);

        setVisible(true);
    }
    
    public newPart(String name, int parts, String size){
        this.setBackground(Color.WHITE);
        GridLayout grid = new GridLayout(1, 3, 15, 10);
        this.setLayout(grid);
        cBox = new JCheckBox(name);
        cBox.setSelected(true);
        cBox.setEnabled(false);
        cBox.setBackground(Color.WHITE);
        localSpinner = new JSpinner();
        localSpinner.setValue(parts);
        localSpinner.setEnabled(false);
        textF = new JTextField();
        textF.setText(size);
        textF.setEnabled(false);
        this.add(cBox);
        this.add(localSpinner);
        this.add(textF);

        setVisible(true);
    }
	public void edit(boolean status,int quantity, String medices ) {
    	cBox.setSelected(status);
    	localSpinner.setValue(quantity);
    	textF.setText(medices);
    }
    
    public JCheckBox getcBox() {
		return cBox;
	}
    
    public String  getData() {
    	return name+","+(Integer)localSpinner.getValue()+","+textF.getText();
    }
}
