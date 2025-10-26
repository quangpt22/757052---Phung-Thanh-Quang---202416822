public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private static int numItems = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore[numItems] = dvd;
        numItems++;
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int pos = dvd.getId() - 1;
        for (int i = pos; i < numItems - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }
        numItems--;
        itemsInStore[numItems] = null;
    }

    public void showStore() {
        System.out.println("***********************STORE***********************");
        if (numItems != 0) {
			for (int i = 0; i < numItems; i++) {
				DigitalVideoDisc temp = itemsInStore[i];
				System.out.println(temp.toString());
			}
		}
		else {
			System.out.println("The cart is currently empty");
		}
        System.out.println("***************************************************");
    }
    
}
