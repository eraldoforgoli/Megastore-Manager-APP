package entities.items;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {
    private String name;
    private int ID;
    private double price;

    public Item(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String getItemName(int itemID, ArrayList<Item> items) { // marr si parameter id dhe Array me items
        String name = "";
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == itemID) {
                name = items.get(i).getName();
                break;
            }
        }
        return name;
    }

    public void printInfo() {
        System.out.println("Name : " + name + "\n" + "ID : " + ID + "\n" + "Price : " + price);
    }

    public static Item createItem() {
        return (new Item("", -1, 0.0));
    }
}
