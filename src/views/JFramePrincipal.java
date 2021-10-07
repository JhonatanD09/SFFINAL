package views;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

import controllers.Controller;
import models.Jobs;
import models.OrderMotor;

public class JFramePrincipal extends JFrame{

    private static final long serialVersionUID = 1L;

    public static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH_SIZE = (int) (dimension.getWidth());
    public static final int HEIGHT_SIZE = (int) (dimension.getHeight());
	public static final int M_WIDTH_SIZE = (int) (dimension.getWidth()*0.7);
	public static final int M_HEIGHT_SIZE = (int) (dimension.getHeight()*0.5);
    public static final String APP_NAME = "Rectimotor app";
    public JPanel principalPanel;
    private SelectSearch search;
	private JPanelOrder panelOrder;
	private IntroduceSearchValue value;
	private JPanelListOrder jPanelListOrder;
	private JPanelSeeOrder order;

    public JFramePrincipal(Controller control){
        this.principalPanel = new JPanel (new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        principalPanel.setBackground(Color.WHITE);
        this.setTitle(APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
        // this.setLayout( new GridLayout(3, 1));
        this.setLayout( new BorderLayout());
        init(control);
        setVisible(true);
        this.add(principalPanel, BorderLayout.CENTER);
    }

    private void init(Controller control) {
        principalPanel.setLayout(new GridLayout(3,1));
		this.setBackground(Color.white);
        JPanelMenu pane = new JPanelMenu(control, WIDTH_SIZE, HEIGHT_SIZE);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        principalPanel.add(panel1, BorderLayout.NORTH);
		principalPanel.add(pane, BorderLayout.CENTER);

	}

    public void loadAddOrderPanel(Controller control, OrderMotor order){
        panelOrder = new  JPanelOrder(control, order);
        principalPanel.removeAll();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.add(panelOrder, BorderLayout.CENTER);
        principalPanel.repaint();
        principalPanel.revalidate();
    }
    
    public void selectSearchPanel(Controller controller) {
    	 search = new  SelectSearch(WIDTH_SIZE, HEIGHT_SIZE,controller);
         principalPanel.removeAll();
         principalPanel.setLayout(new BorderLayout());
         principalPanel.add(search, BorderLayout.CENTER);
         principalPanel.repaint();
         principalPanel.revalidate();
    }
    
    public void returnInitialMenu(Controller control) {
        principalPanel.removeAll();
        init(control);
        principalPanel.repaint();
        principalPanel.revalidate();
    }
    
    public String dataHead() {
		return panelOrder.dataHead();
	}
    
    public ArrayList<Jobs> getJobs(){
    	return panelOrder.getJobs();
    }
    
    public ArrayList<String> getDataParts(){
    	return panelOrder.getDataParts();
    }
    
    public String getItemConsult() {
    	return search.itemSelecteToConsult();
    }

	public void panelInsertConsult(Controller controller, String criterio) {
		value = new  IntroduceSearchValue(criterio,controller,WIDTH_SIZE, HEIGHT_SIZE);
        principalPanel.removeAll();
        principalPanel.setLayout(new BorderLayout());
        principalPanel.add(value, BorderLayout.CENTER);
        principalPanel.repaint();
        principalPanel.revalidate();
	}
	
	public void panelListOrder(String filter, String filterValue, ArrayList<Object[]> data, Controller listener) {
		jPanelListOrder = new JPanelListOrder(filter, filterValue, data, listener);
		 principalPanel.removeAll();
	     principalPanel.setLayout(new BorderLayout());
	     principalPanel.add(jPanelListOrder, BorderLayout.CENTER);
	     principalPanel.repaint();
	     principalPanel.revalidate();
	}
	
	public void showOrderMotor(Controller controller, OrderMotor order) {
		 this.order = new JPanelSeeOrder(controller, order);
		 principalPanel.removeAll();
	     principalPanel.setLayout(new BorderLayout());
	     principalPanel.add(this.order, BorderLayout.CENTER);
	     principalPanel.repaint();
	     principalPanel.revalidate();
	}
	
	public String getCriterio() {
		return value.getCriterio();
	}
}
