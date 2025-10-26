package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
        cart.addDigitalVideoDisc(dvd3);

        // Test print method
        cart.print();

        // Test search by ID
        DigitalVideoDisc disk1 = cart.searchById(2);
        System.out.println(disk1.toString());

        // Test search by title
        DigitalVideoDisc disk2 = cart. searchByTitle("godfather");
        System.out.println(disk2.toString());
    }
}
