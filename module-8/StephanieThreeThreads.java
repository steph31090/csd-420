/*
 * Stephanie Ramos
 * Module 8 Programming Assignment
 * November 30, 2025
 *
 * Purpose: This program uses three threads to generate and display random letters, digits,
 * and symbols in a JavaFX TextArea, with each thread outputting at least 10,000 characters.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StephanieThreeThreads extends Application {

    private static final int COUNT = 10000;

    @Override
    public void start(Stage primaryStage) {

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        // Thread 1: random letters
        Thread lettersThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char letter = (char) ('a' + (int)(Math.random() * 26));
                addToTextArea(textArea, String.valueOf(letter));
            }
        });

        // Thread 2: random digits
        Thread digitsThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                int digit = (int)(Math.random() * 10);
                addToTextArea(textArea, String.valueOf(digit));
            }
        });

        // Thread 3: random symbols
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Thread symbolsThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                int index = (int)(Math.random() * symbols.length);
                addToTextArea(textArea, String.valueOf(symbols[index]));
            }
        });

        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addToTextArea(TextArea area, String text) {
        javafx.application.Platform.runLater(() -> area.appendText(text));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
