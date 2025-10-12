package aims_package;
import java.util.Arrays;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public static final double VAT = 0.1;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int quantity[] = new int[MAX_NUMBERS_ORDERED];
	public static int qtyOrdered = 0;
	public static int freeItemIndex;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			quantity[qtyOrdered] = 1;
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
		quantity[i] = 0;
		for (int j = i; j < qtyOrdered - 1; j++) {
			itemsOrdered[j] = itemsOrdered[j + 1];
			quantity[j] = quantity[j + 1];
		}
		qtyOrdered--;
		itemsOrdered[qtyOrdered] = null;
		quantity[qtyOrdered] = 0;
	}

	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			sum += temp.getCost() * quantity[i];
		}
		return sum;
	}
	//Added methods
	public void showCart() {
		if (qtyOrdered != 0) {
			for (int i = 0; i < qtyOrdered; i++) {
				DigitalVideoDisc temp = itemsOrdered[i];
				System.out.println((i+1) + ": " + temp.getTitle()+ " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$" + " - " + quantity[i] + " item(s)");
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

	public void setQuantity (int index, int quant) {
		quantity[index - 1] = quant;
	}

	public int getQuantity (int i) {
		return quantity[i - 1];
	}

	public int getQuantityFromDisc (DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				return quantity[i];
			}
		}
		return 0;
	}

	public double feeCalculation() {
		int maxFee = 10;
		int minFee = 3;
		freeItemIndex = (int)(Math.random() * qtyOrdered);
		quantity[freeItemIndex]--;
		System.out.println("NOTE: As part of our program, a DVD will be picked randomly to be free of charge. The DVD in question is " + itemsOrdered[freeItemIndex].getTitle() + " - " + itemsOrdered[freeItemIndex].getDirector());
		System.out.println("Your current order (Excluding the free item): ");
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			total += temp.getCost() * quantity[i];
			System.out.println((i+1) + ": " + temp.getTitle()+ " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$" + " - " + quantity[i] + " item(s)");
		}
		double deliveryFee = Math.round(((Math.random() * (maxFee - minFee)) + minFee) * 100) / 100;
		System.out.println("Delivery fee: " + deliveryFee + "$");
		System.out.println("Total cost before VAT: " + (total + Math.round(deliveryFee)) + "$");
		double totalFinal = (total + deliveryFee) * (1 + VAT);
		System.out.println("Total cost after VAT (10%) " + totalFinal + "$");
		return totalFinal;
	}

	public void resetQuantityAfterCancel() {
		quantity[freeItemIndex]++;
	}
}
