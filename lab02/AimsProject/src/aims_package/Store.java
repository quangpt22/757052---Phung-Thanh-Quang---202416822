package aims_package;

public class Store {
	public static final int MAX_NUM_AVAIL = 30;
	private DigitalVideoDisc itemsStored[] = new DigitalVideoDisc[MAX_NUM_AVAIL];
	public static int current = 0;
	
	public void addToStore (DigitalVideoDisc disc) {
		itemsStored[current] = disc;
		current++;
	}
	
	public void browseStore () {
		for (int i = 0; i < current; i++) {
			DigitalVideoDisc temp = itemsStored[i];
			System.out.println((i + 1) + ". " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
		}
	}
	
	public void searchDVDByTitle (String n) {
		int cur = 0;
		for (int i = 0; i < current; i++) {
			String title = itemsStored[i].getTitle().toLowerCase();
			if (title.contains(n.toLowerCase())) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ". " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
	}
	
	public void searchDVDByCategory (String n) {
		int cur = 0;
		for (int i = 0; i < current; i++) {
			String category = itemsStored[i].getCategory().toLowerCase();
			if (category.contains(n.toLowerCase())) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ". " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
	}
	
	public void searchDVDByPrice (float min, float max) {
		int cur = 0;
		for (int i = 0; i < current; i++) {
			float price = itemsStored[i].getCost();
			if (price > min && price < max) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ". " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
	}
}
