package aims_package;
import java.util.Scanner;

public class Aims {
	static Scanner sc = new Scanner(System.in);
	static Store store;
	static Cart anOrder;
	public static void main(String[] args) {
	
		anOrder = new Cart();
		/*
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.showCart();
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.showCart();
		*/
		store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("12 Angry Men", "Drama", "Sidney Lumet", 96, 19.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Schindler's List", "History", "Steven Spielberg", 195, 30.95f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 24.50f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Good, the Bad and the Ugly", "Western", "Sergio Leone", 178, 22.95f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 23.95f);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 24.95f);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 26.50f);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 27.50f);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Se7en", "Crime", "David Fincher", 127, 23.50f);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 24.50f);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 26.95f);
		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Django Unchained", "Western", "Quentin Tarantino", 165, 26.95f);
		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 25.95f);
		DigitalVideoDisc dvd19 = new DigitalVideoDisc("The Prestige", "Mystery", "Christopher Nolan", 130, 24.95f);
		DigitalVideoDisc dvd20 = new DigitalVideoDisc("Saving Private Ryan", "War", "Steven Spielberg", 169, 21.50f);
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 20.50f);
		DigitalVideoDisc dvd22 = new DigitalVideoDisc("The Empire Strikes Back", "Science Fiction", "Irvin Kershner", 124, 19.95f);
		DigitalVideoDisc dvd23 = new DigitalVideoDisc("City of God", "Crime", "Fernando Meirelles", 130, 19.95f);
		DigitalVideoDisc dvd24 = new DigitalVideoDisc("The Pianist", "Biography", "Roman Polanski", 150, 20.50f);
		DigitalVideoDisc dvd25 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon Ho", 132, 20.95f);
		store.addToStore(dvd1);
		store.addToStore(dvd2);
		store.addToStore(dvd3);
		store.addToStore(dvd4);
		store.addToStore(dvd5);
		store.addToStore(dvd6);
		store.addToStore(dvd7);
		store.addToStore(dvd8);
		store.addToStore(dvd9);
		store.addToStore(dvd10);
		store.addToStore(dvd11);
		store.addToStore(dvd12);
		store.addToStore(dvd13);
		store.addToStore(dvd14);
		store.addToStore(dvd15);
		store.addToStore(dvd16);
		store.addToStore(dvd17);
		store.addToStore(dvd18);
		store.addToStore(dvd19);
		store.addToStore(dvd20);
		store.addToStore(dvd21);
		store.addToStore(dvd22);
		store.addToStore(dvd23);
		store.addToStore(dvd24);
		store.addToStore(dvd25);

		logIn();
	}

	public static void logIn () {
		System.out.println("-----------------------------------------------");
		System.out.println("Log in: Please choose your role");
		System.out.println("1. Customer");
		System.out.println("2. Store manager");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
			case 1:
				customerActions();
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}

	}

	public static void customerActions() {
		System.out.println("-----------------------------------------------");
		System.out.println("What do you want to do?");
		System.out.println("1. Browse DVDS available");
		System.out.println("2. Search DVD");
		System.out.println("3. View cart");
		System.out.println("4. Exit to login screen");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
			case 1:
				browseDVD();
				break;
			case 2:
				searchDVD();
				break;
			case 3:
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
	}

	public static void browseDVD() {
		System.out.println("-----------------------------------------------");
		store.browseStore();

		System.out.println("Enter 0 to go back");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
			case 0:
				return;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
	}

	public static void searchDVD() {
		System.out.println("-----------------------------------------------");
		System.out.println("Which type of search do you want?");
		System.out.println("1. Search by title");
		System.out.println("2. Search by category");
		System.out.println("3. Search by price");
		System.out.println("4. Exit to main screen");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
			case 1:
				System.out.println("-----------------------------------------------");
				store.searchDVDByTitle();
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
				detailScreen();
				break;
			case 2:
				System.out.println("-----------------------------------------------");
				store.searchDVDByCategory();
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
				detailScreen();
				break;
			case 3:
				System.out.println("-----------------------------------------------");
				store.searchDVDByPrice();
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
				detailScreen();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
	}

	public static void detailScreen() {
		System.out.println("Please choose the following actions: ");
		System.out.println("1. View detail information");
		System.out.println("2. Play demo");
		System.out.println("3. Go back to search DVD screen");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
			case 1:
				System.out.println("-----------------------------------------------");
				System.out.println("Enter the title of the DVD you want to view detail information:");
				String dvdInfo = sc.nextLine().toLowerCase();
				DigitalVideoDisc addedDVD = store.checkForDemo(dvdInfo);
				if (addedDVD != null) {
					System.out.println("Film name: " + addedDVD.getTitle());
					System.out.println("Category: " + addedDVD.getCategory());
					System.out.println("Director: " + addedDVD.getDirector());
					System.out.println("Length: " + addedDVD.getLength());
					System.out.println("Price: " + addedDVD.getCost());
					System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
					System.out.println("Please proceed with these actions:");
					System.out.println("1. Add to cart");
					System.out.println("2. Return");
					int opt = sc.nextInt();
					sc.nextLine();
					if (opt == 1) {
						anOrder.addDigitalVideoDisc(addedDVD);
						anOrder.showCart();
					}
					else if (opt == 2) {
						return;
					}
					else {
						System.out.println("Invalid option, please try again.");
					}
				}
				else {
					System.out.println("Invalid title, please try again.");
				}
				break;
			case 2:
				System.out.println("-----------------------------------------------");
				System.out.println("Enter the title of the DVD you want to play demo:");
				String demoDVD = sc.nextLine().toLowerCase();
				DigitalVideoDisc DVD = store.checkForDemo(demoDVD);
				if (DVD != null) {
					playDemo(DVD);
				}
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid option, please try again.");
				break;
		}
	}

	public static void playDemo(DigitalVideoDisc disc) {
		int length = disc.getLength();
		if (length <= 0) {
			System.out.println("The demo can't be played. You will be redirected to the previous page");
			return;
		}
		else {
			System.out.println("The demo is being played");
			System.out.println("The demo has ended. You will be redirected to the previous page.");
			System.out.println("-----------------------------------------------");
			return;
		}
	}
}
