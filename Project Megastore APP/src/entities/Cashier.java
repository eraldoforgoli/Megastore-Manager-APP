package entities;

import entities.customers.User;

public class Cashier extends User implements Payable { // nje Cashier eshte nje Employee, prandaj trashegon nga ai

	private int basketsProcessed;
	private String iternalPhoneNumber;
	private double hoursOfWork;
	private double bonus;
	private double baseSalary;
	private double totalSalary;

	public Cashier(String name, String surname, String username, String password, String address, String phoneNumber,
			String iternalPhoneNumber, double baseSalary) {
		super(name, surname, username, password, address, phoneNumber); // therras konstruktori i superklases Employee
		basketsProcessed = 0;
		this.iternalPhoneNumber = iternalPhoneNumber;
		this.baseSalary = baseSalary;
		totalSalary = 0.0;
		bonus = 10;
	}

	public double getBonus() {
		return bonus;
	}

	public double getHoursOfWork() {
		return hoursOfWork;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;

	}

	public void setHoursOfWork(double hoursOfWork) {
		this.hoursOfWork = hoursOfWork;

	}

	public void addBasketsProcessed() {
		basketsProcessed++;
	}

	public int getBasketsProcessed() {
		return basketsProcessed;
	}

	public void setBaseSalary(double salary) {
		if (salary >= 250) {
			baseSalary = salary;
		}
	}

	public double calculateBonus() {
		return 0.0;
	}

	public void printInfo() {
		super.printInfo();
	}

	public double calculateOvertimeWork(double hoursOfWork) {
		if (hoursOfWork >= 8) {
			return 8 - hoursOfWork;
		} else
			return 0.0;
	}

	@Override
	public double calculatePayment(double hoursOfWork) {
		totalSalary = this.baseSalary + calculateOvertimeWork(hoursOfWork) * 10;
		return totalSalary;
	}
}
