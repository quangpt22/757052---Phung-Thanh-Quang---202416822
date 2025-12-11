package hust.soict.dsai.aims.screen;

import java.awt.*;

import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

public class MediaStore extends JPanel{

	private Media media;
	private StoreScreen storeScreen;
	
    public MediaStore(Media media, StoreScreen storeScreen) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
        	storeScreen.getCart().addMedia(media);
        });
        container.add(btnAddToCart);
        
        if (media instanceof Playable) {
        	JButton btnPlay = new JButton("Play");
        	btnPlay.addActionListener(e -> playMedia());
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private void playMedia() {
    	if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(this, 
                    "Error playing " + media.getTitle() + ":\n" + e.getMessage(), 
                    "Playback Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
