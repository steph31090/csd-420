/*
 * Stephanie Ramos
 * Module 7 Programming Assignment
 * Purpose: Display four circles using CSS file.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Circle using class plaincircle
        Circle c1 = new Circle(50);
        c1.getStyleClass().add("plaincircle");

        // Second circle
        Circle c2 = new Circle(50);
        c2.getStyleClass().add("plaincircle");

        // Red Circle
        Circle c3 = new Circle(50);
        c3.setId("redcircle");

        // Green Circle
        Circle c4 = new Circle(50);
        c4.setId("greencircle");

        HBox pane = new HBox(20);
        pane.getChildren().addAll(c1, c2, c3, c4);

        Scene scene = new Scene(pane, 400, 150);

        // Load CSS file
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Module 7 Programming Assignment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
