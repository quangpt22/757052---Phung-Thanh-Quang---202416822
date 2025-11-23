package hust.soict.dsai.test.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.*;
//import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("title", "cate", "dir", 10, 5.0f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("JK Rowling");
        authors.add("Jack Whitehall");
        Book book = new Book(1, "tit", "cat", 6.0f, authors);
        ArrayList<Track> tracks = new ArrayList<Track>();
        Track t1 = new Track("uno", 12);
        Track t2 = new Track("dos", 6);
        tracks.add(t1);
        tracks.add(t2);
        CompactDisc cd = new CompactDisc("hello", "rock", 13.0f, 20, "ABC", "adele", tracks);
        
        mediae.add(dvd);
        mediae.add(dvd1);
        mediae.add(book);
        mediae.add(cd);
        
        for (Media m: mediae) {
        	System.out.println(m.toString());
        }
    }
}