package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class TestCartScreen {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            Cart cart = createTestCart();
            
            CartScreen cartScreen = new CartScreen(cart);
            cartScreen.setSize(1024, 768);
            cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
	}
	
	private static Cart createTestCart() {
        Cart cart = new Cart();
        
        cart.addMedia(new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f));
        cart.addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f));
        cart.addMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f));
        
        
        return cart;
    }

}
