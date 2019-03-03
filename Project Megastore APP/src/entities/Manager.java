package entities;

import entities.customers.User;

public class Manager extends User {
	private String internationalPhoneNumber;
	private int PIN;

	public Manager(String name, String surname, String username, String password, String address, String phoneNumber,
			String internationalPhoneNumber, int PIN) {
		super(name, surname, username, password, address, phoneNumber);
		this.internationalPhoneNumber = internationalPhoneNumber;
		this.PIN = PIN;
	}

	public int getPIN() {
		return PIN;
	}

	public String getInternationalPhoneNumber() {
		return internationalPhoneNumber;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("International Phone Number : " + internationalPhoneNumber + "\n");
	}

	public void addDiscount(int ID) {
	}
}
