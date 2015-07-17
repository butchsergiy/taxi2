package com.edvantis.jt.case14.dao.mysql;

import java.sql.*;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.model.data.Order;
import com.edvantis.jt.case14.model.data.OrdersDB;
import com.edvantis.jt.case14.validator.OrderValidator;

public class OrderDAOJBDC extends OrderDAOabstract {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/taxiservice";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	private static final OrderDAOJBDC singleton = new OrderDAOJBDC(); // Singleton

	private OrderDAOJBDC() {

	}

	public static OrderDAOJBDC getReference() {
		return singleton;
	}

	Connection conn = null;
	Statement stmt = null;
	OrdersDB orderDB = OrdersDB.getReference();

	{
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readAllordersDB() {
		Order order;
		int n = 0;
		try {
			// STEP 2: Register JDBC driver
			// Class.forName("JDBC_DRIVER");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, dateAndTime, addr1, addr2, addr34, distance, orderCost, "
					+ "customerPhone, customerName, carNumber, carDriver, isDone FROM ordersdb";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setDateAndTime(rs.getTimestamp("dateAndTime"));
				order.setAddr1(rs.getString("addr1"));
				order.setAddr2(rs.getString("addr2"));
				order.setAddr34(rs.getString("addr34"));
				order.setDistance(rs.getFloat("distance"));
				order.setOrderCost(rs.getFloat("orderCost"));
				order.setCustomerPhone(rs.getString("customerPhone"));
				order.setCustomerName(rs.getString("customerName"));
				order.setCarNumber(rs.getString("carNumber"));
				order.setCarDriver(rs.getString("carDriver"));
				order.setIsDone(((rs.getInt("isDone")) != 0));
				orderDB.orderAdd(order);
				n++;
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally { // finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Read operation from DB done. Readed " + n
				+ " Orders.");
	}

	@Override
	public void addToOrdersDB(Order o) {

		try {
			// create a mysql database connection
			OrderValidator.orderDataIsValid(o);

			// Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// the mysql insert statement
			String query = " insert into ordersdb (id, dateAndTime, addr1, addr2, addr34, distance, orderCost,"
					+ " customerPhone, customerName, carNumber, carDriver, isDone)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, o.getId());
			preparedStmt.setTimestamp(2, o.getDateAndTime());
			preparedStmt.setString(3, o.getAddr1());
			preparedStmt.setString(4, o.getAddr2());
			preparedStmt.setString(5, o.getAddr34());
			preparedStmt.setFloat(6, o.getDistance());
			preparedStmt.setFloat(7, o.getOrderCost());
			preparedStmt.setString(8, o.getCustomerPhone());
			preparedStmt.setString(9, o.getCustomerName());
			preparedStmt.setString(10, o.getCarNumber());
			preparedStmt.setString(11, o.getCarDriver());
			preparedStmt.setBoolean(12, o.getIsDone());
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("---> Got an exception during inserting to DB!");
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void updateOrder(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delOrder(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
// MySQL ordersDB table:
// CREATE TABLE `taxiservice`.`ordersdb` (
// 1 `id` INT NOT NULL, AUTO_INCREMENT
// 2 `dateAndTime` DATETIME NULL,
// 3 `addr1` VARCHAR(45) NULL,
// 4 `addr2` VARCHAR(45) NULL,
// 5 `addr34` VARCHAR(45) NULL,
// 6 `distance` FLOAT NULL,
// 7 `orderCost` FLOAT NULL,
// 8 `customerPhone` VARCHAR(45) NULL,
// 9 `customerName` VARCHAR(45) NULL,
// 10 `carNumber` VARCHAR(45) NULL,
// 11 `carDriver` VARCHAR(45) NULL,
// 12 `isDone` BIT NULL,
// PRIMARY KEY (`id`));

// INSERT INTO `taxiservice`.`ordersdb` (`id`, `addr1`, `addr2`, `addr34`,
// `distance`, `orderCost`, `customerPhone`, `customerName`, `carNumber`,
// `carDriver`, `isDone`) VALUES ('1', 'aaaa1', 'sss2', 'ddd3', '35', '66',
// '2223344', 'Serg', 'cc1111cc', 'vova', '0');
// UPDATE `taxiservice`.`ordersdb` SET `distance`='11', `orderCost`='111',
// `customerPhone`='1112233', `isDone`='1' WHERE `id`='1';

