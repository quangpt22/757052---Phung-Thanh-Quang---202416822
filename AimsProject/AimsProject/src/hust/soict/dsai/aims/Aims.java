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
	    
	    SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, anOrder);
        });
	}
}
