package entities.items;

public class ItemPartlyIndependence extends ItemWithDiscount {
    private double actualPrice;
    private int discountIndependence;

    public ItemPartlyIndependence(String name, int id, double price, int discount, int discountIndependence) {
        super(name, id, price, discount);
        this.discountIndependence = discountIndependence;
    }

    public double calculateDiscount() {
        actualPrice = getPrice() - (super.calculateDiscount() + (double) discountIndependence / 100);
        setPrice(actualPrice);
        return super.calculateDiscount() + (double) discountIndependence / 100;
    }

    public void setDiscountIndependence(int discountIndependence) {
        this.discountIndependence = discountIndependence;
    }

    public int getDiscountIndependence(int discountIndependence) {
        return discountIndependence;
    }

    public void printInfo() {
        super.printInfo();
    }

    public static ItemPartlyIndependence createItemWithDiscount() {
        return (new ItemPartlyIndependence("", -1, 0.0, 0, 0));
    }
}
