package project.RealEstateAgency;

import java.sql.SQLException;
import java.util.Date;

import project.RealEstateAgency.datautil.ConnectMYSQL;
import project.RealEstateAgency.model.Customer;
import project.RealEstateAgency.model.Gender;
import project.RealEstateAgency.model.Property;
import project.RealEstateAgency.model.Register;
import project.RealEstateAgency.model.Status;
import project.RealEstateAgency.model.Type;

public class Service {

	private static ConnectMYSQL connectMYSQL = new ConnectMYSQL();

	public static boolean login(String phone, String pwd) {
		Customer customer = null;
		try {
			customer = connectMYSQL.findCustomerByPhone(phone);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (customer != null && phone.equals(customer.getPhoneNo()) && pwd.equals(customer.getPassword()))
			return true;
		return false;
	}

	public static boolean register(String name, String em, String phone, String pw, String gender, String type) {
		Customer customer = new Customer();
		customer.setGender(Gender.get(gender));
		customer.setType(Type.get(type));
		customer.setEmailAddress(em);
		customer.setName(name);
		customer.setPassword(pw);
		customer.setPhoneNo(phone);
		Register register = new Register();
		register.setPhone(phone);
		register.setDate(new Date());
		try {
			connectMYSQL.insertCustomer(customer);
			connectMYSQL.insertRegister(register);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static String findByName(String name) {
		Customer customer = null;
		Register register = null;
		try {
			customer = connectMYSQL.findCustomerByName(name);
			if (customer != null) {
				register = connectMYSQL.findRegisterByPhone(customer.getPhoneNo());
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (customer == null) {
			return "Can not find this person!";
		}
		String str = customer.toString();

		str += "\nregister date:" + register.getDate().toString();
		return str;
	}

	public static boolean saveProperty(String state, String suburb, String rentalPrice, String buyPrice, String type,
			String description, String status, String contactName, String phone, String bedrooms, String bathrooms,
			String parking) {
		Property property = new Property();
		property.setState(state);
		property.setSuburb(suburb);
		property.setRentalPrice(Double.parseDouble(rentalPrice));
		property.setBuyPrice(Double.parseDouble(buyPrice));
		property.setType(Type.get(type));
		property.setDescription(description);
		property.setStatus(Status.get(status));
		property.setContactName(contactName);
		property.setPhoneNo(phone);
		property.setNumOfBedrooms(Integer.parseInt(bedrooms));
		property.setNumOfBathrooms(Integer.parseInt(bathrooms));
		property.setNumOfParkingroomsSpace(Integer.parseInt(parking));
		try {
			connectMYSQL.insertProperty(property);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static String getProperty(String state, String suburb) {
		Property property = null;
		try {
			property = connectMYSQL.findPropertyByStateAndSuburb(state, suburb);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (property == null)
			return "can not find this property!";
		return property.toString();
	}
}
