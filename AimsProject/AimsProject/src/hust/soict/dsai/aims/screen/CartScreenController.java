package hust.soict.dsai.aims.screen;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

private Cart cart;
private Store store;
private CartScreen cartScreen;
    
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label lblTotalCost;
    
    @FXML
    private MenuItem itemViewStore;
    
    @FXML
    private Button btnPlaceOrder;
    
    public CartScreenController(Cart cart, Store store, CartScreen cartScreen) {
        super();
        this.cart = cart;
        this.store = store;
        this.cartScreen = cartScreen;
    }
    
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        totalCostDisplay();
        
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            totalCostDisplay();
        });
        
        if (itemViewStore != null) {
            itemViewStore.setOnAction(e -> viewStorePressed(e));
        }
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>() {
        			
        		@Override
        		public void changed(ObservableValue<? extends Media> observable, Media oldValue,
        				Media newValue) {
        			if (newValue!=null) {
        				updateButtonBar(newValue);
        			}
        		}
        		});
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    
    void totalCostDisplay() {
        float total = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f$", total));
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @FXML
    void viewStorePressed(ActionEvent event) {
    	cartScreen.dispose();
        
        SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, cart);
        });
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.placeOrder(); 
        tblMedia.getItems().clear();
        totalCostDisplay();
    }
}
