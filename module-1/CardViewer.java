// Stephanie Ramos
// October 26, 2025
// Module 1 Programming Assignment

// THe purpose of this program is to display four random playing cards from a standard deck of 52 cards.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardViewer extends Application {

    private static final int CARD_COUNT = 52;
    private static final String CARD_DIR = "cards/";   // folder containing 1.png ...

    private final ImageView[] slots = new ImageView[4];

    @Override
    public void start(Stage stage) {
        // Row of 4 image views
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER);

        for (int i = 0; i < 4; i++) {
            ImageView iv = new ImageView();
            iv.setFitWidth(120);
            iv.setPreserveRatio(true);
            slots[i] = iv;
            row.getChildren().add(iv);
        }

        // Refresh button with lambda expression
        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> showFourRandomCards());   

        VBox root = new VBox(16, row, refresh);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(16));

        stage.setTitle("Random Card Viewer");
        stage.setScene(new Scene(root, 600, 300));

        // Initial draw
        showFourRandomCards();

        stage.show();
    }

    private void showFourRandomCards() {
        List<Integer> ids = deckShuffled();
        for (int i = 0; i < 4; i++) {
            int id = ids.get(i);
            Image img = new Image("file:" + CARD_DIR + id + ".png");
            slots[i].setImage(img);
        }
    }

    private List<Integer> deckShuffled() {
        List<Integer> ids = new ArrayList<>(CARD_COUNT);
        for (int i = 1; i <= CARD_COUNT; i++) {
            ids.add(i);
        }
        Collections.shuffle(ids);
        return ids;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
