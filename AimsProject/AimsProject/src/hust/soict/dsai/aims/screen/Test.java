package hust.soict.dsai.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class Test {
    public static void main(String[] args) {
        System.out.println("Testing JavaFX imports...");
        
        new JFXPanel();
        
        // These should compile without errors
        Platform.runLater(() -> {
            System.out.println("JavaFX Platform works!");
        });
        
        new JFXPanel();
        System.out.println("JFXPanel created successfully!");
    }
}
