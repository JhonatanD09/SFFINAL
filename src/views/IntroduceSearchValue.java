package views;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Commands;
import controllers.Controller;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

public class IntroduceSearchValue extends JPanel{
    public static final String IMAGE_PATH = "/images/Image_Search_Order.png";
    public int WIDTH = 0;
    public int HEIGHT = 0;
    private Controller controller;
	private JTextField textField;

    public IntroduceSearchValue(String criterio, Controller controller, int width, int height){
        setLayout(new GridLayout(6,1));
        this.controller = controller;
        this.WIDTH = width;
        this.HEIGHT = height;
        setPreferredSize(new Dimension((int) (width*0.8), (int) (height*0.5)));
        init(criterio);
    }

    public void init(String criterio){
        setBackground(Color.WHITE);
        //add(addWhitePanel());
        setIcon();
        add(new JLabel("Por favor ingrese el " + criterio + " en el siguiente cuadro:",  JLabel.CENTER));
        add(addWhitePanel());
        initIntroduceDataPanel(criterio);
        add(addWhitePanel());
    }


    private void initIntroduceDataPanel(String criterio){
        textField = new JTextField();
        textField.setBorder(BorderFactory.createTitledBorder("Criterio"));
        JButtonMenu button = createButton("Confirmar",  "/images/Image_Accept_Action.png",Commands.INTRODUCE_VALUE_SEARCH.name());
        JPanel dataPanel = new JPanel();
        dataPanel.setBackground(Color.WHITE);
        dataPanel.setLayout(new GridLayout(1,4));
        dataPanel.add(addWhitePanel());
        dataPanel.add(textField);
        dataPanel.add(button);
        dataPanel.add(addWhitePanel());
        add(dataPanel);
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
        Icon rescaledAdd = new ImageIcon(addImage.getScaledInstance((int) (WIDTH * 0.03),	(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(new JLabel(rescaledAdd)); 
        add(imagePanel);
    }

    public JPanel addWhitePanel(){
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        return whitePanel;
    }
    
    public String getCriterio() {
    	return textField.getText();
    }
}
