package views;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import controllers.Commands;
import controllers.Controller;
import models.Jobs;
import models.OrderMotor;

public class JPanelOrder extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea area;
	private JPanel north;
	private JPanel center;
	private JPanel footer;
	private int HEIGHT, WIDTH;
	public static final String PATH_IMAGE_SAVE_ORDER = "/images/Image_Save_Order.png";
	public static final String PATH_IMAGE_RETURN = "/images/Image_Return.png";
	private ArrayList<newPart> newParts;
	private ArrayList<JCheckBox> jobs;
	private JTextField tallerName;
	private JTextField responName;
	private JTextField responPhone;
	private JLabel dateLabel;
	private JLabel taller;
	private JLabel numberMotor;
	private JLabel numberM;
	private JLabel responsable;
	private JLabel fecha;

	public JPanelOrder(Controller control, OrderMotor orderMotor) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = (int) dimension.getWidth();
		HEIGHT = (int) dimension.getHeight();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		newParts = new ArrayList<>();
		jobs = new ArrayList<>();
		north = createNorth(control, orderMotor);
		add(north, BorderLayout.NORTH);

		center = createCenter(control, orderMotor);
		add(center, BorderLayout.CENTER);

		footer = createSouth(control, orderMotor);
		add(footer, BorderLayout.SOUTH);

		setVisible(true);
	}

	public JPanel createNorth(Controller controller, OrderMotor orderMotor) {
		JPanel northPane = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		northPane.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		northPane.setBackground(Color.WHITE);
		if (orderMotor != null) {

			taller = new JLabel("Taller", JLabel.CENTER);
			taller.setBackground(Color.WHITE);
			taller.setOpaque(true);

			tallerName = new JTextField(orderMotor.getWorkshop());
			numberMotor = new JLabel("Numero de motor", JLabel.CENTER);
			numberMotor.setBackground(Color.WHITE);
			tallerName.setBorder(BorderFactory.createTitledBorder("Nombre del taller"));
			numberMotor.setOpaque(true);

			numberM = new JLabel(""+orderMotor.getId(), JLabel.CENTER);
			numberM.setBackground(Color.WHITE);
			numberM.setOpaque(true);
			numberM.setBorder(new RoundedBorder(5));

			responsable = new JLabel(orderMotor.getOwnerName(), JLabel.CENTER);
			responsable.setBackground(Color.WHITE);
			responsable.setOpaque(true);

			fecha = new JLabel("Fecha", JLabel.CENTER);
			fecha.setBackground(Color.WHITE);
			fecha.setOpaque(true);

			dateLabel = new JLabel(orderMotor.getArriveDate(), JLabel.CENTER);
			dateLabel.setBackground(Color.WHITE);
			dateLabel.setOpaque(true);
			dateLabel.setBorder(new RoundedBorder(5));

			responName = new JTextField(orderMotor.getOwnerName());
			responName.setBorder(BorderFactory.createTitledBorder("Nombre del responsabe"));
			responPhone = new JTextField(orderMotor.getOwnerPhone());
			responPhone.setBorder(BorderFactory.createTitledBorder("Numero de telefono"));
		} else {

			taller = new JLabel("Taller", JLabel.CENTER);
			taller.setBackground(Color.WHITE);
			taller.setOpaque(true);

			tallerName = new JTextField();
			 numberMotor = new JLabel("Numero de motor", JLabel.CENTER);
			numberMotor.setBackground(Color.WHITE);
			tallerName.setBorder(BorderFactory.createTitledBorder("Nombre del taller"));
			numberMotor.setOpaque(true);

			 numberM = new JLabel("pendiente de asignacion", JLabel.CENTER);
			numberM.setBackground(Color.WHITE);
			numberM.setOpaque(true);
			numberM.setBorder(new RoundedBorder(5));

			 responsable = new JLabel("Responsable", JLabel.CENTER);
			responsable.setBackground(Color.WHITE);
			responsable.setOpaque(true);

			fecha = new JLabel("Fecha", JLabel.CENTER);
			fecha.setBackground(Color.WHITE);
			fecha.setOpaque(true);

			dateLabel = new JLabel(LocalDate.now() + "", JLabel.CENTER);
			dateLabel.setBackground(Color.WHITE);
			dateLabel.setOpaque(true);
			dateLabel.setBorder(new RoundedBorder(5));

			responName = new JTextField();
			responName.setBorder(BorderFactory.createTitledBorder("Nombre del responsabe"));
			responPhone = new JTextField();
			responPhone.setBorder(BorderFactory.createTitledBorder("Numero de telefono"));
		}
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
		northPane.add(fecha, gbc);

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

	public JPanel createCenter(Controller controller, OrderMotor orderMotor) {
		JPanel centerPane = new JPanel(new GridBagLayout());
		GridBagLayout gbl = new GridBagLayout();
		centerPane.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		centerPane.setBackground(Color.WHITE);

		newParts.add(new newPart("Bloque"));
		newParts.add(new newPart("Ciguenial"));
		newParts.add(new newPart("Culata"));
		newParts.add(new newPart("Pistones Usados"));
		newParts.add(new newPart("Bielas"));
		newParts.add(new newPart("Valvulas"));
		newParts.add(new newPart("Tapas de bancada"));
		newParts.add(new newPart("Eje de Levas"));
		newParts.add(new newPart("Carter"));
		newParts.add(new newPart("Tapon Resortes"));

		if (orderMotor != null) {
			for (String i : orderMotor.getEngineParts()) {
				String [] temp = i.split(","); 
				for (newPart parts : newParts) {
					if (parts.getName().equals(temp[0])) {
						parts.edit(true, Integer.parseInt(temp[1]),temp[2]);
					}
				}
			}
		}

		JLabel received = new JLabel("Partes recibidas", JLabel.CENTER);
		received.setBackground(Color.WHITE);
		JLabel cuantity = new JLabel("Cantidad", JLabel.CENTER);
		cuantity.setBackground(Color.WHITE);
		JLabel sizes = new JLabel("Medidas", JLabel.CENTER);

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

		for (int i = 1; i <= newParts.size(); i++) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.gridwidth = 3;
			gbc.gridheight = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = gbc.BOTH;
			centerPane.add(newParts.get(i - 1), gbc);
		}

		return centerPane;
	}

	public JPanel createSouth(Controller controller, OrderMotor orderMotor) {

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

		JCheckBox encamisarBloque = new JCheckBox("Encamisar Bloque");
		encamisarBloque.setBackground(Color.WHITE);
		jobs.add(encamisarBloque);

		JCheckBox rectificarBloque = new JCheckBox("Rectificar Bloque");
		rectificarBloque.setBackground(Color.WHITE);
		jobs.add(rectificarBloque);

		JCheckBox ciguenial = new JCheckBox("Ciguenial Kran Bielas");
		ciguenial.setBackground(Color.WHITE);
		jobs.add(ciguenial);

		JCheckBox culatas = new JCheckBox("Culatas, Valbulas Bases");
		culatas.setBackground(Color.WHITE);
		jobs.add(culatas);

		JCheckBox anillosBases = new JCheckBox("Anillos para Bases");
		anillosBases.setBackground(Color.WHITE);
		jobs.add(anillosBases);

		JCheckBox cambioGuias = new JCheckBox("Cambio de guias");
		cambioGuias.setBackground(Color.WHITE);
		jobs.add(cambioGuias);

		JCheckBox rimasGuias = new JCheckBox("Rimas guias");
		rimasGuias.setBackground(Color.WHITE);
		jobs.add(rimasGuias);

		JCheckBox cambioBujesAL = new JCheckBox("Cambio bujes arbol de levas");
		cambioBujesAL.setBackground(Color.WHITE);
		jobs.add(cambioBujesAL);

		JCheckBox rimarBielas = new JCheckBox("Rimada de bielas");
		rimarBielas.setBackground(Color.WHITE);
		jobs.add(rimarBielas);

		JCheckBox circuloBielas = new JCheckBox("Dar Circulo a bielas");
		circuloBielas.setBackground(Color.WHITE);
		jobs.add(circuloBielas);

		JCheckBox ensamblarPistones = new JCheckBox("Ensamblar pistones");
		ensamblarPistones.setBackground(Color.WHITE);
		jobs.add(ensamblarPistones);

		JCheckBox lavado = new JCheckBox("lavado");
		lavado.setBackground(Color.WHITE);
		jobs.add(lavado);

		JCheckBox agrandarBases = new JCheckBox("Agrandar bases");
		agrandarBases.setBackground(Color.WHITE);
		jobs.add(agrandarBases);

		JCheckBox cepillarCulata = new JCheckBox("Cepillado de culatas");
		cepillarCulata.setBackground(Color.WHITE);
		jobs.add(cepillarCulata);

		JCheckBox camisaCiguenial = new JCheckBox("Hacer camisa ciguenial");
		camisaCiguenial.setBackground(Color.WHITE);
		jobs.add(camisaCiguenial);

		JCheckBox arandelaAxial = new JCheckBox("Hacer arandela axial");
		arandelaAxial.setBackground(Color.WHITE);
		jobs.add(arandelaAxial);
		
		Image saveImage = new ImageIcon(getClass().getResource(PATH_IMAGE_SAVE_ORDER)).getImage();
		Icon rescaledSave = new ImageIcon(
				saveImage.getScaledInstance((int) (WIDTH * 0.03), (int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
		JButton saveMotor = new JButtonMenu("Guardar Informacion", rescaledSave, 1);
		
		saveMotor.addActionListener(controller);
		
		if (orderMotor!=null) {
			saveMotor.setActionCommand(Commands.UPDATE_ORDER_IN_DB.name());
			for (Jobs jb : orderMotor.getJobsList()) {
				for (JCheckBox jCheckBox : jobs) {
					if (job(jb).equals(jCheckBox.getText())) {
						jCheckBox.setSelected(true);
					}
				}
			}
		}else {
			saveMotor.setActionCommand(Commands.SAVE_ORDER.name());
		}

		

		Image returnImage = new ImageIcon(getClass().getResource(PATH_IMAGE_RETURN)).getImage();
		Icon rescaledReturn = new ImageIcon(
				returnImage.getScaledInstance((int) (WIDTH * 0.03), (int) (WIDTH * 0.03), Image.SCALE_SMOOTH));
		
		
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

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(encamisarBloque, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(anillosBases, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(rimarBielas, gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(agrandarBases, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(rectificarBloque, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(cambioGuias, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(circuloBielas, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(cepillarCulata, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(ciguenial, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(rimasGuias, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(ensamblarPistones, gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(camisaCiguenial, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(culatas, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(cambioBujesAL, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(lavado, gbc);

		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = gbc.BOTH;
		southPane.add(arandelaAxial, gbc);

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
		southPane.add(saveMotor, gbc);

		return southPane;
	}

	public String dataHead() {
			return tallerName.getText() + "," + responName.getText() + "," + responPhone.getText() + ","
					+ dateLabel.getText()+","+numberM.getText();
	}

	public ArrayList<String> getDataParts() {
		ArrayList<String> data = new ArrayList<>();
		for (newPart newPart : newParts) {
			if (newPart.getcBox().isSelected()) {
				data.add(newPart.getData());
			}
		}
		return data;
	}

	public ArrayList<Jobs> getJobs() {
		ArrayList<Jobs> jbs = new ArrayList<Jobs>();
		for (JCheckBox jobs : jobs) {
			if (jobs.isSelected()) {
				jbs.add(job(jobs.getText()));
			}
		}
		return jbs;
	}

	public Jobs job(String key) {
		switch (key) {
		case "Encamisar Bloque":
			return Jobs.ENCAMISAR_BLOQUE;
		case "Rectificar Bloque":
			return Jobs.RECTIFICAR_BLOQUE;
		case "Ciguenial Kran Bielas":
			return Jobs.CIGUENIAL;
		case "Culatas, Valbulas Bases":
			return Jobs.CULATAS;
		case "Anillos para Bases":
			return Jobs.ANILLOS_PARA_BASES;
		case "Cambio de guias":
			return Jobs.CAMBIO_DE_GUIAS;
		case "Rimas guias":
			return Jobs.RIMAS_GUIAS;
		case "Cambio bujes arbol de levas":
			return Jobs.CAMBIO_BUJES_ARBOL_LEVAS;
		case "Rimada de bielas":
			return Jobs.RIMADA_DE_BIELAS;
		case "Dar Circulo a bielas":
			return Jobs.CIRCULO_BIELAS;
		case "Ensamblar pistones":
			return Jobs.ENSAMBLAR_PISTONES;
		case "lavado":
			return Jobs.LAVADO;
		case "Agrandar bases":
			return Jobs.AGRANDAR_BASES;
		case "Cepillado de culatas":
			return Jobs.CEPILLADO_CULATAS;
		case "Hacer camisa ciguenial":
			return Jobs.CAMISA_CIGUENIAL;
		case "Hacer arandela axial":
			return Jobs.HACER_ARANDELA;
		}
		return null;
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
