package entities.customers;

public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;

    public User(String name, String surname, String username, String password, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printInfo() {
        System.out.println("Emri : " + name + "\n" + "Surname : " + surname + "\n" + "Username : " + username + "\n"
                + "Address : " + address + "/n" + "Phone Number : " + phoneNumber + "\n");
    }

    public static User createUser() {
        return (new User("", "", "", "", "", ""));
    }
}