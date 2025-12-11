package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;
    private StoreScreen storeScreen;
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add DVD to Store");
        this.store = store;
        this.storeScreen = storeScreen;

        JPanel center = createCenter();
        this.add(center, BorderLayout.CENTER);
        this.add(createSouth(), BorderLayout.SOUTH);

        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Length (minutes):"));
        tfLength = new JTextField();
        panel.add(tfLength);

        panel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        panel.add(tfCost);

        return panel;
    }

    private JPanel createSouth() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> addDVD());
        panel.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        panel.add(btnClear);

        return panel;
    }

    private void addDVD() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());
            float cost = Float.parseFloat(tfCost.getText().trim());

            if (title.isEmpty() || category.isEmpty() || director.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (length <= 0 || cost < 0) {
                JOptionPane.showMessageDialog(this, "Length and cost must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            if (storeScreen != null) {
                storeScreen.refresh();
            }
            JOptionPane.showMessageDialog(this, "DVD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number format in length or cost.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfDirector.setText("");
        tfLength.setText("");
        tfCost.setText("");
    }
}
