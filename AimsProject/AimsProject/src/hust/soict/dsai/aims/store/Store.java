package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public void addMedia(Media media) {
    	if (!(itemsInStore.contains(media))) {
    		itemsInStore.add(media);
    	}
    	else {
    		System.out.println("Store already has media");
    	}
    }
    
    public void removeMedia(Media media) {
    	if (itemsInStore.contains(media)) {
    		itemsInStore.remove(media);
    	}
    	else {
    		System.out.println("Store doesn't have the media");
    	}
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
    
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
}
