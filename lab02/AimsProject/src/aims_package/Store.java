package aims_package;
import java.util.Scanner;

public class Store {
	static Scanner sc = new Scanner(System.in);
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
			System.out.println((i + 1) + ": " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
		}
	}
	
	public void searchDVDByTitle () {
		int cur = 0;
		System.out.println("Enter the title of the DVD:");
		String n = sc.nextLine();
		for (int i = 0; i < current; i++) {
			String title = itemsStored[i].getTitle().toLowerCase();
			if (title.contains(n.toLowerCase())) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ": " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
		if (cur == 0) {
			System.out.println("No DVDs with such name found. Please try again");
		}
	}
	
	public void searchDVDByCategory () {
		int cur = 0;
		System.out.println("Enter the category:");
		String n = sc.nextLine();
		for (int i = 0; i < current; i++) {
			String category = itemsStored[i].getCategory().toLowerCase();
			if (category.contains(n.toLowerCase())) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ": " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
		if (cur == 0) {
			System.out.println("No DVDs with such category found. Please try again");
		}
	}
	
	public void searchDVDByPrice () {
		int cur = 0;
		System.out.println("Choose the price range:");
		System.out.println("Set minimum price (Optional, enter 0 to skip):");
		float min = Float.parseFloat(sc.nextLine());
		System.out.println("Set maximum price:");
		float max = Float.parseFloat(sc.nextLine());
		for (int i = 0; i < current; i++) {
			float price = itemsStored[i].getCost();
			if (price > min && price < max) {
				DigitalVideoDisc temp = itemsStored[i];
				System.out.println((cur + 1) + ": " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
				cur++;
			}
		}
		if (cur == 0) {
			System.out.println("No DVDs within such price range found. Please try again");
		}
	}

	public DigitalVideoDisc checkForDemo (String n) {
		for (int i = 0; i < current; i++) {
			DigitalVideoDisc DVD = itemsStored[i];
			String title = DVD.getTitle().toLowerCase();
			if (title.contains(n)) {
				return DVD;
			}
		}
		return null;
	}
}
