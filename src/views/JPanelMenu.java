package views;

import javax.swing.border.EmptyBorder;

import controllers.Controller;
import controllers.Commands;

import java.awt.*;
import javax.swing.*;

public class JPanelMenu extends JPanel{
    
    private static final long serialVersionUID = 1L;
    public static final String PATH_IMAGE_ADD_ORDER = "/images/Image_Add_Order.png";
    public static final String PATH_IMAGE_SEARCH_ORDER = "/images/Image_Search_Order.png";
    public static final String PATH_IMAGE_UPDATE_ORDER = "/images/Image_Update_Order.png";

    public int WIDTH = 0;
    public int HEIGHT = 0;

    public JPanelMenu(Controller control, int width, int height){
        this.WIDTH = width;
        this.HEIGHT = height;
        this.setLayout(new GridLayout(1, 3, 15, 15) );
        setPreferredSize(new Dimension((int) (width*0.8), (int) (height*0.5)));
        this.setBorder(new EmptyBorder((int) (height*0.05), (int) (width*0.1),
        (int) (height*0.05), (int) (width*0.1)));
        this.setBackground(Color.WHITE);
        init(control);
        setVisible(true);
    }

    private void init(Controller control) {
        Image addImage = new ImageIcon(getClass().getResource(PATH_IMAGE_ADD_ORDER)).getImage();
		Icon rescaledAdd = new ImageIcon(addImage.getScaledInstance((int) (WIDTH * 0.03),
					(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JButton addMotor = new JButtonMenu("Registrar orden de ingreso", rescaledAdd);
        addMotor.setActionCommand(Commands.ADD_ORDER.name());
        addMotor.addActionListener(control);

        Image updateImage = new ImageIcon(getClass().getResource(PATH_IMAGE_UPDATE_ORDER)).getImage();
		Icon rescaledUpdate = new ImageIcon(updateImage.getScaledInstance((int) (WIDTH * 0.03),
					(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JButton updateMotor = new JButtonMenu("Actualizar orden", rescaledUpdate);
        updateMotor.setActionCommand(Commands.UPDATE_ORDER.name());
        updateMotor.addActionListener(control);

        Image searchImage = new ImageIcon(getClass().getResource(PATH_IMAGE_SEARCH_ORDER)).getImage();
		Icon rescaledSearch = new ImageIcon(searchImage.getScaledInstance((int) (WIDTH * 0.03),
					(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JButton searchMotor = new JButtonMenu("Buscar ordenes generadas", rescaledSearch);
        searchMotor.setActionCommand(Commands.SEARCH_ORDER.name());
        searchMotor.addActionListener(control);

        add(addMotor);
        add(updateMotor);
        add(searchMotor);
    }
}
