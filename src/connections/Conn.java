package connections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Jobs;
import models.OrderMotor;

public class Conn {

	private Connection connection;
	private Statement statement;
	private String filter;

	public void initConnection() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/rectimotor?user=root&password=");
		this.statement = connection.createStatement();
		statement.setQueryTimeout(15);
	}

	// **********************Agregar orden a la base de datos
	// ******************************

	private int getId() throws SQLException {
		this.initConnection();
		ResultSet resultSet = this.statement.executeQuery("SELECT * FROM clientes");
		ArrayList<Integer> ids = new ArrayList<>();
		while (resultSet.next()) {
			ids.add(resultSet.getInt("ID_CLIENTE"));
		}
		this.connection.close();
		if (ids.size() == 0) {
			return 1;
		} else {
			return (ids.get(ids.size() - 1));
		}
	}

	public int getIdOrder() throws SQLException {
		this.initConnection();
		ResultSet resultSet = this.statement.executeQuery("SELECT ID_ORDEN  FROM ordenes");
		ArrayList<Integer> ids = new ArrayList<>();
		while (resultSet.next()) {
			ids.add(resultSet.getInt("ID_ORDEN"));
		}
		this.connection.close();
		if (ids.size() == 0) {
			return 1;
		} else {
			return (ids.get(ids.size() - 1));
		}
	}

	public boolean createOrder(OrderMotor order) throws SQLException {
		this.initConnection();
		boolean isInsertClient = insertClient(order);
		boolean isOrder = insertOrder(order);
		int idOrder = getIdOrder();
		boolean isJob = insertJobs(order.getJobsList(), idOrder);
		boolean isPart = addParts(order.getEngineParts(), idOrder);
		this.connection.close();

		return isInsertClient && isOrder && isJob && isPart;
	}

	private boolean insertClient(OrderMotor order) throws SQLException {
		int resultInsertClient = this.statement.executeUpdate("INSERT INTO CLIENTES (NOMBRE,TELEFONO) VALUES ('"
				+ order.getOwnerName() + "','" + order.getOwnerPhone() + "');");
		this.connection.close();
		return resultInsertClient == 1;
	}

	private boolean insertOrder(OrderMotor order) throws SQLException {
		this.initConnection();
		int rowsIn = this.statement
				.executeUpdate("INSERT INTO ORDENES ( NOMBRE_TALLER, FECHA_ENTRADA,STATE_ORDER, ID_CLIENTE) "
						+ "VALUES ('" + order.getWorkshop() + "',DATE '" + order.getArriveDate() + "', '"
						+ order.getState() + "'," + getId() + ");");
		this.connection.close();
		return rowsIn == 1;
	}

	private boolean insertJobs(ArrayList<Jobs> jobs, int idOrder) throws SQLException {
		int count = 0;
		System.out.println(idOrder);
		for (Jobs jobsIterator : jobs) {
			System.out.println(jobsIterator.ordinal());
			this.initConnection();
			count += this.statement.executeUpdate("INSERT INTO ordenes_trabajos (ID_ORDEN, ID_TRABAJO)" + "VALUES("
					+ idOrder + "," + jobsIterator.ordinal()+1 + ");");
			this.connection.close();
		}
		this.connection.close();
		return count == jobs.size();
	}

	private boolean addParts(ArrayList<String> parts, int idOrder) throws SQLException {
		int x = 0;
		x = addPart(parts, idOrder, x);
		this.connection.close();
		return x == parts.size();
	}

	private int addPart(ArrayList<String> parts, int idOrder, int x) throws SQLException {
		for (String string : parts) {
			String[] temp = string.split(",");
			if (searchPart(temp[0]) == 0) {
				this.initConnection();
				this.statement.executeUpdate("INSERT INTO PARTES (NOMBRE) VALUES('" + temp[0] + "');");
				this.connection.close();
			} else {
				this.initConnection();
				x += this.statement.executeUpdate(
						"INSERT INTO ORDENES_PARTES (ID_ORDEN , ID_PARTE, CANTIDAD, MEDIDAS) " + "VALUES(" + idOrder
								+ "," + searchPart(temp[0]) + "," + Integer.parseInt(temp[1]) + ",'" + temp[2] + "');");
				;
				this.connection.close();
			}
		}
		return x;
	}

	private int searchPart(String partName) throws SQLException {
		this.initConnection();
		ResultSet resultSet = this.statement.executeQuery("SELECT * FROM partes p WHERE p.nombre = '" + partName + "'");
		int id = 0;
		while (resultSet.next()) {
			id = resultSet.getInt("ID_PARTE");
		}
		this.connection.close();
		return id;
	}

	private int searchPartInOrdersParts(String partName) throws SQLException {
		this.initConnection();
		ResultSet resultSet = this.statement
				.executeQuery("SELECT * FROM ordenes_partes  WHERE id_parte = " + searchPart(partName) + "");
		int id = 0;
		while (resultSet.next()) {
			id = resultSet.getInt("ID_PARTE");
		}
		this.connection.close();
		return id;
	}

	private int searchJobInOrdersJobs(int id,int idOrder) throws SQLException {
		this.initConnection();
		ResultSet resultSet = this.statement
				.executeQuery("SELECT * FROM ordenes_trabajos  WHERE id_trabajo = " + id + " AND id_orden =" +idOrder);
		int idTemp = 0;
		while (resultSet.next()) {
			idTemp = resultSet.getInt("ID_TRABAJO");
		}
		this.connection.close();
		return idTemp;
	}

	// ****************Parte de las consultas a la base de datos
	// **********************************

	public OrderMotor searchOrder(int id) throws SQLException {
		int idMotor = 0;
		String workshop = "";
		String ownerName = "";
		String ownerPhone = "";
		Date arriveDate = null;
		ArrayList<String> engineParts = new ArrayList<String>();
		String state = "";
		ArrayList<Jobs> jobsList = new ArrayList<Jobs>();

		this.initConnection();
		ResultSet resultSetOrder = this.statement.executeQuery("SELECT * FROM ordenes WHERE id_orden = '" + id + "'");

		while (resultSetOrder.next()) {
			idMotor = resultSetOrder.getInt("ID_ORDEN");
			workshop = resultSetOrder.getString("NOMBRE_TALLER");
			arriveDate = resultSetOrder.getDate("FECHA_ENTRADA");
		}
		this.connection.close();
		this.initConnection();
		ResultSet resultSetClient = this.statement.executeQuery(
				"SELECT c.NOMBRE, c.TELEFONO FROM clientes c, ordenes o WHERE c.id_cliente = o.id_cliente AND o.id_orden = '"
						+ id + "'");
		while (resultSetClient.next()) {
			ownerName = resultSetClient.getString("NOMBRE");
			ownerPhone = resultSetClient.getString("TELEFONO");
		}
		this.connection.close();
		this.initConnection();
		ResultSet resultSetJobs = this.statement.executeQuery(
				"SELECT t.id_trabajo FROM trabajos t, ordenes_trabajos o WHERE t.ID_TRABAJO = o.ID_TRABAJO AND o.ID_ORDEN ='"
						+ id + "'");
		while (resultSetJobs.next()) {
			jobsList.add(Jobs.values()[resultSetJobs.getInt("ID_TRABAJO")-1]);
		}
		this.connection.close();
		this.initConnection();
		ResultSet resultSetParts = this.statement.executeQuery(
				"SELECT p.nombre ,op.cantidad, op.MEDIDAS FROM partes p, ordenes_partes op WHERE p.ID_PARTE = op.ID_PARTE AND op.ID_ORDEN ='"
						+ id + "'");

		while (resultSetParts.next()) {
			engineParts.add(resultSetParts.getString("NOMBRE") + "," + resultSetParts.getInt("CANTIDAD") + ","
					+ resultSetParts.getString("MEDIDAS"));
		}
		this.connection.close();

		OrderMotor orderMotor = new OrderMotor(workshop, ownerName, ownerPhone, "" + arriveDate, engineParts, jobsList);
		orderMotor.setId(idMotor);
		orderMotor.setState(state);
		return orderMotor;
	}

//	*************** filtrar informacion por criterios de busqueda ***************

	public ArrayList<Object[]> filterForDate( String data) throws SQLException {
		ArrayList<Object[]> info = new ArrayList<Object[]>();
		this.initConnection();
		ResultSet resultFilerInfo = null;
		System.out.println("filtro" +filter);
		if (filter.equals("Buscar por fecha")) {
			System.out.println("aqui");
			System.out.print("entra");
			resultFilerInfo = this.statement.executeQuery(
					"SELECT id_orden, fecha_entrada FROM ordenes WHERE fecha_entrada = DATE '" + data + "'");
		} else {
			resultFilerInfo = this.statement
					.executeQuery("SELECT id_orden, fecha_entrada FROM ordenes WHERE nombre_taller = '" + data + "'");
		}
		while (resultFilerInfo.next()) {
			Object[] dataFiler = new Object[2];
			dataFiler[0] = resultFilerInfo.getInt("ID_ORDEN");
			dataFiler[1] = "" + resultFilerInfo.getDate("FECHA_ENTRADA");
			info.add(dataFiler);
		}
		this.connection.close();
		return info;
	}

//	*********************** Editar informacion **********************************

	public boolean editOrder(OrderMotor order) throws SQLException {
		this.initConnection();
		boolean updateClient = updateClient(order.getOwnerName(), order.getOwnerPhone(), order.getId());
		boolean updateOrder = updateOrder(order.getWorkshop(), order.getArriveDate(), order.getState(), order.getId());
		int count = updatePartsList(order);
		updateJobs(order);
		this.connection.close();
		return updateClient && updateOrder && count == order.getEngineParts().size();
	}

	private void updateJobs(OrderMotor order) throws SQLException {
		System.out.println(order.getId());
		for (Jobs jobsIterator : order.getJobsList()) {
			if (searchJobInOrdersJobs(jobsIterator.ordinal()+1, order.getId()) == 0) {
				System.out.println(jobsIterator);
				this.initConnection();
				System.out.println(jobsIterator.ordinal() + " " + order.getId());
				this.statement.executeUpdate("INSERT INTO ordenes_trabajos (ID_ORDEN, ID_TRABAJO)" + "VALUES("
						+ order.getId() + "," + (jobsIterator.ordinal()+1) + ");");
				this.connection.close();
			}
		}
		this.connection.close();
	}

	private int updatePartsList(OrderMotor order) throws SQLException {
		int count = 0;
		for (String parts : order.getEngineParts()) {
			String[] temp = parts.split(",");
			if (searchPartInOrdersParts(temp[0]) == 0) {
				if (searchPart(temp[0]) == 0) {
					this.initConnection();
					this.statement.executeUpdate("INSERT INTO PARTES (NOMBRE) VALUES('" + temp[0] + "');");
					this.connection.close();
				}
				this.initConnection();
				this.statement.executeUpdate("INSERT INTO ORDENES_PARTES (ID_ORDEN , ID_PARTE, CANTIDAD, MEDIDAS) "
						+ "VALUES(" + order.getId() + "," + searchPart(temp[0]) + "," + Integer.parseInt(temp[1]) + ",'"
						+ temp[2] + "');");
				this.connection.close();

				count++;
			} else {
				count += updatePart(order.getId(), searchPart(temp[0]), Integer.parseInt(temp[1]), temp[2]);
			}
		}
		return count;
	}

	private boolean updateClient(String name, String phoneNumber, int id) throws SQLException {
		this.initConnection();
		int rowsIn = this.statement.executeUpdate("UPDATE CLIENTES SET nombre='" + name + "',telefono= '" + phoneNumber
				+ "' WHERE id_cliente = " + id + ";");
		this.connection.close();
		return rowsIn == 1;
	}

	private boolean updateOrder(String workShop, String date, String state, int id) throws SQLException {
		this.initConnection();
		int rowsIn = this.statement.executeUpdate("UPDATE ORDENES SET nombre_taller='" + workShop
				+ "',fecha_entrada= DATE '" + date + "',state_order= '" + state + "'  WHERE id_orden = " + id + ";");
		this.connection.close();
		return rowsIn == 1;
	}

	private int updatePart(int idOrder, int idPart, int quantity, String measures) throws SQLException {
		this.initConnection();
		int rowsIn = this.statement.executeUpdate("UPDATE ORDENES_PARTES SET CANTIDAD=" + quantity + ",MEDIDAS='"
				+ measures + "' WHERE id_parte = " + idPart + " AND id_orden = " + idOrder + ";");
		this.connection.close();
		return rowsIn;
	}

	public static void main(String[] args) {
		Conn conn = new Conn();

		ArrayList<String> parts = new ArrayList<>();
		parts.add("Bloque,2,5mm");
		parts.add("Cauchos,2,1cm");
		parts.add("Bielas,2,1cm");
		ArrayList<Jobs> jbJobs = new ArrayList<>();
		jbJobs.add(Jobs.CAMBIO_DE_GUIAS);
		jbJobs.add(Jobs.AGRANDAR_BASES);
		jbJobs.add(Jobs.ANILLOS_PARA_BASES);
		jbJobs.add(Jobs.CEPILLADO_CULATAS);
		OrderMotor motor = new OrderMotor("taller x1", "Don prueba", "3102541201", "2021-09-12", parts, jbJobs);
		motor.setId(1);
		try {
			System.out.println(conn.editOrder(motor));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getFilter() {
		return filter;
	}
	
	public void setItemConsult(String itemConsult) {
		System.out.println(itemConsult);
		this.filter = itemConsult;
	}
}