package controllers;

import entities.*;
import entities.customers.CustomerEmployee;
import entities.customers.GroupCustomer;
import entities.customers.LoyalCustomer;
import entities.customers.User;
import entities.items.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessData {

    private double price;
    private double itemPrice;

    private int countItemInOffer;

    // counters for each type of Item
    private int itemInOfferCount;
    private int itemWithDiscountCount;
    private int itemPartlyIndependenceCount;
    private int itemTakeItAllCount;
    private int itemCount;

    /*
     * By default create 5 cashiers and 1 manager
     */
    private Cashier cashier1;
    private Cashier cashier2;
    private Cashier cashier3;
    private Cashier cashier4;
    private Cashier cashier5;

    private Manager manager;
    private ArrayList<String> usersLogged = new ArrayList<String>();

    private ArrayList<Item> items;
    private ArrayList<Cashier> cashiers = new ArrayList<Cashier>();
    private StoreBasket basket;
    private Scanner input;
    private String userLogged;
    private ItemsFile file;
    private UsersFile usersFile;
    private ItemCreator itemCreator;
    private UserCreator userCreator;

    public ProcessData() {
        countItemInOffer = 0;
        itemCount = 0;
        itemInOfferCount = 0;
        itemPartlyIndependenceCount = 0;
        itemTakeItAllCount = 0;
        itemWithDiscountCount = 0;

        price = 0.0;
        itemPrice = 0.0;
        cashier1 = new Cashier("John", "Doe", "johndoe", "john", "Rruga e Durresit", "0681111111", "0442020", 355);
        cashier2 = new Cashier("Denis", "Haxhi", "denis", "denid", "Rruga e Durresit", "0681111111", "0442020", 355);
        cashier3 = new Cashier("Endri", "Marku", "endrimarku", "endri2018", "Rruga e Durresit", "0681111111", "0442020",
                355);
        cashier4 = new Cashier("Kledis", "Molla", "kledismolla", "kledis2018", "Rruga e Durresit", "0681111111",
                "0442020", 355);
        cashier5 = new Cashier("Eraldo", "Forgoli", "eraldoforgoli", "eraldo", "Rruga e Durresit", "0681111111",
                "0442020", 355);

        manager = new Manager("Arbjon", "Mali", "arbjonmali", "arbjon1", "Rruga e Durresit", "0681111111", "0442020",
                11754);

        input = new Scanner(System.in);
        file = new ItemsFile();
        usersFile = new UsersFile();
        cashiers.add(cashier1);
        cashiers.add(cashier2);
        cashiers.add(cashier3);
        cashiers.add(cashier4);
        cashiers.add(cashier5);

        itemCreator = new ItemCreator();
        userCreator = new UserCreator();
        items = getItems();
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    public ArrayList<Item> getItems() {
        file.openAndClose();
        ArrayList<Item> returnItems = new ArrayList<Item>(file.readItems());
        return returnItems;
    }

    public void processBasketData(String itemName, StoreBasket basket) {
        for (int i = 0; i < items.size(); i++) {
            if (itemName.equals(items.get(i).getName())) {
                basket.addItem(itemName);
                basket.increaseAmount();
                if (itemName.equals(items.get(i).getName()) && items.get(i).getClass() == ItemWithDiscount.class) {
                    Item a = items.get(i);
                    ItemWithDiscount a1 = (ItemWithDiscount) a; // polimorfizem
                    a1.calculateDiscount();

                    itemWithDiscountCount++;
                } else if (itemName.equals(items.get(i).getName())
                        && items.get(i).getClass() == ItemPartlyIndependence.class) {
                    Item a = items.get(i);
                    ItemPartlyIndependence a1 = (ItemPartlyIndependence) a;
                    a1.calculateDiscount();
                    itemPartlyIndependenceCount++;
                } else if (itemName.equals(items.get(i).getName()) && items.get(i).getClass() == ItemTakeItAll.class) {
                    ItemTakeItAll a = (ItemTakeItAll) items.get(i);
                    ItemTakeItAll a1 = (ItemTakeItAll) a;
                    a1.calculateDiscount();

                    itemTakeItAllCount++;

                } else if (itemName.equals(items.get(i).getName()) && items.get(i).getClass() == ItemInOffer.class) {
                    countItemInOffer++;
                    itemInOfferCount++;
                } else {
                    itemCount++;
                }
                if (countItemInOffer >= 5) {
                    itemPrice = items.get(i).getPrice();
                    basket.changePrice((itemPrice * 2 * countItemInOffer) / 5);
                } else {
                    itemPrice = items.get(i).getPrice();
                    basket.changePrice(itemPrice);
                }

                price += items.get(i).getPrice();
                break;
            }
        }
    }

    public void checkIfCustomerIsRegistered(User customer) {
        if (customer instanceof LoyalCustomer) {
            ((LoyalCustomer) customer).setPoints((double) price / 5);
            JOptionPane.showMessageDialog(null, "Loyal Customer, 5 Euro  > 1 point !");
        } else if (customer instanceof GroupCustomer) {
            ((GroupCustomer) customer).setPoints((double) price / 10);
            JOptionPane.showMessageDialog(null, "Group Customer, 10 Euro  > 1 point !");
        } else if (customer instanceof CustomerEmployee) {
            ((CustomerEmployee) customer).setPoints((double) price / 15);
            JOptionPane.showMessageDialog(null, "Employee Customer, 15 Euro  > 1 point !");
        } else {
            JOptionPane.showMessageDialog(null, "Simple customer, no bonus points!");
        }
        ArrayList<User> customers = new ArrayList<User>(usersFile.readUsers());

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i) == customer) {
                customers.set(i, customer);
            }
        }
        usersFile.addUsersToFile(customers);
    }

    public void processManager() {
        System.out.println("Press 1 to show total baskets sold by a cashier : ");
        while (!input.hasNextInt()) {
            System.out.println("Incorrect input, integer expected \n Enter another number");
            input.next();
        }

        int confirm = input.nextInt();
        while (confirm == 1) {
            System.out.println("Overall number of baskets for a specific cashier: \n Enter the username");
            String userLogged = input.next();
            if (getNrOfBaskets(userLogged) == -1) {
                System.out.println("Wrong username ");
            } else {
                System.out.println(userLogged + " has processed " + getNrOfBaskets(userLogged) + " baskets");
            }

            System.out.println("Press 1 to show total baskets sold by a cashier : ");

            while (!input.hasNextInt()) {
                System.out.println("Incorrect input, integer expected \n Enter another number");
                input.next();
            }
            confirm = input.nextInt();
        }

        System.out.println("\n\n Total amount of baskets created is : " + basket.getNumbetOfBaskets() + "\n");
        System.out.println("Total bills are : ");
        ArrayList<String> list = basket.getBasketInfo();

        for (String i : list) {
            System.out.println(i);
            System.out.println();
        }

        System.out.println("\n\n Users logged are :");
        for (String i : usersLogged) {
            System.out.println(i);

        }

        itemCreator.createItem();
        userCreator.createUser();

        System.out.println("Points accumulated are : ");

        ArrayList<User> users = new ArrayList<User>(usersFile.readUsers());
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof LoyalCustomer) {
                System.out.println(((LoyalCustomer) users.get(i)).getName() + ", Bonus : "
                        + ((LoyalCustomer) users.get(i)).getPoints());
            } else if (users.get(i) instanceof GroupCustomer) {
                System.out.println(((GroupCustomer) users.get(i)).getName() + ", Bonus : "
                        + ((GroupCustomer) users.get(i)).getPoints());
            } else if (users.get(i) instanceof CustomerEmployee) {
                System.out.println(((CustomerEmployee) users.get(i)).getName() + ", Bonus : "
                        + ((CustomerEmployee) users.get(i)).getPoints());
            } else {
                System.out.println("Simple Customer, no bonus!");
            }
        }
        System.out.println("Items take it all bought : " + itemTakeItAllCount + "\nItems Partly Independence Bought :  "
                + itemPartlyIndependenceCount + "\nItems in offer Bought : " + itemInOfferCount
                + "\nItems in discount bought : " + itemWithDiscountCount + "\nNormal items Bought : " + itemCount

        );
    }

    public int getNrOfBaskets(String userLogged) {
        for (int i = 0; i < cashiers.size(); i++) {
            if (userLogged.equals(cashiers.get(i).getUsername()))
                return cashiers.get(i).getBasketsProcessed();
        }
        return -1;
    }

    public boolean verifyUsername(String username) {
        if (username.equals("denisashkembi") || username.equals("denishoxha") || username.equals("endrimarku")
                || username.equals("kledismolla") || username.equals("anaktona"))
            return true;
        return false;
    }

    public ArrayList<String> getUsersLogged() {
        return usersLogged;
    }

    public String getUserLogged() {
        return userLogged;
    }

    public void calculateSalary(long workHours) {
        if (userLogged.equals("denisashkembi")) {
            double total1 = cashier1.calculatePayment(workHours);
            cashier1.setTotalSalary(total1);
            System.out.println("\nSalary  for Endri Marku is :  " + total1);
        } else if (userLogged.equals("denishoxha")) {
            double total2 = cashier2.calculatePayment(workHours);
            cashier2.setTotalSalary(total2);
            System.out.println("\n salary  for Denis Hoxha is :  " + total2);
        } else if (userLogged.equals("endrimarku")) {
            double total3 = cashier3.calculatePayment(workHours);
            cashier3.setTotalSalary(total3);
            System.out.println("\nTodays salary  for Endri Marku is :  " + total3);
        } else if (userLogged.equals("kledismolla")) {
            double total4 = cashier4.calculatePayment(workHours);
            cashier4.setTotalSalary(total4);
            System.out.println("\nTodays salary  for Kledis Molla is :  " + total4);
        } else if (userLogged.equals("anaktona")) {
            double total5 = cashier5.calculatePayment(workHours);
            cashier5.setTotalSalary(total5);
            System.out.println("\nTodays salary  for Ana Ktona is :  " + total5);
        }
    }
}
