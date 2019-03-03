package controllers;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StoreBasket implements Serializable {

	private int ID;
	private int amount;
	private double price;
	private double VAT;
	private ArrayList<String> items;
	private String dateAndTime;
	private String address;
	private String nameOfCashier;

	private int totalBaskets;
	private ArrayList<String> basketsInfo;

	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date today = Calendar.getInstance().getTime();
	String todayDate = df.format(today);

	public StoreBasket() {
		ID = 0;
		amount = 0;
		VAT = 0.2; // value added tax = 20%
		price = 0.0;
		items = new ArrayList<String>();
		basketsInfo = new ArrayList<String>();
		dateAndTime = todayDate;
		address = "Rruga e Durresit";
		nameOfCashier = "";
		System.out.println("Date : " + today + "\n");

		totalBaskets = 0;
	}

	public void setPrice(double p) {
		price = p;
	}

	public void removeItemPrice(double d) {
		price -= d;
	}

	public void changePrice(double p) { // shtohet cmimi qe duhet paguar pas cdo produkti te shtuar
		price += p;
	}

	public void increaseID() {
		ID++;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setVat(int VAT) {
		this.VAT = VAT;
	}

	public void setDate() { // do ndryshohet data per cdo printim
		today = Calendar.getInstance().getTime();
		dateAndTime = df.format(today);

	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNameOfCashier(String nameOfCashier) {
		this.nameOfCashier = nameOfCashier;
	}

	public void addItem(String item) {
		items.add(item);
	}

	public void increaseAmount() {
		amount += 1; // rrisim sasine sa her qe thirret funksioni
	}

	public void increaseNumberOfBaskets() {
		totalBaskets++;
	}

	public int getNumbetOfBaskets() {
		return totalBaskets;
	}

	public ArrayList<String> getBasketInfo() {
		return basketsInfo;
	}

	public void printItems() {

		System.out.println("Items of the basket are :");

		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}
		System.out.println();
	}

	public void setDateAndTime() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		dateAndTime = df.format(today);
	}

	public void removeItem(String itemToRemove) {
		boolean a = items.remove(itemToRemove);
		if (a) {
			System.out.println(itemToRemove + " is removed ");
		} else {
			System.out.println("Item not found ");
		}
	}

	public void discount() {
		if (today.getMonth() == 11 && today.getDate() == 25) {
			price -= (double) 10 / 100 * price;
			System.out.println("A 10% discount was made for Christmas.");
		}
	}

	public String printAllInfo() {
		amount = items.size();
		String basketInfo = "ID: " + ID + "\n" + "Amount: " + amount + "\n" + "Net price :" + price + "\n"
				+ "Total price: " + (price + VAT * price) + "\n" + "Date and time : " + dateAndTime + "\n"
				+ "Address : " + address + "\n" + "Name of cashier: " + nameOfCashier;
		return basketInfo;

	}

	public void saveData() {
		amount = items.size();
		String basketInfo = "ID: " + ID + "\n" + "Amount: " + amount + "\n" + "Net price :" + price + "\n"
				+ "Total price: " + (price + VAT * price) + "\n" + "Date and time : " + dateAndTime + "\n"
				+ "Address : " + address + "\n" + "Name of cashier: " + nameOfCashier;
		basketsInfo.add(basketInfo);
	}

	public void initialiseData() {
		amount = 0;
		VAT = 0.2; // value added tax = 20%
		price = 0.0;
		items.clear();
		dateAndTime = todayDate;
	}

	public boolean getNumberOfItems() {
		if (items.size() == 0) {
			return true;
		}

		return false;
	}

	public double getTotalPrice() {
		return price + (VAT * price);
	}
}
