package controllers;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StoreBasketFile {
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private FileOutputStream fos;
    private FileInputStream fis;

    public StoreBasketFile() {
        output = null;
        fos = null;
    }

    public void addStoreBasketToFile(ArrayList<StoreBasket> baskets) {
        try {
            fos = new FileOutputStream("baskets.ser");
            output = new ObjectOutputStream(fos);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error opening file for writing.");
            System.exit(1);
        }
        try {
            for (StoreBasket s : baskets)

                output.writeObject(s);
            JOptionPane.showMessageDialog(null, "Basket saved successfully.");
        } catch (NoSuchElementException ex) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error closing file .");
        }
    }

    public ArrayList<StoreBasket> readBaskets() {
        ArrayList<StoreBasket> baskets = new ArrayList<StoreBasket>();
        try {
            fis = new FileInputStream("baskets.ser");
            input = new ObjectInputStream(fis);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error opening file for reading.");
            System.exit(1);
        }
        try {
            while (true) {
                JOptionPane.showMessageDialog(null, ((StoreBasket) input.readObject()).getBasketInfo());
                baskets.add((StoreBasket) input.readObject());
            }
        } catch (EOFException endOfFileException) {
        } catch (ClassNotFoundException classNotFoundException) {
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error reading in file.");
        }

        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error closing  file for reading.");
            System.exit(1);
        }
        return baskets;
    }

    public void openAndClose() {
        try {
            fos = new FileOutputStream("users.ser");
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
