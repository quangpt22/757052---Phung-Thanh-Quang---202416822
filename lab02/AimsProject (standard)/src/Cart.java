
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
				System.out.println((i+1) + ": " + temp.getTitle()+ " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
			}
			return true;
		}
		else {
			System.out.println("The cart is currently empty");
			return false;
		}
	}
	
	public void showStore() {
		System.out.println("AVAILABLE DISCS");
		for (int i = 0; i < store.length; i++) {
			if (store[i] == null) break;
			DigitalVideoDisc temp = store[i];
			System.out.println((i + 1) + ": " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
		}
	}
}
