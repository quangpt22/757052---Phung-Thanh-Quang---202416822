package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.*;
import javafx.fxml.*;
import javafx.scene.*;

public class CartScreen extends JFrame{

	private Cart cart;
	private Store store;

    public CartScreen(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setSize(1240, 768);
        this.setTitle("Cart");
        this.setVisible(true);
        final CartScreen outerThis = this;
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                        .getResource("cart.fxml"));
                    CartScreenController controller = 
                        new CartScreenController(cart, store, outerThis);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
