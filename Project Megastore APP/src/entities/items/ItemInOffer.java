package entities.items;

public class ItemInOffer extends Item {

    private int nrItemsToPay, nrItemsToBuy, allowedAmount;

    public ItemInOffer(String name, int id, double price, int nrItemsToPay, int nrItemsToBuy) {
        super(name, id, price);
        allowedAmount = 10;
        this.nrItemsToBuy = nrItemsToBuy;
        this.nrItemsToPay = nrItemsToPay;

    }

    public void printInfo() {
        super.printInfo();
    }

    public static ItemInOffer createItemWithDiscount() {
        return (new ItemInOffer("", -1, 0.0, 3, 5));
    }
}
