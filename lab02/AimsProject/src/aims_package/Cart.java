package aims_package;
import java.util.Arrays;

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

	public void removeDigitalVideoDisc(int i) {
		i--;
		itemsOrdered[i] = null;
		for (int j = i; j < qtyOrdered - 1; j++) {
			itemsOrdered[j] = itemsOrdered[j + 1];
		}
		qtyOrdered--;
		itemsOrdered[qtyOrdered] = null;
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
				DigitalVideoDisc temp = itemsOrdered[i];
				System.out.println((i+1) + ": " + temp.getTitle()+ " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
			}
		}
		else {
			System.out.println("The cart is empty");
		}
	}

	public void titleSort() {
		String array[] = new String[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			array[i] = itemsOrdered[i].getTitle();
		}
	}

	public DigitalVideoDisc indexToDisc(int i) {
		return itemsOrdered[i-1];
	}
	
	public DigitalVideoDisc titleToDisc (String n) {
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc DVD = itemsOrdered[i];
			String title = DVD.getTitle().toLowerCase();
			if (title.contains(n)) {
				return DVD;
			}
		}
		return null;
	}
}
