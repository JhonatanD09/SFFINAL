package views;

import javax.swing.JPanel;

import controllers.Commands;

import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

public class SelectSearch extends JPanel{
    public static final String IMAGE_PATH = "/images/Image_Search_Order.png";
    public int WIDTH = 0;
    public int HEIGHT = 0;
    private ActionListener controller;
	private JComboBox<String> selectComboBox;

    public SelectSearch(int width, int height, ActionListener listener){
    	this.controller = listener;
        setLayout(new GridLayout(6,1));
        this.WIDTH = width;
        this.HEIGHT = height;
        setPreferredSize(new Dimension((int) (width*0.8), (int) (height*0.5)));
        init();
    }

    public void init(){
        setBackground(Color.WHITE);
        addWhitePanel();
        setIcon();
        add(new JLabel("Por favor seleccione un criterio de busqueda", JLabel.CENTER));
        initSelectComboBox();
        initButtons();
        addWhitePanel();
    }

    public void initButtons(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton("Continuar","/images/Image_Confirm.jpeg", Commands.SELECT_SEARCH.name()));
        buttonPanel.add(createButton("Cancelar","/images/Image_Deny.jpeg", Commands.CANCEL_SELECT_SEARCH.name()));
        buttonPanel.setBackground(Color.WHITE);
        add(buttonPanel);
    }

    public void initSelectComboBox(){
        selectComboBox = new JComboBox<>();
        selectComboBox.addItem("Buscar por fecha");
        selectComboBox.addItem("Buscar por taller");
        selectComboBox.addActionListener(controller);
        selectComboBox.setActionCommand(Commands.SELECT_SEARCH.name());
        JPanel selectPanel = new JPanel();
        selectPanel.setBackground(Color.WHITE);
        selectPanel.add(selectComboBox);
        add(selectPanel);
    }

    private JButtonMenu createButton(String buttonName, String imagePath, String actionCommand){
        Image updateImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
		Icon rescaledUpdate = new ImageIcon(updateImage.getScaledInstance((int) (WIDTH * 0.03),(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JButtonMenu button = new JButtonMenu(buttonName, rescaledUpdate);
        button.addActionListener(controller);
        button.setActionCommand(actionCommand);
        return button;
    }

    private void setIcon(){
        Image addImage = new ImageIcon(getClass().getResource(IMAGE_PATH)).getImage();
        Icon rescaledAdd = new ImageIcon(addImage.getScaledInstance((int) (WIDTH * 0.03),(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setLayout(new GridLayout(1,3));
        imagePanel.add(new JLabel(rescaledAdd)); 
        add(imagePanel);
    }

    public void addWhitePanel(){
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        add(whitePanel);
    }
    
    public String itemSelecteToConsult() {
    	return (String) selectComboBox.getSelectedItem();
    }
}
