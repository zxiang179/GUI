package project.RealEstateAgency.model;

public enum Gender {
	male, female;

	public static Gender get(String str) {
		if (str.equals(male.toString().equals(str)))
			return male;
		else
			return female;
	}
}
