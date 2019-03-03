package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import entities.items.*;

public class ItemCreator {
	private int confirm;
	Scanner input;
	ItemsFile file;
	ArrayList<Item> itemsToFile;

	public ItemCreator() {
		confirm = 0;
		input = new Scanner(System.in);
		file = new ItemsFile();
	}

	public void createItem() {
		System.out.println(
				"Press : \n1 To create new Item  \n 2 to create  Item With Discount \n3 to crate Iteem With PartlyIndependence\n"
						+ "4 to create Item In Offer +\n5 to create Item Take It All ");

		while (!input.hasNextInt()) {
			System.out.println("Incorrect input, integer expected \n Enter another number");
			input.next();
		}

		confirm = input.nextInt();
		Item addItemToFile = null;

		/*
		 * Nje problem i object serialization eshte qe nuk te lejon ti besh append filit
		 * dmth ne momentin qe manager do te shtoje items , items ekzistues do te
		 * mbishkruhen prandaj, do ruajme ne ArrayList<Item>, te gjithe Items ekzistues
		 * ne file ,dhe me pas ketij ArrayListi i shtojme dhe objektet Items qe manageri
		 * shton si te reja Si perfundim, i shtojme ne file.
		 */

		file.openAndClose();
		itemsToFile = new ArrayList<Item>(file.readItems());

		while (confirm == 1 || confirm == 2 || confirm == 3 || confirm == 4 || confirm == 5) {
			if (confirm == 1) {
				Item item = Item.createItem();
				System.out.println("Enter Item name :");
				item.setName(input.next());
				System.out.println("Enter item ID :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				item.setID(input.nextInt());
				System.out.println("Enter item price :");
				while (!input.hasNextDouble()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				item.setPrice(input.nextDouble());

				// e shtojme tek file ne fund te kushteve
				addItemToFile = item;

			}

			if (confirm == 2) {
				// ItemWithDiscount
				ItemWithDiscount itemDiscount = ItemWithDiscount.createItemWithDiscount();
				System.out.println("Enter Item name :");
				itemDiscount.setName(input.next());
				System.out.println("Enter item ID :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemDiscount.setID(input.nextInt());
				System.out.println("Enter item price :");

				while (!input.hasNextDouble()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}
				itemDiscount.setPrice(input.nextDouble());

				System.out.println("Enter item discount :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}
				itemDiscount.setDiscount(input.nextInt());

				/*
				 * Add to file
				 */
				addItemToFile = itemDiscount;

			}

			if (confirm == 3) {

				// ItemWithDiscount

				ItemPartlyIndependence itemIndependence = ItemPartlyIndependence.createItemWithDiscount();
				System.out.println("Enter Item name :");
				itemIndependence.setName(input.next());
				System.out.println("Enter item ID :");

				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemIndependence.setID(input.nextInt());
				System.out.println("Enter item price :");

				while (!input.hasNextDouble()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemIndependence.setPrice(input.nextDouble());
				System.out.println("Enter item discount :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}
				itemIndependence.setDiscount(input.nextInt());

				System.out.println("Enter item discountIndependence :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}
				itemIndependence.setDiscountIndependence(input.nextInt());

				/*
				 * add to file
				 */
				addItemToFile = itemIndependence;
			}

			if (confirm == 4) {

				// ItemInOffer

				ItemInOffer itemOffer = ItemInOffer.createItemWithDiscount();
				System.out.println("Enter Item name :");
				itemOffer.setName(input.next());
				System.out.println("Enter item ID :");

				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemOffer.setID(input.nextInt());
				System.out.println("Enter item price :");
				while (!input.hasNextDouble()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemOffer.setPrice(input.nextDouble());
				addItemToFile = itemOffer;

			}

			if (confirm == 5) {

				// ItemTakeItAll

				ItemTakeItAll itemTake = ItemTakeItAll.createItemWithDiscount();
				System.out.println("Enter Item name :");
				itemTake.setName(input.next());
				System.out.println("Enter item ID :");

				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemTake.setID(input.nextInt());
				System.out.println("Enter item price :");

				while (!input.hasNextDouble()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemTake.setPrice(input.nextDouble());
				System.out.println("Enter max amount of items to by with discount  :");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect input, integer expected \n Enter another number");
					input.next();
				}

				itemTake.setMinNrOfItems(input.nextInt());
				addItemToFile = itemTake;
			}

			/*
			 * Add all items to File using Object Serialisation Null initialisation if none
			 * of the above conditions are fulfilled
			 */

			if (addItemToFile != null) {
				itemsToFile.add(addItemToFile);
				addItemToFile = null;
			}

			System.out.println(
					"Press : \n1 To create new Item  \n 2 to create  Item With Discount \n3 to crate Iteem With PartlyIndependence\n"
							+ "4 to create Item In Offer +\n5 to create Item Take It All ");

			while (!input.hasNextInt()) {
				System.out.println("Incorrect input, integer expected \n Enter another number");
				input.next();
			}
			confirm = input.nextInt();

		}

		if (!itemsToFile.isEmpty())
			file.addItemsToFile(itemsToFile);
		System.out.println(" items added are : \n");

		for (int i = 0; i < itemsToFile.size(); i++) {
			itemsToFile.get(i).printInfo();
			System.out.println();
		}
	}
}
