package org.example.ultimatetictactoe;

import network.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;


public class Controller implements Listener {
    private Game currentGame;

    private URL imagePlayerX, imagePlayerO;
    @FXML private Label turnLabel;
    @FXML private String playingLabel;
    @FXML private Text NotAllowedText;

    @FXML private GridPane gridpane00;
    @FXML private GridPane gridpane01;
    @FXML private GridPane gridpane02;
    @FXML private GridPane gridpane10;
    @FXML private GridPane gridpane11;
    @FXML private GridPane gridpane12;
    @FXML private GridPane gridpane20;
    @FXML private GridPane gridpane21;
    @FXML private GridPane gridpane22;

    @FXML private Button button0000;
    @FXML private Button button0001;
    @FXML private Button button0002;
    @FXML private Button button0010;
    @FXML private Button button0011;
    @FXML private Button button0012;
    @FXML private Button button0020;
    @FXML private Button button0021;
    @FXML private Button button0022;

    @FXML private Button button0100;
    @FXML private Button button0101;
    @FXML private Button button0102;
    @FXML private Button button0110;
    @FXML private Button button0111;
    @FXML private Button button0112;
    @FXML private Button button0120;
    @FXML private Button button0121;
    @FXML private Button button0122;

    @FXML private Button button0200;
    @FXML private Button button0201;
    @FXML private Button button0202;
    @FXML private Button button0210;
    @FXML private Button button0211;
    @FXML private Button button0212;
    @FXML private Button button0220;
    @FXML private Button button0221;
    @FXML private Button button0222;

    @FXML private Button button1000;
    @FXML private Button button1001;
    @FXML private Button button1002;
    @FXML private Button button1010;
    @FXML private Button button1011;
    @FXML private Button button1012;
    @FXML private Button button1020;
    @FXML private Button button1021;
    @FXML private Button button1022;

    @FXML private Button button1100;
    @FXML private Button button1101;
    @FXML private Button button1102;
    @FXML private Button button1110;
    @FXML private Button button1111;
    @FXML private Button button1112;
    @FXML private Button button1120;
    @FXML private Button button1121;
    @FXML private Button button1122;

    @FXML private Button button1200;
    @FXML private Button button1201;
    @FXML private Button button1202;
    @FXML private Button button1210;
    @FXML private Button button1211;
    @FXML private Button button1212;
    @FXML private Button button1220;
    @FXML private Button button1221;
    @FXML private Button button1222;

    @FXML private Button button2000;
    @FXML private Button button2001;
    @FXML private Button button2002;
    @FXML private Button button2010;
    @FXML private Button button2011;
    @FXML private Button button2012;
    @FXML private Button button2020;
    @FXML private Button button2021;
    @FXML private Button button2022;

    @FXML private Button button2100;
    @FXML private Button button2101;
    @FXML private Button button2102;
    @FXML private Button button2110;
    @FXML private Button button2111;
    @FXML private Button button2112;
    @FXML private Button button2120;
    @FXML private Button button2121;
    @FXML private Button button2122;

    @FXML private Button button2200;
    @FXML private Button button2201;
    @FXML private Button button2202;
    @FXML private Button button2210;
    @FXML private Button button2211;
    @FXML private Button button2212;
    @FXML private Button button2220;
    @FXML private Button button2221;
    @FXML private Button button2222;

    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    public Game getCurrentGame() {
        return this.currentGame;
    }

    public URL getImagePlayerX() {
        return imagePlayerX;
    }

    public void setImagePlayerX(URL imagePlayerX) {
        this.imagePlayerX = imagePlayerX;
    }

    public URL getImagePlayerO() {
        return imagePlayerO;
    }

    public void setImagePlayerO(URL imagePlayerO) {
        this.imagePlayerO = imagePlayerO;
    }

    public Label getTurnLabel() {
        return turnLabel;
    }

    public void setTurnLabel(Label turnLabel) {
        this.turnLabel = turnLabel;
    }

    public String getPlayingLabel() {
        return playingLabel;
    }

    public void setPlayingLabel(String playingLabel) {
        this.playingLabel = playingLabel;
    }

    public Text getNotAllowedText() {
        return NotAllowedText;
    }

    public void setNotAllowedText(Text notAllowedText) {
        NotAllowedText = notAllowedText;
    }

    @FXML
    protected void onRulesButtonClick() {
        // Create a new stage (which will create a new window)
        Stage rulesStage = new Stage();

        // Make the rules window modal, which means it must be closed before you can interact with other windows
        rulesStage.initModality(Modality.APPLICATION_MODAL);
        rulesStage.setTitle("Game Rules");

        // Create a label that contains the rules text
        Label rulesLabel = new Label("""
                Règles du morpion classique :
                Le joueur qui commence le jeu est choisi aléatoirement et il doit remplir la grille avec des croix “X”.
                L’autre joueur, quant à lui, remplira la grille à l’aide de ronds “O”.
                Le but pour chacun des joueurs est de créer une ligne de trois signes consécutifs (croix ou ronds).
                Cette ligne peut être verticale, horizontale ou diagonale.
                            
                Règles de l’ultimate morpion :         
                L’Ultimate Morpion est un jeu bien plus complexe que le morpion classique.
                Il oppose toujours deux joueurs mais le plateau est cette fois-ci une grille de neuf cases
                comportant chacune une grille de morpion.
                Le premier joueur commence dans n’importe quelle case de n’importe lequel des petits morpions.
                Il a donc le choix entre 81 cases. Ensuite, les joueurs doivent répondre dans le petit morpion
                correspondant aux coordonnées de la case précédemment jouée par l’adversaire.
                Par exemple, si le joueur 1 joue dans le petit morpion en bas à droite et pose une croix dans la case
                en haut à gauche de ce morpion alors le joueur 2 sera tenu de jouer dans le petit morpion en haut à gauche
                mais il est libre de placer un rond dans n’importe quelle case libre de ce morpion.
                Néanmoins, si un joueur se retrouve à devoir jouer dans un petit morpion dans lequel il est impossible de jouer
                (soit par manque de case libre, soit parce que celui-ci a été remporté par un joueur)
                alors ce joueur pourra jouer sur n’importe quelle case libre sur la grille.
                Pour gagner un petit morpion, ce sont les mêmes règles que celles du morpion traditionnel expliquées plus haut.
                Si un petit morpion n’a plus de cases libres alors il est considéré comme un match nul et ne donne aucun signe
                sur le grand morpion aux deux joueurs.
                La partie se termine si un joueur aligne trois victoires sur les petits morpions, il y a donc une victoire de ce joueur
                Sinon, s'il n'y a plus de cases vides pour jouer et qu'il n'y a pas de gagnant alors la partie est se termine en égalité.                
                """);
        rulesLabel.setWrapText(true);

        // Create a VBox layout and add the label and button to it
        VBox layout = new VBox(10);
        //layout.getChildren().addAll(rulesLabel, closeButton);
        layout.getChildren().addAll(rulesLabel);
        layout.setAlignment(Pos.CENTER);

        // Create a scene containing the layout, set the scene to the stage, and show the stage
        Scene scene = new Scene(layout, 800, 600);
        rulesStage.setScene(scene);
        rulesStage.showAndWait(); // Show and wait needs to be called for modal windows
    }

    @FXML
    protected void onPlayGameButtonClick(ActionEvent event) throws IOException {
        // Load the configuration-view FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("configuration-view.fxml"));
        Parent gameViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(gameViewRoot));
        stage.show();
    }

    @FXML
    protected void onCreateGameButtonClick(ActionEvent event) throws IOException {
        String IPAddress = "localhost";
        int port = 12345;
        String myName = "Server";
        String opponentsName = "Client";

        try {
            Server server = new Server(IPAddress, port, myName);
            server.start();
            server.startListeningForMessage();

            // Create a new Game instance
            Game currentGame = new Game(new Player(myName, true), new Player(opponentsName, false));
            currentGame.chooseFirstPlayer();

            // If the server player is the player starting the game
            if (currentGame.getPlayers()[0].isStarter()) {
                currentGame.getPlayers()[0].setSymbol(Symbol.X);
                currentGame.getPlayers()[1].setSymbol(Symbol.O);
                server.getConnection().sendMessage("O");
                playingLabel = "You're playing X";
            // If the server player is the second player
            } else {
                currentGame.getPlayers()[0].setSymbol(Symbol.O);
                currentGame.getPlayers()[1].setSymbol(Symbol.X);
                server.getConnection().sendMessage("X");
                playingLabel = "You're playing O";
            }

            // Load the game-view FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Parent gameViewRoot = loader.load();

            // Get the current stage using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(gameViewRoot));
            stage.show();

            turnLabel.setText("It's Xs TURN");
            imagePlayerX = getClass().getResource("/X_icon.png");
            imagePlayerO = getClass().getResource("/O_icon.png");
        } catch (Exception e) {
            Stage serverError = new Stage();
            serverError.initModality(Modality.APPLICATION_MODAL);
            serverError.setTitle("Problem with your connection");
            Label rulesLabel = new Label(e.getMessage());
            rulesLabel.setWrapText(true);
            VBox layout = new VBox(10);
            layout.getChildren().addAll(rulesLabel);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 800, 600);
            serverError.setScene(scene);
            serverError.showAndWait();
        }
    }

    @FXML
    protected void onJoinGameButtonClick(ActionEvent event) throws IOException {
        String IPAddress = "localhost";
        int port = 12345;
        String myName = "Client";
        String opponentsName = "Server";

        try {
            Client client = new Client(IPAddress, port, myName);
            client.connectToServer();
            client.startListeningForMessage();

            // Create a new Game instance
            Game currentGame = new Game(new Player(opponentsName, true), new Player(myName, false));

            // Load the game-view FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Parent gameViewRoot = loader.load();

            Controller gameViewController = loader.getController();
            gameViewController.setCurrentGame(currentGame);

            // Get the current stage using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(gameViewRoot));
            stage.show();

            turnLabel.setText("It's Xs TURN");
        } catch (Exception e) {
            Stage serverError = new Stage();
            serverError.initModality(Modality.APPLICATION_MODAL);
            serverError.setTitle("Problem with the connection with the server");
            Label rulesLabel = new Label(e.getMessage());
            rulesLabel.setWrapText(true);
            VBox layout = new VBox(10);
            layout.getChildren().addAll(rulesLabel);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout, 800, 600);
            serverError.setScene(scene);
            serverError.showAndWait();
        }
    }

    @FXML
    protected void onForfeitButtonClick(ActionEvent event) throws IOException {
        // Load the game-view FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
        Parent gameViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(gameViewRoot));
        stage.show();
    }

    public void handleButtonClicked(int a, int b , int c , int d , Button button, GridPane gridpane) {
        // if the move is valid
        if (currentGame.getBoard() != null && currentGame.getBoard().validateMove(a,b,c,d)) {
            // Change the labels
            changeText();

            // Change the image on the button
            if (currentGame.getCurrentPlayer().isStarter()) {
                ChangeImage(button, imagePlayerX);
            } else {
                ChangeImage(button, imagePlayerO);
            }

            // Send the move to the other player

            // Plays the move
            currentGame.playMove(a,b,c,d);

            // Not Allowed text becomes invisible
            NotAllowedText.setOpacity(0.0);

            // If the player won the small grid with them move
            if (currentGame.getBoard().getGrid()[a][b].isWin()) {
                // The grid becomes invisible and it is replaced with the player's symbol
                gridpane.setOpacity(0.0);
                // Add an image on top of won grid
            }
        // if the move is not valid
        }else{
            // The Not Allowed text appears
            NotAllowedText.setOpacity(1.0);
        }
        System.out.println("Current Player will be : " + currentGame.getCurrentPlayer().getName());
    }

    @FXML
    public void onButtonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton == button0000) {
            handleButtonClicked(0, 0, 0, 0, button0000, gridpane00);
        } else if (clickedButton == button0001) {
            handleButtonClicked(0, 0, 0, 1, button0001, gridpane00);
        } else if (clickedButton == button0002) {
            handleButtonClicked(0, 0, 0, 2, button0002, gridpane00);
        } else if (clickedButton == button0010) {
            handleButtonClicked(0, 0, 1, 0, button0010, gridpane00);
        } else if (clickedButton == button0011) {
            handleButtonClicked(0, 0, 1, 1, button0011, gridpane00);
        } else if (clickedButton == button0012) {
            handleButtonClicked(0, 0, 1, 2, button0012, gridpane00);
        } else if (clickedButton == button0020) {
            handleButtonClicked(0, 0, 2, 0, button0020, gridpane00);
        } else if (clickedButton == button0021) {
            handleButtonClicked(0, 0, 2, 1, button0021, gridpane00);
        } else if (clickedButton == button0022) {
            handleButtonClicked(0, 0, 2, 2, button0022, gridpane00);
        } else if (clickedButton == button0100) {
            handleButtonClicked(0, 1, 0, 0, button0100, gridpane01);
        } else if (clickedButton == button0101) {
            handleButtonClicked(0, 1, 0, 1, button0101, gridpane01);
        } else if (clickedButton == button0102) {
            handleButtonClicked(0, 1, 0, 2, button0102, gridpane01);
        } else if (clickedButton == button0110) {
            handleButtonClicked(0, 1, 1, 0, button0110, gridpane01);
        } else if (clickedButton == button0111) {
            handleButtonClicked(0, 1, 1, 1, button0111, gridpane01);
        } else if (clickedButton == button0112) {
            handleButtonClicked(0, 1, 1, 2, button0112, gridpane01);
        } else if (clickedButton == button0120) {
            handleButtonClicked(0, 1, 2, 0, button0120, gridpane01);
        } else if (clickedButton == button0121) {
            handleButtonClicked(0, 1, 2, 1, button0121, gridpane01);
        } else if (clickedButton == button0122) {
            handleButtonClicked(0, 1, 2, 2, button0122, gridpane01);
        } else if (clickedButton == button0200) {
            handleButtonClicked(0, 2, 0, 0, button0200, gridpane01);
        } else if (clickedButton == button0201) {
            handleButtonClicked(0, 2, 0, 1, button0201, gridpane01);
        } else if (clickedButton == button0202) {
            handleButtonClicked(0, 2, 0, 2, button0202, gridpane02);
        } else if (clickedButton == button0210) {
            handleButtonClicked(0, 2, 1, 0, button0210, gridpane02);
        } else if (clickedButton == button0211) {
            handleButtonClicked(0, 2, 1, 1, button0211, gridpane02);
        } else if (clickedButton == button0212) {
            handleButtonClicked(0, 2, 1, 2, button0212, gridpane02);
        } else if (clickedButton == button0220) {
            handleButtonClicked(0, 2, 2, 0, button0220, gridpane02);
        } else if (clickedButton == button0221) {
            handleButtonClicked(0, 2, 2, 1, button0221, gridpane02);
        } else if (clickedButton == button0222) {
            handleButtonClicked(0, 2, 2, 2, button0222, gridpane02);
        } else if (clickedButton == button1000) {
            handleButtonClicked(1, 0, 0, 0, button1000, gridpane10);
        } else if (clickedButton == button1001) {
            handleButtonClicked(1, 0, 0, 1, button1001, gridpane10);
        } else if (clickedButton == button1002) {
            handleButtonClicked(1, 0, 0, 2, button1002, gridpane10);
        } else if (clickedButton == button1010) {
            handleButtonClicked(1, 0, 1, 0, button1010, gridpane10);
        } else if (clickedButton == button1011) {
            handleButtonClicked(1, 0, 1, 1, button1011, gridpane10);
        } else if (clickedButton == button1012) {
            handleButtonClicked(1, 0, 1, 2, button1012, gridpane10);
        } else if (clickedButton == button1020) {
            handleButtonClicked(1, 0, 2, 0, button1020, gridpane10);
        } else if (clickedButton == button1021) {
            handleButtonClicked(1, 0, 2, 1, button1021, gridpane10);
        } else if (clickedButton == button1022) {
            handleButtonClicked(1, 0, 2, 2, button1022, gridpane10);
        } else if (clickedButton == button1100) {
            handleButtonClicked(1, 1, 0, 0, button1100, gridpane11);
        } else if (clickedButton == button1101) {
            handleButtonClicked(1, 1, 0, 1, button1101, gridpane11);
        } else if (clickedButton == button1102) {
            handleButtonClicked(1, 1, 0, 2, button1102, gridpane11);
        } else if (clickedButton == button1110) {
            handleButtonClicked(1, 1, 1, 0, button1110, gridpane11);
        } else if (clickedButton == button1111) {
            handleButtonClicked(1, 1, 1, 1, button1111, gridpane11);
        } else if (clickedButton == button1112) {
            handleButtonClicked(1, 1, 1, 2, button1112, gridpane11);
        } else if (clickedButton == button1120) {
            handleButtonClicked(1, 1, 2, 0, button1120, gridpane11);
        } else if (clickedButton == button1121) {
            handleButtonClicked(1, 1, 2, 1, button1121, gridpane11);
        } else if (clickedButton == button1122) {
            handleButtonClicked(1, 1, 2, 2, button1122, gridpane11);
        } else if (clickedButton == button1200) {
            handleButtonClicked(1, 2, 0, 0, button1200, gridpane12);
        } else if (clickedButton == button1201) {
            handleButtonClicked(1, 2, 0, 1, button1201, gridpane12);
        } else if (clickedButton == button1202) {
            handleButtonClicked(1, 2, 0, 2, button1202, gridpane12);
        } else if (clickedButton == button1210) {
            handleButtonClicked(1, 2, 1, 0, button1210, gridpane12);
        } else if (clickedButton == button1211) {
            handleButtonClicked(1, 2, 1, 1, button1211, gridpane12);
        } else if (clickedButton == button1212) {
            handleButtonClicked(1, 2, 1, 2, button1212, gridpane12);
        } else if (clickedButton == button1220) {
            handleButtonClicked(1, 2, 2, 0, button1220, gridpane12);
        } else if (clickedButton == button1221) {
            handleButtonClicked(1, 2, 2, 1, button1221, gridpane12);
        } else if (clickedButton == button1222) {
            handleButtonClicked(1, 2, 2, 2, button1222, gridpane12);
        } else if (clickedButton == button2000) {
            handleButtonClicked(2, 0, 0, 0, button2000, gridpane20);
        } else if (clickedButton == button2001) {
            handleButtonClicked(2, 0, 0, 1, button2001, gridpane20);
        } else if (clickedButton == button2002) {
            handleButtonClicked(2, 0, 0, 2, button2002, gridpane20);
        } else if (clickedButton == button2010) {
            handleButtonClicked(2, 0, 1, 0, button2010, gridpane20);
        } else if (clickedButton == button2011) {
            handleButtonClicked(2, 0, 1, 1, button2011, gridpane20);
        } else if (clickedButton == button2012) {
            handleButtonClicked(2, 0, 1, 2, button2012, gridpane20);
        } else if (clickedButton == button2020) {
            handleButtonClicked(2, 0, 2, 0, button2020, gridpane20);
        } else if (clickedButton == button2021) {
            handleButtonClicked(2, 0, 2, 1, button2021, gridpane20);
        } else if (clickedButton == button2022) {
            handleButtonClicked(2, 0, 2, 2, button2022, gridpane20);
        } else if (clickedButton == button2100) {
            handleButtonClicked(2, 1, 0, 0, button2100, gridpane21);
        } else if (clickedButton == button2101) {
            handleButtonClicked(2, 1, 0, 1, button2101, gridpane21);
        } else if (clickedButton == button2102) {
            handleButtonClicked(2, 1, 0, 2, button2102, gridpane21);
        } else if (clickedButton == button2110) {
            handleButtonClicked(2, 1, 1, 0, button2110, gridpane21);
        } else if (clickedButton == button2111) {
            handleButtonClicked(2, 1, 1, 1, button2111, gridpane21);
        } else if (clickedButton == button2112) {
            handleButtonClicked(2, 1, 1, 2, button2112, gridpane21);
        } else if (clickedButton == button2120) {
            handleButtonClicked(2, 1, 2, 0, button2120, gridpane21);
        } else if (clickedButton == button2121) {
            handleButtonClicked(2, 1, 2, 1, button2121, gridpane21);
        } else if (clickedButton == button2122) {
            handleButtonClicked(2, 1, 2, 2, button2122, gridpane21);
        } else if (clickedButton == button2200) {
            handleButtonClicked(2, 2, 0, 0, button2200, gridpane22);
        } else if (clickedButton == button2201) {
            handleButtonClicked(2, 2, 0, 1, button2201, gridpane22);
        } else if (clickedButton == button2202) {
            handleButtonClicked(2, 2, 0, 2, button2202, gridpane22);
        } else if (clickedButton == button2210) {
            handleButtonClicked(2, 2, 1, 0, button2210, gridpane22);
        } else if (clickedButton == button2211) {
            handleButtonClicked(2, 2, 1, 1, button2211, gridpane22);
        } else if (clickedButton == button2212) {
            handleButtonClicked(2, 2, 1, 2, button2212, gridpane22);
        } else if (clickedButton == button2220) {
            handleButtonClicked(2, 2, 2, 0, button2220, gridpane22);
        } else if (clickedButton == button2221) {
            handleButtonClicked(2, 2, 2, 1, button2221, gridpane22);
        } else if (clickedButton == button2222) {
            handleButtonClicked(2, 2, 2, 2, button2222, gridpane22);
        }
    }

    @Override
    public void onMessageReceived(String message) {}

    @FXML
    public void changeText() {
        // Change the turn label text and color
        if (turnLabel.getText().equals("It's Xs TURN")) {
            turnLabel.setText("It's Os TURN");
            turnLabel.setTextFill(Color.BLUE);
        } else {
            turnLabel.setText("It's Xs TURN");
            turnLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    public void ChangeImage(Button button, URL imageUrl) {

        Image image = new Image(imageUrl.toString());
        ImageView imageView = new ImageView(image);

        // Set the properties of the ImageView
        imageView.setFitHeight(20); // Set the height of the image
        imageView.setFitWidth(15);  // Set the width of the image

        // Set the ImageView as the graphic of the button
        button.setGraphic(imageView);
    }
}