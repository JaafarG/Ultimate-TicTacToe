package org.example.ultimatetictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onPlayGameButtonClick() {
        // Code to handle Play Game button click
    }

    @FXML
    protected void onRulesButtonClick() {
        // Call the showRules method from the Menu class when the Rules button is clicked
        menu.displayRules();
    }
}