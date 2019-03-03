package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import entities.customers.*;

/*
 * Class the identifies a Customer when a cashier creates a new Basket
 */
public class CustomerController {
	private UsersFile users;
	private ArrayList<User> usersArrayList;

	public CustomerController() {
		users = new UsersFile();
	}

	public User getCustomer(String username) {
		users.openAndClose();
		usersArrayList = new ArrayList<User>(users.readUsers());

		for (int i = 0; i < usersArrayList.size(); i++) {
			if (usersArrayList.get(i).getUsername().equals(username)) {
				return usersArrayList.get(i);

			} else {
				SimpleCustomer user = new SimpleCustomer("Customer", "", "", "", "", "");
				return (User) user;
			}
		}
		return null;
	}
}
