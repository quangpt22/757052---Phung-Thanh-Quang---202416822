package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.*;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");
	    JMenu smUpdateStore = new JMenu("Update Store");
	    
	    JMenuItem addDVD = new JMenuItem("Add DVD");
	    addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, this));
	    smUpdateStore.add(addDVD);
	    
	    JMenuItem addBook = new JMenuItem("Add Book");
	    addBook.addActionListener(e -> new AddBookToStoreScreen(store, this));
	    smUpdateStore.add(addBook);
	    
	    JMenuItem addCD = new JMenuItem("Add CD");
	    addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, this));
	    smUpdateStore.add(addCD);
	    
	    menu.add(smUpdateStore);
	    
	    JMenuItem viewCart = new JMenuItem("View cart");
	    menu.add(new JMenuItem("View store"));
	    viewCart.addActionListener(e -> openCartScreen());
	    menu.add(viewCart);
	    
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);
	    return menuBar;
	}
	
	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);
	    JButton cart = new JButton("View cart");
	    cart.setPreferredSize(new Dimension(100, 50));
	    cart.setMaximumSize(new Dimension(100, 50));
	    cart.addActionListener(e -> openCartScreen());
	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(cart);
	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    return header;
	}
	
	JScrollPane createCenter() {
	    
		ArrayList<Media> mediaInStore = store.getItemsInStore();
	    int itemCount = mediaInStore.size();
	    
	    int columns = 3;
	    int rows = (int) Math.ceil(itemCount / (double) columns);
	    
	    JPanel mediaPanel = new JPanel();
	    mediaPanel.setLayout(new GridLayout(rows, columns, 10, 10));
	    
	    for (Media media : mediaInStore) {
	        MediaStore cell = new MediaStore(media, this);
	        cell.setPreferredSize(new Dimension(300, 200));
	        mediaPanel.add(cell);
	    }
	    
	    int emptySlots = rows * columns - itemCount;
	    for (int i = 0; i < emptySlots; i++) {
	        mediaPanel.add(new JPanel());
	    }
	    
	    JScrollPane scrollPane = new JScrollPane(mediaPanel);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	    return scrollPane;
	}
	
	public StoreScreen(Store store, Cart cart) {
	    this.store = store;
	    this.cart = cart;
	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    cp.add(createNorth(), BorderLayout.NORTH);
	    cp.add(createCenter(), BorderLayout.CENTER);
	    setVisible(true);
	    setTitle("Store");
	    setSize(1024, 768);
	}
	
	public Cart getCart() {
        return cart;
    }
    
    public void addToCart(Media media) {
        cart.addMedia(media);
        System.out.println("Added: " + media.getTitle());
    }
    
    private void openCartScreen() {
        SwingUtilities.invokeLater(() -> {
            CartScreen cartScreen = new CartScreen(cart, store);
        });
    }
    
    public void refresh() {
        Container cp = getContentPane();
        cp.remove(cp.getComponent(1)); 
        cp.add(createCenter(), BorderLayout.CENTER);
        cp.revalidate();
        cp.repaint();
    }
}
