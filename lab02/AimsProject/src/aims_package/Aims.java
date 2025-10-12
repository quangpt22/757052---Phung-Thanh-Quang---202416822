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
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Log in: Please choose your role");
			System.out.println("1. Customer");
			System.out.println("2. Store manager");
			System.out.println("3. Exit the program");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					customerActions();
					break;
				case 2:
					break;
				case 3:
					System.out.println("Exiting the program...");
					break;
				default:
					System.out.println("!!! Invalid option, please try again.");
					break;
			}
		}
		while (choice != 3);
	}

	public static void customerActions() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("What do you want to do?");
			System.out.println("1. Browse DVDS available");
			System.out.println("2. Search DVD");
			System.out.println("3. View cart");
			System.out.println("4. Exit to login screen");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					browseDVD();
					break;
				case 2:
					searchDVD();
					break;
				case 3:
					viewCart();
					break;
				case 4:
					return;
				default:
					System.out.println("!!! Invalid option, please try again.");
					break;
			}
		}
		while (true);
	}

	public static void browseDVD() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			store.browseStore();

			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			System.out.println("Enter 0 to go back");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 0:
					return;
				default:
					System.out.println("!!! Invalid option, please try again.");
					break;
			}
		}
		while (choice != 0);
	}

	public static void searchDVD() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Which type of search do you want?");
			System.out.println("1. Search by title");
			System.out.println("2. Search by category");
			System.out.println("3. Search by price");
			System.out.println("4. Exit to main screen");
			choice = sc.nextInt();
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
					System.out.println("!!! Invalid option, please try again.");
					break;
			}
		}
		while (true);
	}

	public static void detailScreen() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Please choose the following actions: ");
			System.out.println("1. View detail information");
			System.out.println("2. Play demo");
			System.out.println("3. Go back to search DVD screen");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					viewDVDInfo();
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
					System.out.println("!!! Invalid option, please try again.");
					break;
			}
		}
		while (true);
	}

	public static void viewDVDInfo () {
		do {
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
					return;
				}
				else if (opt == 2) {
					return;
				}
				else {
					System.out.println("!!! Invalid option, please try again.");
				}
			}	
			else {
				System.out.println("!!! Invalid title, please try again.");
			}
		}
		while (true);
	}

	public static void playDemo(DigitalVideoDisc disc) {
		int length = disc.getLength();
		if (length <= 0) {
			System.out.println("The demo can't be played. You will be redirected to the previous page");
			return;
		}
		else {
			System.out.println("The demo is being played...");
			System.out.println("The demo has ended. You will be redirected to the previous page.");
			System.out.println("-----------------------------------------------");
			return;
		}
	}

	public static void viewCart() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("YOUR CURRENT CART:");
			anOrder.showCart();
			System.out.println("Total cost: " + anOrder.totalCost() + "$");
			System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			System.out.println("What do you want to do next?");
			System.out.println("1. Listen to demo");
			System.out.println("2. Sort");
			System.out.println("3. Update quantity");
			System.out.println("4. Remove DVD");
			System.out.println("5. Filter DVDs");
			System.out.println("6. Place order");
			System.out.println("7. Go back");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					listenToDemo();
					break;
				case 2:
					sortCart();
					break;
				case 3:
					updateQuantityOption();
					break;
				case 4:
					removeDVD();
					break;
				case 5:
					filterDVD();
					break;
				case 6:
					placeOrder();
					break;
				case 7:
					return;
				default:
					break;
			}
		}
		while (true);
	}

	public static void listenToDemo() {
		int choice = -1;
		do {
			System.out.println("Enter the index of the DVD you want to listen to the demo:");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice <= Cart.qtyOrdered) {
					playDemo(anOrder.indexToDisc(choice));
					return;
				}
				else {
					System.out.println("!!! Index out of range, please try again");
					choice = -1;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				choice = -1;
			}
		}
		while (true);
	}

	public static void sortCart() {

	}

	public static void removeDVD () {
		int choice = -1;
		do {
			System.out.println("Enter the index of the DVD you want to remove:");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice <= Cart.qtyOrdered) {
					anOrder.removeDigitalVideoDisc(choice);
					System.out.println("The disk has been removed.");
					return;
				}
				else {
					System.out.println("!!! Index out of range, please try again");
					choice = -1;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				choice = -1;
			}
		}
		while (choice == -1);
	}

	public static void filterDVD() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Choose filter type:");
			System.out.println("1. Filter by id");
			System.out.println("2. Filter by title");
			System.out.println("3. Go back");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					filterId();
					break;
				case 2:
					filterTitle();
					break;
				case 3: 
					return;
				default:
					break;
			}
		}
		while (true);
	}

	public static void filterId() {
		int choice;
		do {
			System.out.println("Enter the index of the DVD you want to filter:");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice <= Cart.qtyOrdered) {
					DigitalVideoDisc temp = anOrder.indexToDisc(choice);
					System.out.println("Item found: " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$" + " - " + anOrder.getQuantity(choice) + " item(s)");
					return;
				}
				else {
					System.out.println("!!! Item not found. Please index within range.");
					choice = -1;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Item not found. Please enter number.");
				sc.nextLine();
				choice = -1;
			}
		}
		while (choice == -1);
	}

	public static void filterTitle() {
		String title;
		do {
			System.out.println("Enter the index of the DVD you want to filter:");
				title = sc.nextLine().toLowerCase();
				DigitalVideoDisc temp = anOrder.titleToDisc(title);
				if (temp != null) {
					System.out.println("Item found: " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$");
					return;
				}
				else {
					System.out.println("!!! Item not found. Please make sure there are no mispellings.");
				}
		}
		while (true);
	}

	public static void updateQuantityOption() {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the index of the DVD you want to update quantity:");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice <= Cart.qtyOrdered) {
					DigitalVideoDisc temp = anOrder.indexToDisc(choice);
					System.out.println("Item: " + temp.getTitle() + " - " + temp.getCategory() + " - " + temp.getDirector() + " - " + temp.getLength() + " mins - " + temp.getCost() + "$" + " - " + anOrder.getQuantity(choice) + " item(s)");
					updateQuantityNumber(choice);
					return;
				}
				else {
					System.out.println("!!! Item not found. Please index within range.");
					choice = -1;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Item not found. Please enter number.");
				sc.nextLine();
				choice = -1;
			}
		}
		while (choice == -1);
	}

	public static void updateQuantityNumber(int index) {
		int choice;
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the new quantity between 1 and 20 (Quantity <= 0 means removing the DVD)");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if (choice > 0 && choice <= 20) {
					anOrder.setQuantity(index, choice);
					System.out.println("Quantity has been updated.");
					return;
				}
				else if (choice <= 0) {
					anOrder.removeDigitalVideoDisc(index);
					System.out.println("Quantity has been updated (Removing the DVD)");
					return;
				}
				else {
					System.out.println("!!! Quantity over limits. Please index within range.");
					choice = -1;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Quantity not possible. Please enter number.");
				sc.nextLine();
				choice = -1;
			}
		}
		while (choice == -1);
	}

	public static void placeOrder() {
		int choice;
		if (Cart.qtyOrdered == 0) {
        	System.out.println("!!! Your cart is empty. Please add some DVDs before placing an order.");
        	return;
    	}
		do {
			System.out.println("-----------------------------------------------");
			System.out.println("Please enter your name: ");
			String custName = sc.nextLine();
			double finalFee = anOrder.feeCalculation();
			System.out.println("-----------------------------------------------");
			System.out.println("Please choose the following options:");
			System.out.println("1. Proceed to payment screen");
			System.out.println("2. Cancel and return to the previous page");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}

			if (choice == 1) {
				long transactionId = Math.round(Math.random() * 9000000) + 1000000;
				System.out.println("PAYMENT DETAIL:");
				System.out.println("Transaction ID: " + transactionId);
				System.out.println("Customer name: " + custName);
				System.out.println("Transfer amount: " + finalFee +"$");
				System.out.println("Please choose the following options:");
				System.out.println("1. Pay order");
				System.out.println("2. Cancel");

				int confirm;
				try {
					confirm = sc.nextInt();
					sc.nextLine();
				} catch (java.util.InputMismatchException e) {
					System.out.println("!!! Invalid option, please try again");
					sc.nextLine();
					continue;
				}

				if (confirm == 1) {
					System.out.println("Thank you for your order. The order will be processed by the store manager and proceed to you soon.");
					while (Cart.qtyOrdered > 0) {
                    	anOrder.removeDigitalVideoDisc(1);
						anOrder.setQuantity(1, 0);
                	}
					return;
				}
				else if (confirm == 2) {
					anOrder.resetQuantityAfterCancel();
					System.out.println("Order cancelled. Returning to your cart screen...");
					return;
				}
				else {
					System.out.println("!!! Index out of range, please try again");
				}

			}
			else if (choice == 2) {
				anOrder.resetQuantityAfterCancel();
				System.out.println("Returning to the previous page...");
				return;
			}
			else {
				System.out.println("!!! Index out of range, please try again");
			}				
		}
		while (true);
	}	
}