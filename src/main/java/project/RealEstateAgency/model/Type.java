package project.RealEstateAgency.model;

public enum Type {
	house, apartment, stdio, terrace;

	public static Type get(String str) {
		if (str.equals(house.toString().equals(str)))
			return house;
		else if (str.equals(apartment.toString().equals(str)))
			return apartment;
		else if (str.equals(stdio.toString().equals(str)))
			return stdio;
		else
			return terrace;
	}
}
