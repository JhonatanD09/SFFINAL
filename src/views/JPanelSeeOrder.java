package views;

import javax.swing.*;

import controllers.Commands;
import controllers.Controller;
import models.Jobs;
import models.OrderMotor;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JPanelSeeOrder extends JPanel{

    
	private JPanel north;
	private JPanel center;
	private JPanel footer;
	private int HEIGHT, WIDTH;
    public static final String PATH_IMAGE_SAVE_ORDER = "/images/Image_Save_Order.png";
    public static final String PATH_IMAGE_RETURN = "/images/Image_Return.png";

    public JPanelSeeOrder(Controller control, OrderMotor order){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = (int) dimension.getWidth();
		HEIGHT = (int) dimension.getHeight();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
        
		north = createNorthOrder(control, order);
		add(north, BorderLayout.NORTH);
        
        center = createCenterOrder(control, order);
        add(center, BorderLayout.CENTER);
        
        footer = createSouthOrder(control, order);
        add(footer, BorderLayout.SOUTH);
        
		setVisible(true);
    }

    public JPanel createNorthOrder(Controller controller, OrderMotor order){
        JPanel northPane = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
            northPane.setLayout(gbl);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            northPane.setBackground(Color.WHITE);
    
            JLabel taller = new JLabel("Taller", JLabel.CENTER);
            taller.setBackground(Color.WHITE);
            taller.setOpaque(true);
    
            JTextField tallerName = new JTextField(order.getWorkshop(), 2);
            tallerName.setEditable(false);
    
            JLabel numberMotor = new JLabel("Numero de motor", JLabel.CENTER);
            numberMotor.setBackground(Color.WHITE);
            numberMotor.setOpaque(true);
    
            JLabel numberM = new JLabel("pendiente de asignacion", JLabel.CENTER);
            numberM.setBackground(Color.WHITE);
            numberM.setOpaque(true);
            numberM.setBorder(new RoundedBorder(5));
    
            JLabel responsable = new JLabel("Responsable", JLabel.CENTER);
            responsable.setBackground(Color.WHITE);
            responsable.setOpaque(true);
    
            JLabel Fecha = new JLabel("Fecha", JLabel.CENTER);
            Fecha.setBackground(Color.WHITE);
            Fecha.setOpaque(true);
    
            JLabel dateLabel = new JLabel(order.getArriveDate()+"", JLabel.CENTER);
            dateLabel.setBackground(Color.WHITE);
            dateLabel.setOpaque(true);
            dateLabel.setBorder(new RoundedBorder(5));
    
            JTextField responName = new JTextField(order.getOwnerName(), 1);
            responName.setEditable(false);
            JTextField responPhone = new JTextField(order.getOwnerPhone(), 1);
            responPhone.setEditable(false);
    
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(taller, gbc);
    
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(tallerName, gbc);
    
            gbc.gridx = 3;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(numberMotor, gbc);
    
            gbc.gridx = 4;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(numberM, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(responsable, gbc);
    
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(responName, gbc);
    
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(responPhone, gbc);
    
            gbc.gridx = 3;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(Fecha, gbc);
    
            gbc.gridx = 4;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            northPane.add(dateLabel, gbc);
    
    
            return northPane;
    
        }
     
    public JPanel createCenterOrder(Controller controller, OrderMotor order){

        JLabel received = new JLabel("Partes recibidas", JLabel.CENTER);
        received.setBackground(Color.WHITE);
        JLabel cuantity = new JLabel("Cantidad", JLabel.CENTER);
        cuantity.setBackground(Color.WHITE);
        JLabel sizes = new JLabel("Medidas", JLabel.CENTER);     
        sizes.setBackground(Color.WHITE);

        JPanel centerPane = new JPanel(new GridBagLayout());
        GridBagLayout gbl = new GridBagLayout();
        centerPane.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        centerPane.setBackground(Color.WHITE);       

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        centerPane.add(received, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        centerPane.add(cuantity, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        centerPane.add(sizes, gbc);

        
        ArrayList<String> engineParts = order.getEngineParts();
        int index = 1;
        for (String string : engineParts) {
            String[] part = string.split(",");
            newPart parte = new newPart(part[0], Integer.parseInt(part[1]), part[2]);
            gbc.gridx = 0;
            gbc.gridy = index;
            gbc.gridwidth = 3;
            gbc.gridheight = 1;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = gbc.BOTH;
            centerPane.add(parte, gbc);
            index++;
        }
        return centerPane;
    }

    public JPanel createSouthOrder(Controller controller, OrderMotor order){

        JPanel southPane = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        southPane.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        southPane.setBackground(Color.WHITE);

        JLabel jobsLabel = new JLabel("Trabajos a realizar", JLabel.CENTER);
        jobsLabel.setBackground(Color.WHITE);
        jobsLabel.setOpaque(true);
        jobsLabel.setBorder(new RoundedBorder(0));

        

//        Image saveImage = new ImageIcon(getClass().getResource(PATH_IMAGE_SAVE_ORDER)).getImage();
//		Icon rescaledSave = new ImageIcon(saveImage.getScaledInstance((int) (WIDTH * 0.03),
//					(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
//        JButton saveMotor = new JButtonMenu("Guardar Informacion", rescaledSave, 1);

        Image returnImage = new ImageIcon(getClass().getResource(PATH_IMAGE_RETURN)).getImage();
		Icon rescaledReturn = new ImageIcon(returnImage.getScaledInstance((int) (WIDTH * 0.03),
					(int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
        JButton returnButton = new JButtonMenu("Regresar", rescaledReturn, 1);
        returnButton.setActionCommand(Commands.BACK_RESGISTER_ORDER.name());
		returnButton.addActionListener(controller);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        southPane.add(jobsLabel, gbc);

        ArrayList<Jobs> jList = order.getJobsList();
        int xPos = 0;
        int yPos = 1; 
        for (Jobs jobs : jList) {
            if (yPos<5) {
                JCheckBox tempBox = new JCheckBox(job(jobs));
                tempBox.setBackground(Color.WHITE);
                tempBox.setSelected(true);
                tempBox.setEnabled(false);
                gbc.gridx = xPos;
                gbc.gridy = yPos;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.fill = gbc.BOTH;
                southPane.add(tempBox, gbc);
                yPos++;
            }else{
                yPos = 1;
                xPos++;
            }
        }
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
        southPane.add(returnButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = gbc.BOTH;
//        southPane.add(saveMotor, gbc);


        return southPane;
    }

    public String job(Jobs key) {
		switch (key) {
		case ENCAMISAR_BLOQUE:
			return "Encamisar Bloque";
		case RECTIFICAR_BLOQUE:
			return "Rectificar Bloque";
		case CIGUENIAL:
			return "Ciguenial Kran Bielas";
		case CULATAS:
			return "Culatas, Valbulas Bases";
		case ANILLOS_PARA_BASES:
			return "Anillos para Bases" ;
		case CAMBIO_DE_GUIAS:
			return "Cambio de guias";
		case RIMAS_GUIAS:
			return "Rimas guias";
		case CAMBIO_BUJES_ARBOL_LEVAS:
			return "Cambio bujes arbol de levas";
		case RIMADA_DE_BIELAS:
			return "Rimada de bielas";
		case CIRCULO_BIELAS:
			return "Dar Circulo a bielas";
		case ENSAMBLAR_PISTONES:
			return "Ensamblar pistones";
		case LAVADO:
			return "lavado";
		case AGRANDAR_BASES:
			return "Agrandar bases";
		case CEPILLADO_CULATAS:
			return "Cepillado de culatas";
		case CAMISA_CIGUENIAL:
			return "Hacer camisa ciguenial";
		case HACER_ARANDELA:
			return "Hacer arandela axial";
		}
		return null;
	}
   
}
