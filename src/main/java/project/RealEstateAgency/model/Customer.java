package project.RealEstateAgency.model;

public class Customer {
	private String name;
	private String emailAddress;
	private String password;
	private String phoneNo;
	private Gender gender;
	private Type type;

	public Customer() {

	}

	public Customer(String name, String emailAddress, Gender gender) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:" + this.name);
		sb.append("\nemailAddress:" + this.emailAddress);
		sb.append("\npassword:" + this.password);
		sb.append("\nphoneNo:" + this.phoneNo);
		sb.append("\ngender:" + this.gender.toString());
		sb.append("\ntype:" + this.type);
		return sb.toString();
	}

}
