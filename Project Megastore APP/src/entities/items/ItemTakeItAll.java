package entities.items;

public class ItemTakeItAll extends ItemWithDiscount {
    private int N;

    public ItemTakeItAll(String name, int id, double price, int discount, int N) {
        super(name, id, price, discount);
        this.N = N;
    }

    public int getMinNrOfItems() {
        return N;
    }

    public void setMinNrOfItems(int N) {
        this.N = N;
    }

    public double calculateDiscount() {
        return super.calculateDiscount();
    }

    public void printInfo() {
        super.printInfo();
    }

    public static ItemTakeItAll createItemWithDiscount() {
        return (new ItemTakeItAll("", -1, 0.0, 0, 10));
    }
}
