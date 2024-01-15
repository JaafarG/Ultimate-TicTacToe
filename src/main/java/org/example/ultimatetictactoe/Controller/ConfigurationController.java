package org.example.ultimatetictactoe.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import network.Client;
import network.Server;
import org.example.ultimatetictactoe.Game;
import org.example.ultimatetictactoe.Player;
import org.example.ultimatetictactoe.Symbol;

import java.io.IOException;

public class ConfigurationController {

    private int symbolSkin ;
    private String IPAddress;
    private int connectionPort;

    @FXML private Text ip_address;
    @FXML private Text connection_port;
    @FXML private TextField ip_address_field;
    @FXML private TextField connection_port_field;

    @FXML
    protected void onCreateGameButtonClick(ActionEvent event) throws IOException {
        try {
            // Load the game-view FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/game-view.fxml"));
            Parent gameViewRoot = loader.load();

            // Create the GameController
            GameController gameController = loader.getController();

            // Create the server
            gameController.setServer(new Server(IPAddress, connectionPort, "Server", gameController));

            // Create a new Game instance
            gameController.setCurrentGame(new Game(new Player("Server", true), new Player("Client", false), symbolSkin));

            // Choose the player who will start the game
            gameController.getCurrentGame().chooseFirstPlayer();

            // Connection to the client
            gameController.getServer().start();
            gameController.getServer().startListeningForMessage();

            // If the server player is the player starting the game
            if (gameController.getCurrentGame().getPlayers()[0].isStarter()) {
                gameController.getCurrentGame().getPlayers()[0].setSymbol(Symbol.X);
                gameController.getCurrentGame().getPlayers()[1].setSymbol(Symbol.O);
                //Picks the image based on the chosen skin
                if(symbolSkin == 0 ){
                    gameController.setImagePlayer1(getClass().getResource("/X_icon.png"));
                    gameController.setImagePlayer2(getClass().getResource("/O_icon.png"));
                }
                if(symbolSkin == 1 ){
                    gameController.setImagePlayer1(getClass().getResource("/X_icon1.png"));
                    gameController.setImagePlayer2(getClass().getResource("/O_icon1.png"));
                }
                if(symbolSkin == 2 ){
                    gameController.setImagePlayer1(getClass().getResource("/X_icon2.png"));
                    gameController.setImagePlayer2(getClass().getResource("/O_icon2.png"));
                }
                if(symbolSkin == 3 ){
                    gameController.setImagePlayer1(getClass().getResource("/X_icon3.png"));
                    gameController.setImagePlayer2(getClass().getResource("/O_icon3.png"));
                }

                gameController.getServer().getConnection().sendMessage("O");
                gameController.updatePlayingText("You're playing X");
            // If the server player is the second player
            } else {
                gameController.getCurrentGame().getPlayers()[0].setSymbol(Symbol.O);
                gameController.getCurrentGame().getPlayers()[1].setSymbol(Symbol.X);
                //Picks the image based on the chosen skin
                if(symbolSkin == 0 ){
                    gameController.setImagePlayer1(getClass().getResource("/O_icon.png"));
                    gameController.setImagePlayer2(getClass().getResource("/X_icon.png"));
                }
                if(symbolSkin == 1 ){
                    gameController.setImagePlayer1(getClass().getResource("/O_icon1.png"));
                    gameController.setImagePlayer2(getClass().getResource("/X_icon1.png"));
                }
                if(symbolSkin == 2 ){
                    gameController.setImagePlayer1(getClass().getResource("/O_icon2.png"));
                    gameController.setImagePlayer2(getClass().getResource("/X_icon2.png"));
                }
                if(symbolSkin == 3 ){
                    gameController.setImagePlayer1(getClass().getResource("/O_icon3.png"));
                    gameController.setImagePlayer2(getClass().getResource("/X_icon3.png"));
                }
                gameController.getServer().getConnection().sendMessage("X");
                gameController.updatePlayingText("You're playing O");
            }

            // Get the current stage using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(gameViewRoot));
            stage.show();
        } catch (Exception e) {
            // Display an error window
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Unable to create a connection");
            alert.setContentText("Please check your internet connection !");
            alert.showAndWait();

            // Reload configuration view
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/configuration-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    protected void onJoinGameButtonClick(ActionEvent event) throws IOException {
        try {
            // Load the game-view FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/game-view.fxml"));
            Parent gameViewRoot = loader.load();

            // Create the GameController
            GameController gameController = loader.getController();

            // Create a new player
            gameController.setClient(new Client(ip_address_field.getText(), Integer.parseInt(connection_port_field.getText()), "Client", gameController, symbolSkin));

            // Create a new Game instance
            gameController.setCurrentGame(new Game(new Player("Server", false), new Player("Client", true), symbolSkin));

            // Connection to the server
            gameController.getClient().connectToServer();
            gameController.getClient().startListeningForMessage();

            // Get the current stage using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(gameViewRoot));
            stage.show();
        } catch (IOException e) {
            // Display an error window
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Unable to establish connection with server");
            alert.setContentText("Please check your internet connection !");
            alert.showAndWait();

            // Reload configuration view
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/configuration-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateIPAddressAndPort(String ip, int port) {
        ip_address.setText("Your IP address : " + ip);
        connection_port.setText("Your connection port : " + port);

        IPAddress = ip;
        connectionPort = port;
    }
    //Functions for the
    @FXML
    public void onSkin0buttonClicked() {
        symbolSkin = 0;

    }
    @FXML
    public void onSkin1buttonClicked() {
        symbolSkin = 1;
    }
    @FXML
    public void onSkin2buttonClicked() {
        symbolSkin = 2;
    }
    @FXML
    public void onSkin3buttonClicked() {
        symbolSkin = 3;
    }



}
