package controllers;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import entities.items.*;

public class ItemsFile {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private FileOutputStream fos;
	private FileInputStream fis;

	public ItemsFile() {
		output = null;
		input = null;
		fis = null;
		fos = null;
	}

	public void addItemsToFile(ArrayList<Item> items) {
		try {
			fos = new FileOutputStream("items.ser");
			output = new ObjectOutputStream(fos);

		} catch (IOException ex) {
			System.out.println("Error opening file for writing. Terminating");
			System.exit(1);
		}

		try {
			for (int i = 0; i < items.size(); i++) {
				output.writeObject(items.get(i));
			}
			System.out.println("\nSerialization Successful... Checkout your specified output file..\n");
		}

		catch (NoSuchElementException ex) {

			System.out.println("Invalid input.");

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException ex) {
			System.out.println("Error closing write file.");
		}
	}

	public ArrayList<Item> readItems() {
		ArrayList<Item> items = new ArrayList<Item>();

		try {
			fis = new FileInputStream("items.ser");
			input = new ObjectInputStream(fis);
		} catch (IOException ex) {
			System.out.println("Error opening file for reading");
			System.exit(1);
		}
		try {
			// System.out.println("Reading items ...");
			while (true) {
				Item a = (Item) input.readObject();
				items.add(a);
			}

		} catch (EOFException endOfFileException) {
			System.out.println("No more records.");

		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Invalid object");
		} catch (IOException ioException) {
			System.out.println("Error reading from file.");

		}

		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException ex) {
			System.out.println("Error closing file.");
			System.exit(1);
		}
		return items;
	}

	public void openAndClose() {
		try {
			fos = new FileOutputStream("items.txt");
			output = new ObjectOutputStream(fos);

		} catch (IOException ex) {
			System.out.println("Error opening file. Termination");
			System.exit(1);
		}

		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException ex) {
			System.out.println("Error closing write file.");
		}
	}
}
