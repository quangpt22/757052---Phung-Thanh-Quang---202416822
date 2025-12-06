package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	static Scanner sc = new Scanner(System.in);
	static Cart anOrder;
	static Store store;
	public static void main(String[] args) {
		anOrder = new Cart();
		store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Good, the Bad and the Ugly", "Western", "Sergio Leone", 178, 22.95f);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		List<String> lotrAuthors = new ArrayList<String>();
	    lotrAuthors.add("J.R.R. Tolkien");
	    Book book1 = new Book(2, "The Lord of the Rings", "Fantasy", 24.99f, lotrAuthors);
	    List<String> duneAuthors = new ArrayList<String>();
	    duneAuthors.add("Frank Herbert");
	    Book book2 = new Book(5, "Dune", "Science Fiction", 16.99f, duneAuthors);
	    List<String> multipleAuthors = new ArrayList<String>();
	    multipleAuthors.add("Erich Gamma");
	    multipleAuthors.add("Richard Helm");
	    multipleAuthors.add("Ralph Johnson");
	    multipleAuthors.add("John Vlissides");
	    Book book3 = new Book(6, "Design Patterns", "Programming", 45.00f, multipleAuthors);
	    store.addMedia(book1);
	    store.addMedia(book2);
	    store.addMedia(book3);
	    List<Track> rockTracks = new ArrayList<Track>();
	    rockTracks.add(new Track("Bohemian Rhapsody", 355));
	    rockTracks.add(new Track("We Will Rock You", 122));
	    rockTracks.add(new Track("We Are the Champions", 179));
	    rockTracks.add(new Track("Somebody to Love", 309));
	    CompactDisc cd1 = new CompactDisc("Greatest Hits", "Rock", 15.99f, 965, "Various", "Queen", rockTracks);
	    List<Track> popTracks = new ArrayList<Track>();
	    popTracks.add(new Track("Thriller", 357));
	    popTracks.add(new Track("Beat It", 258));
	    popTracks.add(new Track("Billie Jean", 294));
	    popTracks.add(new Track("Smooth Criminal", 258));
	    CompactDisc cd2 = new CompactDisc("Thriller", "Pop", 14.99f, 1167, "Quincy Jones", "Michael Jackson", popTracks);
	    List<Track> classicalTracks = new ArrayList<Track>();
	    classicalTracks.add(new Track("Symphony No. 5", 452));
	    classicalTracks.add(new Track("Moonlight Sonata", 900));
	    classicalTracks.add(new Track("Fur Elise", 180));
	    classicalTracks.add(new Track("The Four Seasons", 1620));
	    CompactDisc cd3 = new CompactDisc("Classical Masterpieces", "Classical", 12.50f, 3152, "Various Conductors", "Various Artists", classicalTracks);
	    List<Track> jazzTracks = new ArrayList<Track>();
	    jazzTracks.add(new Track("Take Five", 324));
	    jazzTracks.add(new Track("So What", 562));
	    jazzTracks.add(new Track("My Favorite Things", 838));
	    jazzTracks.add(new Track("Autumn Leaves", 273));
	    CompactDisc cd4 = new CompactDisc("Jazz Essentials", "Jazz", 13.75f, 1997, "Various", "Jazz Legends", jazzTracks);
	    store.addMedia(cd1);
	    store.addMedia(cd2);
	    store.addMedia(cd3);
	    store.addMedia(cd4);
//		showMenu();
	    
	    
	    SwingUtilities.invokeLater(() -> {
            new StoreScreen(store);
        });
	}
	
	public static void showMenu() {
		int choice;
		do {
			System.out.println("AIMS: ");
			System.out.println("-----------------------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("-----------------------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}
			
			switch(choice) {
			case 1:
				storeMenu();
				break;
			case 2:
				updateStoreMenu();
				break;
			case 3:
				cartMenu();
				break;
			case 0:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("!!! Index out of range, please try again");
			}
		}
		while (true);
	}
	
	public static void storeMenu() {
		int choice;
		do {
			store.showStore();
			System.out.println("Options: ");
			System.out.println("-----------------------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("-----------------------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}
			switch(choice) {
				case 1:
					seeMediaDetails();
					break;
				case 2:
					addMediaToCart();
					break;
				case 3:
					playMedia();
					break;
				case 4:
					break;
				case 0:
					return;
				default:
					System.out.println("!!! Index out of range, please try again");
					break;
			}
		}
		while (true);
	}
	
	public static void seeMediaDetails() {
		System.out.print("Enter media title: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        
        if (media != null) {
            System.out.println("Media Details:");
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } 
        else {
            System.out.println("!!! Media not found");
        }
	}
	
	public static void mediaDetailsMenu(Media media) {
		int choice;
		do {
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}
			switch(choice) {
			case 1:
				anOrder.addMedia(media);
				System.out.println("Number of media in current cart: " + anOrder.size());
				return;
			case 2:
				if (media instanceof Playable) {
					((Playable) media).play();
					break;
				}
				else {
					System.out.println("!!! Media can't be played");
					break;
				}
			case 0:
				return;
			default:
				System.out.println("!!! Index out of range, please try again");
				break;
			}
			
		}
		while (true);
	}
	
	public static void addMediaToCart() {
		System.out.print("Enter media title: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        
        if (media != null) {
            anOrder.addMedia(media);
            System.out.println("Number of media in current cart: " + anOrder.size());
        } 
        else {
            System.out.println("!!! Media not found");
        }
	}
	
	public static void playMedia() {
        System.out.print("Enter media title: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("!!! Media not found or cannot be played");
        }
    }
	
	public static void cartMenu() {
		int choice;
		do {
			anOrder.displayCart();
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. Filter medias in cart"); 
			System.out.println("2. Sort medias in cart"); 
			System.out.println("3. Remove media from cart"); 
			System.out.println("4. Play a media"); 
			System.out.println("5. Place order"); 
			System.out.println("0. Back"); 
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2-3-4-5"); 
		
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (java.util.InputMismatchException e) {
				System.out.println("!!! Invalid option, please try again");
				sc.nextLine();
				continue;
			}
			switch(choice) {
			case 1:
				filterCartMenu();
				break;
			case 2:
				sortCartMenu();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMediaFromCart();
				break;
			case 5:
				anOrder.placeOrder();
				break;
			case 0:
				return;
			default:
				System.out.println("!!! Index out of range, please try again");
				break;
			}
		}
		while (true);
	}
	
	public static void sortCartMenu() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.println("0. Return");
        System.out.println("Choose option: ");
        
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice) {
            case 1:
                anOrder.sortByTitleCost();
                System.out.println("Cart sorted by Title then Cost");
                break;
            case 2:
                anOrder.sortByCostTitle();
                System.out.println("Cart sorted by Cost then Title");
                break;
            case 3:
            	break;
            default:
                System.out.println("Invalid option!");
        }
    }
	
	public static void filterCartMenu() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Return");
        System.out.print("Choose option: ");
        
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                anOrder.filterById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                anOrder.filterByTitle(title);
                break;
            case 0:
            	break;
            default:
                System.out.println("Invalid option!");
        }
    }
	
	public static void playMediaFromCart() {
        System.out.print("Enter media title: ");
        String title = sc.nextLine();
        Media media = anOrder.findMediaByTitle(title);
        
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played!");
        }
    }
	
	public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = sc.nextLine();
        Media media = anOrder.findMediaByTitle(title);
        
        if (media != null) {
            anOrder.removeMedia(media);
        } else {
            System.out.println("Media not found in cart!");
        }
    }
	
	public static void updateStoreMenu() {
        int choice;
        do {
            System.out.println("Update Store:");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("-----------------------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("!!! Invalid option, please try again");
                sc.nextLine();
                continue;
            }
            
            switch(choice) {
                case 1:
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("!!! Invalid option, please try again");
            }
        } while (true);
    }
	
	public static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String title = sc.nextLine();
        Media media = store.findMediaByTitle(title);
        
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found!");
        }
    }
	

}
