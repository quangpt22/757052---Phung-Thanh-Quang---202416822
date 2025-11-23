package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
//	public void initializeStore() {
//		store[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		store[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		store[2] = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
//		store[3] = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
//		store[4] = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f);
//		store[5] = new DigitalVideoDisc("12 Angry Men", "Drama", "Sidney Lumet", 96, 19.95f);
//		store[6] = new DigitalVideoDisc("Schindler's List", "History", "Steven Spielberg", 195, 30.95f);
//		store[7] = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 24.50f);
//		store[8] = new DigitalVideoDisc("The Good, the Bad and the Ugly", "Western", "Sergio Leone", 178, 22.95f);
//		store[9] = new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 23.95f);
//	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
//		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//			itemsOrdered[qtyOrdered] = dvd;
//			qtyOrdered++;
//			System.out.println("The disc has been added");
//		}
//		else {
//			System.out.println("The cart is almost full!");
//		}
//	}
//
//	public void addDigitalVideoDisc(int i) {
//		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//			itemsOrdered[qtyOrdered] = store[i - 1];
//			qtyOrdered++;
//			System.out.println("The disc has been added");
//		}
//		else {
//			System.out.println("The cart is almost full!");
//		}
//	}
//
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
//			for (int i = 0; i < dvdList.length; i++) {
//				itemsOrdered[qtyOrdered] = dvdList[i];
//				qtyOrdered++;
//			}
//			System.out.println("The discs have been added");
//		}
//		else {
//			System.out.println("The cart is almost full!");
//		}
//	}
//
//	public void addArbitraryDigitalVideoDisc(DigitalVideoDisc... dvds) {
//    	if (qtyOrdered + dvds.length <= MAX_NUMBERS_ORDERED) {
//        	for (int i = 0; i < dvds.length; i++) {
//            	itemsOrdered[qtyOrdered] = dvds[i];
//				qtyOrdered++;
//    	    }
//    	    System.out.println("The discs have been added");
//    	} else {
//    	    System.out.println("The cart is almost full!");
//    	}
//	}
//
//
//	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
//			itemsOrdered[qtyOrdered] = dvd1;
//			itemsOrdered[qtyOrdered + 1] = dvd2;
//			qtyOrdered += 2;
//			System.out.println("The discs have been added");
//		}
//		else {
//			System.out.println("The cart is almost full!");
//		}
//	}
//	
//	public void removeDigitalVideoDisc(int i) {
//		i--;
//		itemsOrdered[i] = null;
//		for (int j = i; j < qtyOrdered - 1; j++) {
//			itemsOrdered[j] = itemsOrdered[j + 1];
//		}
//		qtyOrdered--;
//		itemsOrdered[qtyOrdered] = null;
//		System.out.println("The disc has been removed");
//	}
	
	public void addMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Media has been added to cart");
        } else {
            System.out.println("Media is already in cart");
        }
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Media has been removed");
        } else {
            System.out.println("Media not found in cart");
        }
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    public int size() {
    	return itemsOrdered.size();
    }
    
    public void displayCart() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is currently empty");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
            System.out.println("Total cost: $" + totalCost());
        }
        System.out.println("***************************************************");
    }
    
    public void filterById(int id) {
        System.out.println("Medias with ID " + id + ":");
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
            }
        }
    }
    
    public void filterByTitle(String title) {
        System.out.println("Medias with title containing \"" + title + "\":");
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
            }
        }
    }
    
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void placeOrder() {
        System.out.println("Order has been successfully created!");
        itemsOrdered.clear();
    }
}
