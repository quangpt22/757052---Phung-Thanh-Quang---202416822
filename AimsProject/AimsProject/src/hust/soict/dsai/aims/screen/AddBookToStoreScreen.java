package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private StoreScreen storeScreen;
    private JTextField tfTitle, tfCategory, tfCost;
    private JPanel authorsPanel;
    private List<JTextField> authorFields;

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add Book to Store");
        this.store = store;
        this.storeScreen = storeScreen;
        authorFields = new ArrayList<>();

        JPanel center = createCenter();
        this.add(center, BorderLayout.CENTER);
        this.add(createSouth(), BorderLayout.SOUTH);

        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        panel.add(tfCost);

        panel.add(new JLabel("Authors:"));
        JPanel authorButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAddAuthor = new JButton("+ Add Author");
        btnAddAuthor.addActionListener(e -> addAuthorField());
        authorButtonPanel.add(btnAddAuthor);
        panel.add(authorButtonPanel);

        authorsPanel = new JPanel();
        authorsPanel.setLayout(new BoxLayout(authorsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(authorsPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(new JLabel()); 
        panel.add(scrollPane);

        addAuthorField();

        return panel;
    }

    private void addAuthorField() {
        JPanel row = new JPanel(new BorderLayout(10, 0));
        JTextField tfAuthor = new JTextField();
        JButton btnRemove = new JButton("Remove");

        row.add(new JLabel("Author " + (authorFields.size() + 1) + ":"), BorderLayout.WEST);
        row.add(tfAuthor, BorderLayout.CENTER);
        row.add(btnRemove, BorderLayout.EAST);

        authorFields.add(tfAuthor);
        authorsPanel.add(row);
        authorsPanel.revalidate();
        authorsPanel.repaint();

        btnRemove.addActionListener(e -> {
            authorFields.remove(tfAuthor);
            authorsPanel.remove(row);
            authorsPanel.revalidate();
            authorsPanel.repaint();
            updateAuthorLabels();
        });

        if (authorFields.size() == 1) {
            btnRemove.setVisible(false);
        }
    }

    private void updateAuthorLabels() {
        Component[] rows = authorsPanel.getComponents();
        for (int i = 0; i < rows.length; i++) {
            JPanel row = (JPanel) rows[i];
            JLabel label = (JLabel) row.getComponent(0);
            label.setText("Author " + (i + 1) + ":");
        }
    }

    private JPanel createSouth() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> addBook());
        panel.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        panel.add(btnClear);

        return panel;
    }

    private void addBook() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());

            if (title.isEmpty() || category.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title and category are required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cost < 0) {
                JOptionPane.showMessageDialog(this, "Cost must be non-negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<String> authors = new ArrayList<>();
            for (JTextField tf : authorFields) {
                String author = tf.getText().trim();
                if (!author.isEmpty()) {
                    authors.add(author);
                }
            }

            if (authors.isEmpty()) {
                JOptionPane.showMessageDialog(this, "At least one author is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book book = new Book(0, title, category, cost, authors);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            if (storeScreen != null) {
                storeScreen.refresh();
            }
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid cost format.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        for (JTextField tf : authorFields) {
            tf.setText("");
        }
    }
}
