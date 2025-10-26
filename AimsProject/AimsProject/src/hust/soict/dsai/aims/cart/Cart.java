package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc store[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public static int qtyOrdered = 0;
	
	public void initializeStore() {
		store[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store[2] = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
		store[3] = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
		store[4] = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f);
		store[5] = new DigitalVideoDisc("12 Angry Men", "Drama", "Sidney Lumet", 96, 19.95f);
		store[6] = new DigitalVideoDisc("Schindler's List", "History", "Steven Spielberg", 195, 30.95f);
		store[7] = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 24.50f);
		store[8] = new DigitalVideoDisc("The Good, the Bad and the Ugly", "Western", "Sergio Leone", 178, 22.95f);
		store[9] = new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 23.95f);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full!");
		}
	}

	public void addDigitalVideoDisc(int i) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = store[i - 1];
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full!");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
			}
			System.out.println("The discs have been added");
		}
		else {
			System.out.println("The cart is almost full!");
		}
	}

	public void addArbitraryDigitalVideoDisc(DigitalVideoDisc... dvds) {
    	if (qtyOrdered + dvds.length <= MAX_NUMBERS_ORDERED) {
        	for (int i = 0; i < dvds.length; i++) {
            	itemsOrdered[qtyOrdered] = dvds[i];
				qtyOrdered++;
    	    }
    	    System.out.println("The discs have been added");
    	} else {
    	    System.out.println("The cart is almost full!");
    	}
	}


	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 2;
			System.out.println("The discs have been added");
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
		System.out.println("The disc has been removed");
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			sum += temp.getCost();
		}
		return sum;
	}
	
	public boolean showCart() {
		if (qtyOrdered != 0) {
			for (int i = 0; i < qtyOrdered; i++) {
				DigitalVideoDisc temp = itemsOrdered[i];
				System.out.println(temp.toString());
			}
			return true;
		}
		else {
			System.out.println("The cart is currently empty");
			return false;
		}
	}

	public void print() {
		float sum = 0;
		System.out.println("***********************CART*********************** ");
		if (qtyOrdered != 0) {
			System.out.println("Ordered Items:");
			for (int i = 0; i < qtyOrdered; i++) {
				DigitalVideoDisc temp = itemsOrdered[i];
				sum += temp.getCost();
				System.out.println(temp.toString());
			}
			System.out.println("Total cost: " + sum + "$");
		}
		else {
			System.out.println("The cart is currently empty");
		}
		System.out.println("***************************************************");
	}
	
	public void showStore() {
		System.out.println("AVAILABLE DISCS");
		for (int i = 0; i < store.length; i++) {
			if (store[i] == null) break;
			DigitalVideoDisc temp = store[i];
			System.out.println(temp.toString());
		}
	}

	public DigitalVideoDisc searchByTitle(String title) {
		for (int i = 0; i < store.length; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			if (temp.isMatch(title)) {
				return temp;
			}
		}
		System.out.println("No result is found!");
		return null;
	}

	public DigitalVideoDisc searchById(int id) {
		for (int i = 0; i < store.length; i++) {
			DigitalVideoDisc temp = itemsOrdered[i];
			if (temp.getId() == id) {
				return temp;
			}
		}
		System.out.println("No result is found!");
		return null;
	}
}
