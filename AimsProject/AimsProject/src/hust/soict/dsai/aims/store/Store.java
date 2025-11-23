package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

//    public void addDVD(DigitalVideoDisc dvd) {
//        itemsInStore[numItems] = dvd;
//        numItems++;
//    }
//
//    public void removeDVD(DigitalVideoDisc dvd) {
//        int pos = dvd.getId() - 1;
//        for (int i = pos; i < numItems - 1; i++) {
//            itemsInStore[i] = itemsInStore[i + 1];
//        }
//        numItems--;
//        itemsInStore[numItems] = null;
//    }
    
    public void addDVD(Media media) {
    	itemsInStore.add(media);
    }
    
    public void removeDVD(Media media) {
    	itemsInStore.remove(media);
    }

    public void showStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.size() != 0) {
			for (int i = 0; i < itemsInStore.size(); i++) {
				Media media = itemsInStore.get(i);
				System.out.println(media.toString());
			}
		}
		else {
			System.out.println("The cart is currently empty");
		}
        System.out.println("***************************************************");
    }
    
}
