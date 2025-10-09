package aims_package;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public static int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full!");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				qtyOrdered--;
				itemsOrdered[qtyOrdered] = null;
				break;
			}
		}
	}
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			sum += temp.getCost();
		}
		return sum;
	}
	//Added methods
	public void showCart() {
		if (qtyOrdered != 0) {
			for (int i = 0; i < qtyOrdered; i++) {
				System.out.println(itemsOrdered[i].getTitle());
			}
		}
		else {
			System.out.println("The cart is empty");
		}
	}
	
}
