package controllers;
import java.util.ArrayList;
import java.util.Scanner;

import entities.customers.*;
import entities.customers.User;


public class UserCreator {
	private int confirm;
	Scanner input;
	UsersFile file;
	ArrayList<User> usersToFile;

	public UserCreator() {
		confirm = 0;
		input = new Scanner(System.in);
		file = new UsersFile();
	}

	public void createUser() {

		/*
		 * Nje problem i object serialization eshte qe nuk te lejon ti besh append filit
		 * dmth ne momentin qe manager do te shtoje items , items ekzistues do te
		 * mbishkruhen prandaj, do ruajme ne ArrayList<Item>, te gjithe Items ekzistues
		 * ne file ,dhe me pas ketij ArrayListi i shtojme dhe objektet Items qe manageri
		 * shton si te reja Si perfundim, i shtojme ne file.
		 */

		file.openAndClose();
		usersToFile = new ArrayList<User>(file.readUsers());
		System.out.println("Press :  \n 1 to create Loyal Customer \n32to crate Group Customer\n"
				+ "3to create Customer Employee ");
		confirm = input.nextInt();
		User addUserToFile = null;

		while (confirm == 1 || confirm == 2 || confirm == 3) {
			if (confirm == 1) {

				LoyalCustomer user = (LoyalCustomer) LoyalCustomer.createLoyalCustomer();
				System.out.println("Enter User name :");
				user.setName(input.next());

				System.out.println("Enter User surname :");
				user.setSurname(input.next());

				System.out.println("Enter User username :");
				user.setUsername(input.next());

				System.out.println("Enter User address :");
				user.setAddress(input.next());

				System.out.println("Enter User phone number :");
				user.setPhoneNumber(input.next());

				addUserToFile = user;

			}

			if (confirm == 2) {
				GroupCustomer user = (GroupCustomer) GroupCustomer.createGroupCustomer();

				System.out.println("Enter User name :");
				user.setName(input.next());

				System.out.println("Enter User surname :");
				user.setSurname(input.next());

				System.out.println("Enter User username :");
				user.setUsername(input.next());

				System.out.println("Enter User address :");
				user.setAddress(input.next());

				System.out.println("Enter User phone number :");
				user.setPhoneNumber(input.next());

				addUserToFile = user;

			}

			if (confirm == 3) {
				CustomerEmployee user = (CustomerEmployee) CustomerEmployee.createCustomerEmployee();

				System.out.println("Enter User name :");
				user.setName(input.next());

				System.out.println("Enter User surname :");
				user.setSurname(input.next());

				System.out.println("Enter User username :");
				user.setUsername(input.next());

				System.out.println("Enter User address :");
				user.setAddress(input.next());

				System.out.println("Enter User phone number :");
				user.setPhoneNumber(input.next());

				addUserToFile = user;

			}

			if (addUserToFile != null) {
				usersToFile.add(addUserToFile);
				addUserToFile = null;
			}

			System.out.println(
					"Press : \n1 To create new Simple Customer  \n 2 to create Loyal Customer \n3 to crate Group Customer\n"
							+ "4 to create Customer Employee ");

			while (!input.hasNextInt()) {
				System.out.println("Incorrect input, integer expected \n Enter another number");
				input.next();
			}
			confirm = input.nextInt();
		}

		if (!usersToFile.isEmpty())
			file.addUsersToFile(usersToFile);

		System.out.println(" Users added are : \n");

		for (int i = 0; i < usersToFile.size(); i++) {
			usersToFile.get(i).printInfo();
			System.out.println();
		}
	}
}
