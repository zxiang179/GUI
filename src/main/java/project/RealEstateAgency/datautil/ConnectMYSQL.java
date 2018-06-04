package project.RealEstateAgency.datautil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.RealEstateAgency.model.Customer;
import project.RealEstateAgency.model.Gender;
import project.RealEstateAgency.model.Property;
import project.RealEstateAgency.model.Register;
import project.RealEstateAgency.model.Status;
import project.RealEstateAgency.model.Type;

public class ConnectMYSQL {

	// 数据库驱动类名的字符串
	String driver = "com.mysql.jdbc.Driver";
	// 数据库连接串
	String url = "jdbc:mysql://127.0.0.1:3306/gui";
	// 用户名
	String username = "root";
	// 密码
	String password = "root";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Property findPropertyByStateAndSuburb(String state, String suburb)
			throws ClassNotFoundException, SQLException {
		String sql = "select * from property where state = '" + state + "' and suburb = '" + suburb + "'";
		ResultSet rs = getSelectResultSet(sql);
		return parseResult2Property(rs);

	}

	private Property parseResult2Property(ResultSet rs2) throws SQLException {
		Property property = null;
		while (rs.next()) {
			property = new Property();
			property.setBuyPrice(rs.getDouble("buyPrice"));
			property.setContactName(rs.getString("contact_name"));
			property.setDescription(rs.getString("description"));
			property.setNumOfBathrooms(rs.getInt("num_of_bathrooms"));
			property.setNumOfBedrooms(rs.getInt("num_of_bedrooms"));
			property.setNumOfParkingroomsSpace(rs.getInt("num_of_parkingrooms_space"));
			property.setPhoneNo(rs.getString("phone_no"));
			property.setRentalPrice(rs.getDouble("rentalPrice"));
			property.setState(rs.getString("state"));
			property.setStatus(Status.get(rs.getString("status")));
			property.setSuburb(rs.getString("suburb"));
			property.setType(Type.get(rs.getString("type")));

		}
		return property;
	}

	public void insertProperty(Property property) throws ClassNotFoundException, SQLException {
		String contactName = property.getContactName();
		double buyPrice = property.getBuyPrice();
		String description = property.getDescription();
		String suburb = property.getSuburb();
		int type = property.getType().ordinal();
		int numOfBathrooms = property.getNumOfBathrooms();
		int numOfBedrooms = property.getNumOfBedrooms();
		int numOfParkingroomsSpace = property.getNumOfParkingroomsSpace();
		String state = property.getState();
		double rentalPrice = property.getRentalPrice();
		String phoneNo = property.getPhoneNo();
		int status = property.getStatus().ordinal();
		String sql = "insert into property(state,suburb,rentalPrice,buyPrice,type,description,status,"
				+ "contact_name,phone_no,num_of_bedrooms,num_of_bathrooms,num_of_parkingrooms_space)" + "values('"
				+ state + "','" + suburb + "','" + rentalPrice + "','" + buyPrice + "','" + type + "','" + description
				+ "','" + status + "','" + contactName + "','" + phoneNo + "','" + numOfBedrooms + "','"
				+ numOfBathrooms + "','" + numOfParkingroomsSpace + "')";
		System.out.println(sql);
		updateSQL(sql);

	}

	public void insertRegister(Register register) throws ClassNotFoundException, SQLException {
		String phone = register.getPhone();
		Date date = register.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String sql = "insert into register(phone,date) " + "values('" + phone + "','" + sdf.format(date) + "')";
		System.out.println(sql);
		updateSQL(sql);
	}

	public Register findRegisterByPhone(String phone) throws ClassNotFoundException, SQLException {
		String sql = "select * from register where phone ='" + phone + "'";
		ResultSet rs = getSelectResultSet(sql);
		return parseResult2Register(rs);
	}

	private Register parseResult2Register(ResultSet rs) throws SQLException {
		Register register = null;
		while (rs.next()) {
			register = new Register();
			register.setPhone(rs.getString("phone"));
			register.setDate(rs.getDate("date"));
		}
		return register;
	}

	public void insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		String username = customer.getName();
		String email = customer.getEmailAddress();
		String password = customer.getPassword();
		String phone = customer.getPhoneNo();
		int gender = customer.getGender().ordinal();
		int type = customer.getType().ordinal();
		String sql = "insert into customer(name,email_address,password,phone_no,gender,type) " + "values('" + username
				+ "','" + email + "','" + password + "','" + phone + "','" + gender + "','" + type + "')";
		System.out.println(sql);
		updateSQL(sql);

	}

	public Customer findCustomerByPhone(String phone) throws SQLException, ClassNotFoundException {
		String sql = "select * from customer where phone_no ='" + phone + "'";
		ResultSet rs = getSelectResultSet(sql);
		return parseResult2Customer(rs);

	}

	public Customer findCustomerByName(String name) throws ClassNotFoundException, SQLException {
		String sql = "select * from customer where name ='" + name + "'";
		ResultSet rs = getSelectResultSet(sql);
		return parseResult2Customer(rs);
	}

	public Customer parseResult2Customer(ResultSet rs) throws SQLException {
		Customer customer = null;
		while (rs.next()) {
			customer = new Customer();
			customer.setName(rs.getString("name"));
			customer.setEmailAddress(rs.getString("email_address"));
			customer.setPassword(rs.getString("password"));
			customer.setPhoneNo(rs.getString("phone_no"));

			Gender gender = Gender.get(rs.getString("gender"));
			customer.setGender(gender);

			Type type = Type.get(rs.getString("type"));
			customer.setType(type);
		}
		return customer;
	}

	public void updateSQL(String sql) throws ClassNotFoundException, SQLException {
		// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
		Class.forName(driver);
		// 2、获取数据库连接
		conn = DriverManager.getConnection(url, username, password);
		// 3、获取数据库操作对象
		stmt = conn.createStatement();
		int executeUpdate = stmt.executeUpdate(sql);
		System.out.println(executeUpdate);
	}

	public ResultSet getSelectResultSet(String sql) throws SQLException, ClassNotFoundException {
		// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
		Class.forName(driver);
		// 2、获取数据库连接
		conn = DriverManager.getConnection(url, username, password);
		// 3、获取数据库操作对象
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		// 6、获取并操作结果集
		/*
		 * while (rs.next()) { System.out.println(rs.getInt("id"));
		 * System.out.println(rs.getString("name")); }
		 */
		return rs;

	}

}
