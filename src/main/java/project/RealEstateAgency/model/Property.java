package project.RealEstateAgency.model;

public class Property {

	private String state;
	private String suburb;
	private double rentalPrice;
	private double buyPrice;
	private Type type;
	private String description;
	private Status status;
	private String contactName;
	private String phoneNo;
	private int numOfBedrooms;
	private int numOfBathrooms;
	private int numOfParkingroomsSpace;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getNumOfBedrooms() {
		return numOfBedrooms;
	}

	public void setNumOfBedrooms(int numOfBedrooms) {
		this.numOfBedrooms = numOfBedrooms;
	}

	public int getNumOfBathrooms() {
		return numOfBathrooms;
	}

	public void setNumOfBathrooms(int numOfBathrooms) {
		this.numOfBathrooms = numOfBathrooms;
	}

	public int getNumOfParkingroomsSpace() {
		return numOfParkingroomsSpace;
	}

	public void setNumOfParkingroomsSpace(int numOfParkingroomsSpace) {
		this.numOfParkingroomsSpace = numOfParkingroomsSpace;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("state:" + this.state);
		sb.append("\nsuburb:" + this.suburb);
		sb.append("\nrentalPrice:" + this.rentalPrice);
		sb.append("\nbuyPrice:" + this.buyPrice);
		if (this.type != null)
			sb.append("\ntype:" + this.type.toString());
		sb.append("\ndescription:" + this.description);
		if (this.status != null)
			sb.append("\nstatus:" + this.status.toString());
		sb.append("\ncontactName:" + this.contactName);
		sb.append("\nphoneNo:" + this.phoneNo);
		sb.append("\nnumOfBedrooms:" + this.numOfBedrooms);
		sb.append("\nnumOfBathrooms:" + this.numOfBathrooms);
		sb.append("\nnumOfParkingroomsSpace:" + this.numOfParkingroomsSpace);
		return sb.toString();
	}

}
