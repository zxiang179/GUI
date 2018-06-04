package project.RealEstateAgency.model;

public enum Status {
	rented, forSale, forRent, sold;
	public static Status get(String str) {
		if (str.equals(rented.toString().equals(str)))
			return rented;
		else if (str.equals(forSale.toString().equals(str)))
			return forSale;
		else if (str.equals(forRent.toString().equals(str)))
			return forRent;
		else
			return sold;
	}

}
