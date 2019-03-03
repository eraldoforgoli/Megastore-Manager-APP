package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cashier;
import entities.Manager;

public class Identify {
	private String username;
	private String password;
	private boolean logged;
	Scanner input;

	public Identify() {
		input = new Scanner(System.in);
		username = "";
		password = "";
	}

	public String login(ArrayList<Cashier> cashiers, String username, String password) {
		for (int i = 0; i < cashiers.size(); i++) {
			if (username.equals(cashiers.get(i).getUsername()) && password.equals(cashiers.get(i).getPassword())) {
				return username;
			}
		}
		return null;
	}

	public String loginManager(Manager m, String username, String password) {
		if (username.equals(m.getUsername())) {
			if (password.equals(m.getPassword())) {
				return username;
			}
		}
		return null;
	}
}