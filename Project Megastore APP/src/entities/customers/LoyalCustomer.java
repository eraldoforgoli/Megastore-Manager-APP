package entities.customers;

public class LoyalCustomer extends User {
    private double points;

    public LoyalCustomer(String name, String surname, String username, String password, String address,
                         String phoneNumber) {
        super(name, surname, username, password, address, phoneNumber);
        points = 0.0;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getPoints() {
        return points;
    }

    public static User createLoyalCustomer() {
        return (new LoyalCustomer("", "", "", "", "", ""));
    }
}
