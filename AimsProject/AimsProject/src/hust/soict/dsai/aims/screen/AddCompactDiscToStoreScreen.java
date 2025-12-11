package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {
    private Store store;
    private StoreScreen storeScreen;
    private JTextField tfTitle, tfCategory, tfCost, tfArtist, tfDirector;
    private JPanel tracksPanel;
    private List<JTextField> trackTitleFields, trackLengthFields;

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super("Add CD to Store");
        this.store = store;
        this.storeScreen = storeScreen;
        trackTitleFields = new ArrayList<>();
        trackLengthFields = new ArrayList<>();

        JPanel center = createCenter();
        this.add(center, BorderLayout.CENTER);
        this.add(createSouth(), BorderLayout.SOUTH);

        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        panel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        // Category
        panel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        // Cost
        panel.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        panel.add(tfCost);

        // Artist
        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);

        // Director
        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        // Tracks header
        panel.add(new JLabel("Tracks:"));
        JPanel trackButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAddTrack = new JButton("+ Add Track");
        btnAddTrack.addActionListener(e -> addTrackField());
        trackButtonPanel.add(btnAddTrack);
        panel.add(trackButtonPanel);

        // Tracks panel (dynamic)
        tracksPanel = new JPanel();
        tracksPanel.setLayout(new BoxLayout(tracksPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(tracksPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panel.add(new JLabel()); // empty cell
        panel.add(scrollPane);

        // Add first track by default
        addTrackField();

        return panel;
    }

    private void addTrackField() {
        JPanel row = new JPanel(new GridLayout(1, 4, 10, 0));
        JTextField tfTrackTitle = new JTextField();
        JTextField tfTrackLength = new JTextField();
        JButton btnRemove = new JButton("Remove");

        row.add(new JLabel("Track " + (trackTitleFields.size() + 1) + ":"));
        row.add(new JLabel("Title:"));
        row.add(tfTrackTitle);
        row.add(new JLabel("Length (s):"));
        row.add(tfTrackLength);
        row.add(btnRemove);

        trackTitleFields.add(tfTrackTitle);
        trackLengthFields.add(tfTrackLength);
        tracksPanel.add(row);
        tracksPanel.revalidate();
        tracksPanel.repaint();

        btnRemove.addActionListener(e -> {
            int index = trackTitleFields.indexOf(tfTrackTitle);
            trackTitleFields.remove(tfTrackTitle);
            trackLengthFields.remove(tfTrackLength);
            tracksPanel.remove(row);
            tracksPanel.revalidate();
            tracksPanel.repaint();
            updateTrackLabels();
        });

        // Hide remove if only track
        if (trackTitleFields.size() == 1) {
            btnRemove.setVisible(false);
        }
    }

    private void updateTrackLabels() {
        Component[] rows = tracksPanel.getComponents();
        for (int i = 0; i < rows.length; i++) {
            JPanel row = (JPanel) rows[i];
            JLabel label = (JLabel) row.getComponent(0);
            label.setText("Track " + (i + 1) + ":");
        }
    }

    private JPanel createSouth() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> addCD());
        panel.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        panel.add(btnClear);

        return panel;
    }

    private void addCD() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String artist = tfArtist.getText().trim();
            String director = tfDirector.getText().trim();

            if (title.isEmpty() || category.isEmpty() || artist.isEmpty() || director.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cost < 0) {
                JOptionPane.showMessageDialog(this, "Cost must be non-negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Collect tracks
            List<Track> tracks = new ArrayList<>();
            for (int i = 0; i < trackTitleFields.size(); i++) {
                String trackTitle = trackTitleFields.get(i).getText().trim();
                String lengthStr = trackLengthFields.get(i).getText().trim();

                if (trackTitle.isEmpty() || lengthStr.isEmpty()) {
                    continue; // skip empty tracks
                }

                int length = Integer.parseInt(lengthStr);
                if (length <= 0) {
                    JOptionPane.showMessageDialog(this, "Track length must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                tracks.add(new Track(trackTitle, length));
            }

            if (tracks.isEmpty()) {
                JOptionPane.showMessageDialog(this, "At least one track is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CompactDisc cd = new CompactDisc(title, category, cost, 0, director, artist, tracks);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            if (storeScreen != null) {
                storeScreen.refresh();
            }
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number in cost or track length.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfArtist.setText("");
        tfDirector.setText("");
        for (JTextField tf : trackTitleFields) tf.setText("");
        for (JTextField tf : trackLengthFields) tf.setText("");
    }
}
