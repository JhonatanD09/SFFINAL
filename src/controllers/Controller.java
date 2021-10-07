package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import connections.Conn;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import models.Jobs;
import models.OrderMotor;
import sun.security.provider.JavaKeyStore.CaseExactJKS;
import views.JFramePrincipal;
import views.newPart;

public class Controller implements ActionListener {

	private JFramePrincipal view;
	private Conn conn;

	public Controller() {
		view = new JFramePrincipal(this);
		conn = new Conn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			switch (Commands.valueOf(e.getActionCommand())) {
			case ADD_ORDER:
				view.loadAddOrderPanel(this,null);
				break;

			case UPDATE_ORDER:
				int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
				view.loadAddOrderPanel(this, conn.searchOrder(id));
				break;

			case SEARCH_ORDER:
				view.selectSearchPanel(this);
				break;

			case BACK_RESGISTER_ORDER:
				int op = JOptionPane.showConfirmDialog(null, "Realmente desea regresar,podrias perder informacion",
						"Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (op == 0)
					view.returnInitialMenu(this);
				break;
			case SAVE_ORDER:
				int opSave = JOptionPane.showConfirmDialog(null, "Desea guardar?", "Confirmar salida",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opSave == 0) {
					String[] data = view.dataHead().split(",");
					if (conn.createOrder(
							new OrderMotor(data[0], data[1], data[2], data[3], view.getDataParts(), view.getJobs()))) {
						JOptionPane.showMessageDialog(view, "Agregado a la base de datos");
					} else {
						JOptionPane.showMessageDialog(view, "F");
					}
					view.returnInitialMenu(this);
				}
				break;
			case SELECT_SEARCH:
				conn.setItemConsult(view.getItemConsult());
				view.panelInsertConsult(this,conn.getFilter());
				break;
			case CANCEL_SELECT_SEARCH:
				view.returnInitialMenu(this);
				break;
			case INTRODUCE_VALUE_SEARCH:
				String filterValue = view.getCriterio();
				view.panelListOrder(conn.getFilter(), filterValue, conn.filterForDate(filterValue), this);
				break;
			case SEARCH_ORDER_BY_ID:
				int idOrder = Integer.parseInt(((JButton) e.getSource()).getName());
				view.showOrderMotor(this, conn.searchOrder(idOrder));
				break;
			case UPDATE_ORDER_IN_DB:
				int opUp = JOptionPane.showConfirmDialog(null, "Desea guardar?", "Confirmar salida",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (opUp == 0) {
					String[] data = view.dataHead().split(",");
					OrderMotor orderMotor = new OrderMotor(data[0], data[1], data[2], data[3], view.getDataParts(), view.getJobs());
					orderMotor.setId(Integer.parseInt(data[4]));
					if (conn.editOrder(orderMotor)) {
						JOptionPane.showMessageDialog(view, "Agregado a la base de datos");
					} else {
						JOptionPane.showMessageDialog(view, "F");
					}
					view.returnInitialMenu(this);
				}
				break;
			}
		} catch (Exception f) {
			f.printStackTrace();
		}
	}

}
