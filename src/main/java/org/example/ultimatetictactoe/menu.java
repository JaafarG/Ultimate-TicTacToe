package org.example.ultimatetictactoe;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class menu {

    // Method to show the rules
    public static void displayRules() {
        // Create a new stage (which will create a new window)
        Stage rulesStage = new Stage();

        // Make the rules window modal, which means it must be closed before you can interact with other windows
        rulesStage.initModality(Modality.APPLICATION_MODAL);
        rulesStage.setTitle("Game Rules");

        // Create a label that contains the rules text
        Label rulesLabel = new Label("This is a test for the rules");
        rulesLabel.setWrapText(true);

        // Create a 'Close' button to close the rules window
        Button closeButton = new Button("X");
        closeButton.setOnAction(e -> rulesStage.close());

        // Create a VBox layout and add the label and button to it
        VBox layout = new VBox(10);
        layout.getChildren().addAll(rulesLabel, closeButton);
        layout.setAlignment(Pos.CENTER);

        // Create a scene containing the layout, set the scene to the stage, and show the stage
        Scene scene = new Scene(layout, 300, 250);
        rulesStage.setScene(scene);
        rulesStage.showAndWait(); // Show and wait needs to be called for modal windows
    }
}