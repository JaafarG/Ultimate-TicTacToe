package org.example.ultimatetictactoe.Controller;

import BDD.UtilBDD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LogController {
    @FXML private Button create_account;
    @FXML private Button log_in;
    @FXML private TextField signin_username_textfield;
    @FXML private PasswordField signin_password_textfield;
    @FXML private PasswordField signin_password_confirmation_textfield;
    @FXML private TextField login_username_textfield;
    @FXML private PasswordField login_password_textfield;

    @FXML
    protected void onCreateAccountButtonClick() {
        String username = signin_username_textfield.getText();
        String password = String.valueOf(signin_password_textfield.getText().hashCode());
        String password_confirmation = String.valueOf(signin_password_confirmation_textfield.getText().hashCode());

        // Check that the username does not already exist
        if (UtilBDD.playerExist(username)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("User already exists. Please choose a different username.");
            alert.showAndWait();

            signin_username_textfield.setText("");
            signin_password_textfield.setText("");
            signin_password_confirmation_textfield.setText("");

            return;
        }

        // Check that the password confirmation matches the password
        if (!password.equals(password_confirmation)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The password confirmation does not match the initial password. Please choose a different username.");
            alert.showAndWait();

            signin_username_textfield.setText("");
            signin_password_textfield.setText("");
            signin_password_confirmation_textfield.setText("");

            return;
        }

        if (UtilBDD.insertPlayer(username, password)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Account Information");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been successfully created !");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Account Information");
            alert.setHeaderText(null);
            alert.setContentText("We did not achieve to create your account ! Please, try later !");
            alert.showAndWait();
        }

        signin_username_textfield.setText("");
        signin_password_textfield.setText("");
        signin_password_confirmation_textfield.setText("");
    }

    @FXML
    protected void onLogInButtonClick(ActionEvent event) {
        String username = login_username_textfield.getText();
        String password = String.valueOf(login_password_textfield.getText().hashCode());

        if (UtilBDD.verifyPassword(username, password)) {
            try {
                // Load the configuration-view FXML file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                Parent gameViewRoot = loader.load();

                // Create the configurationController
                MenuController menuController = loader.getController();

                // Get the current stage using the event source
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(new Scene(gameViewRoot));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect username or password.");
            alert.showAndWait();
        }
    }
}
