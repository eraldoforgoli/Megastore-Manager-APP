package entities.items;
public class ItemWithDiscount extends Item {
	private double finalPrice;
	private int discount;

	public ItemWithDiscount(String name, int id, double price, int discount) {
		super(name, id, price);
		this.discount = discount;
	}

	public double calculateDiscount() {
		finalPrice = getPrice() - getPrice() * ((double) discount / 100.0);
		setPrice(finalPrice);
		return getPrice() * ((double) discount / 100.0);
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void printInfo() {
		super.printInfo();
	}

	public static ItemWithDiscount createItemWithDiscount() {
		return (new ItemWithDiscount("", -1, 0.0, 0));
	}
}
