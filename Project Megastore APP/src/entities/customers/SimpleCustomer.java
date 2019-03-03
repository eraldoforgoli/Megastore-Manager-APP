package entities.customers;

public class SimpleCustomer extends User {
	public SimpleCustomer(String name, String surname, String username, String password, String address,
			String phoneNumber) {
		super(name, surname, username, password, address, phoneNumber);
	}

	public static User createSimpleCustomer() {
		return (new SimpleCustomer("", "", "", "", "", ""));
	}
}
