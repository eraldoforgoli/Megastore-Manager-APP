package controllers;

import entities.customers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UsersFile {
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private FileOutputStream fos;
    private FileInputStream fis;

    public UsersFile() {
        output = null;
        input = null;
        fis = null;
        fos = null;
    }

    public void addUsersToFile(ArrayList<User> users) {
        try {
            fos = new FileOutputStream("users.ser");
            output = new ObjectOutputStream(fos);

        } catch (IOException ex) {
            System.out.println("Error opening file for writing. Terminating");
            System.exit(1);
        }
        try {
            for (int i = 0; i < users.size(); i++) {
                output.writeObject(users.get(i));
            }
            System.out.println("\nSerialization Successful... Checkout your specified output file..\n");
        } catch (NoSuchElementException ex) {
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

    public ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            fis = new FileInputStream("users.ser");
            input = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println("Error opening file for reading");
            System.exit(1);
        }

        try {
            // System.out.println("Reading items ...");
            while (true) {

                User a = (User) input.readObject();

                users.add(a);
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
        return users;
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
