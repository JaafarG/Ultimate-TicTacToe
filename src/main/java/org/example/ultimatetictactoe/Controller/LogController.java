package org.example.ultimatetictactoe.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LogController {
    @FXML
    private TextField signInUsernameField;
    @FXML private PasswordField signInPasswordField;
    @FXML private TextField logInUsernameField;
    @FXML private PasswordField logInPasswordField;
    @FXML private Text passwordNotIdenticalText;

    @FXML
    protected void onCreateAccountButtonClick() {
        String username = signInUsernameField.getText();
        String password = signInPasswordField.getText();

        // Vérifier que le nom d'utilisateur n'existe pas déjà et que la confirmation du mot de passe correspond
        // Check that the username does not already exist
        if (userExists(username)) {
            showAlert("User already exists", "Please choose a different username.", Alert.AlertType.ERROR);
            return;
        }

        if (!passwordsMatch()) {
            // Afficher un message d'erreur si les mots de passe ne correspondent pas
            passwordNotIdenticalText.setOpacity(1.0); // Rendre le texte d'erreur visible
            return;
        }

        createUser(username, password);
    }

    @FXML
    protected void onLogInButtonClick() {
        String username = logInUsernameField.getText();
        String password = logInPasswordField.getText();

        if (authenticate(username, password)) {
            // L'utilisateur est authentifié, vous pouvez maintenant changer de scène ou mettre à jour l'interface utilisateur
        } else {
            // Afficher un message d'erreur
            showAlert("Login Failed", "Incorrect username or password.", Alert.AlertType.ERROR);
        }
    }

    private boolean userExists(String username) {
        // Implémentez la logique pour vérifier si un utilisateur existe déjà dans la base de données
        return true;
    }

    private boolean passwordsMatch() {
        // Implémentez la logique pour vérifier si les mots de passe correspondent
        return true;
    }

    private void createUser(String username, String password) {
        // Implémentez la logique pour créer un nouvel utilisateur dans la base de données
    }

    private boolean authenticate(String username, String password) {
        // Implémentez la logique pour authentifier un utilisateur
        return true;
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
