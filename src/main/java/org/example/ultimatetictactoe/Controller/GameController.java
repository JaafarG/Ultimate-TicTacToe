package org.example.ultimatetictactoe.Controller;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import network.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.example.ultimatetictactoe.Game;
import org.example.ultimatetictactoe.Symbol;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class GameController {
    private Game currentGame;
    private Server server;
    private Client client;
    private URL imagePlayer1;
    private URL imagePlayer2;

    @FXML private Text turnText;
    @FXML private Text playingText;
    @FXML private Text adviceText;

    private Button[][][][] buttons = new Button[3][3][3][3];
    private GridPane[][] gridPanes = new GridPane[3][3];
    private ImageView[][] images = new ImageView[3][3];

    @FXML private GridPane gridPane00;
    @FXML private GridPane gridPane01;
    @FXML private GridPane gridPane02;
    @FXML private GridPane gridPane10;
    @FXML private GridPane gridPane11;
    @FXML private GridPane gridPane12;
    @FXML private GridPane gridPane20;
    @FXML private GridPane gridPane21;
    @FXML private GridPane gridPane22;

    @FXML private ImageView image00;
    @FXML private ImageView image01;
    @FXML private ImageView image02;
    @FXML private ImageView image10;
    @FXML private ImageView image11;
    @FXML private ImageView image12;
    @FXML private ImageView image20;
    @FXML private ImageView image21;
    @FXML private ImageView image22;


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

    public Text getAdviceText() { return adviceText; }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) { this.currentGame = currentGame; }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public URL getImagePlayer1() {
        return imagePlayer1;
    }

    public void setImagePlayer1(URL imagePlayer1) {
        this.imagePlayer1 = imagePlayer1;
    }

    public URL getImagePlayer2() {
        return imagePlayer2;
    }

    public void setImagePlayer2(URL imagePlayer2) {
        this.imagePlayer2 = imagePlayer2;
    }

    @FXML
    private void initialize() {
        // First BigGrid (0,0)
        buttons[0][0][0][0] = button0000;
        buttons[0][0][0][1] = button0001;
        buttons[0][0][0][2] = button0002;
        buttons[0][0][1][0] = button0010;
        buttons[0][0][1][1] = button0011;
        buttons[0][0][1][2] = button0012;
        buttons[0][0][2][0] = button0020;
        buttons[0][0][2][1] = button0021;
        buttons[0][0][2][2] = button0022;

        // Second BigGrid (0,1)
        buttons[0][1][0][0] = button0100;
        buttons[0][1][0][1] = button0101;
        buttons[0][1][0][2] = button0102;
        buttons[0][1][1][0] = button0110;
        buttons[0][1][1][1] = button0111;
        buttons[0][1][1][2] = button0112;
        buttons[0][1][2][0] = button0120;
        buttons[0][1][2][1] = button0121;
        buttons[0][1][2][2] = button0122;

        // Third BigGrid (0,2)
        buttons[0][2][0][0] = button0200;
        buttons[0][2][0][1] = button0201;
        buttons[0][2][0][2] = button0202;
        buttons[0][2][1][0] = button0210;
        buttons[0][2][1][1] = button0211;
        buttons[0][2][1][2] = button0212;
        buttons[0][2][2][0] = button0220;
        buttons[0][2][2][1] = button0221;
        buttons[0][2][2][2] = button0222;

        // Fourth BigGrid (1,0)
        buttons[1][0][0][0] = button1000;
        buttons[1][0][0][1] = button1001;
        buttons[1][0][0][2] = button1002;
        buttons[1][0][1][0] = button1010;
        buttons[1][0][1][1] = button1011;
        buttons[1][0][1][2] = button1012;
        buttons[1][0][2][0] = button1020;
        buttons[1][0][2][1] = button1021;
        buttons[1][0][2][2] = button1022;

        // Fifth BigGrid (1,1)
        buttons[1][1][0][0] = button1100;
        buttons[1][1][0][1] = button1101;
        buttons[1][1][0][2] = button1102;
        buttons[1][1][1][0] = button1110;
        buttons[1][1][1][1] = button1111;
        buttons[1][1][1][2] = button1112;
        buttons[1][1][2][0] = button1120;
        buttons[1][1][2][1] = button1121;
        buttons[1][1][2][2] = button1122;

        // Sixth BigGrid (1,2)
        buttons[1][2][0][0] = button1200;
        buttons[1][2][0][1] = button1201;
        buttons[1][2][0][2] = button1202;
        buttons[1][2][1][0] = button1210;
        buttons[1][2][1][1] = button1211;
        buttons[1][2][1][2] = button1212;
        buttons[1][2][2][0] = button1220;
        buttons[1][2][2][1] = button1221;
        buttons[1][2][2][2] = button1222;

        // Seventh BigGrid (2,0)
        buttons[2][0][0][0] = button2000;
        buttons[2][0][0][1] = button2001;
        buttons[2][0][0][2] = button2002;
        buttons[2][0][1][0] = button2010;
        buttons[2][0][1][1] = button2011;
        buttons[2][0][1][2] = button2012;
        buttons[2][0][2][0] = button2020;
        buttons[2][0][2][1] = button2021;
        buttons[2][0][2][2] = button2022;

        // Eighth BigGrid (2,1)
        buttons[2][1][0][0] = button2100;
        buttons[2][1][0][1] = button2101;
        buttons[2][1][0][2] = button2102;
        buttons[2][1][1][0] = button2110;
        buttons[2][1][1][1] = button2111;
        buttons[2][1][1][2] = button2112;
        buttons[2][1][2][0] = button2120;
        buttons[2][1][2][1] = button2121;
        buttons[2][1][2][2] = button2122;

        // Ninth BigGrid (2,2)
        buttons[2][2][0][0] = button2200;
        buttons[2][2][0][1] = button2201;
        buttons[2][2][0][2] = button2202;
        buttons[2][2][1][0] = button2210;
        buttons[2][2][1][1] = button2211;
        buttons[2][2][1][2] = button2212;
        buttons[2][2][2][0] = button2220;
        buttons[2][2][2][1] = button2221;
        buttons[2][2][2][2] = button2222;

        //GridPanes
        gridPanes[0][0] = gridPane00;
        gridPanes[0][1] = gridPane01;
        gridPanes[0][2] = gridPane02;
        gridPanes[1][0] = gridPane10;
        gridPanes[1][1] = gridPane11;
        gridPanes[1][2] = gridPane12;
        gridPanes[2][0] = gridPane20;
        gridPanes[2][1] = gridPane21;
        gridPanes[2][2] = gridPane22;

        //Images
        images[0][0] = image00;
        images[0][1] = image01;
        images[0][2] = image02;
        images[1][0] = image10;
        images[1][1] = image11;
        images[1][2] = image12;
        images[2][0] = image20;
        images[2][1] = image21;
        images[2][2] = image22;
    }

    @FXML
    protected void onForfeitButtonClick(ActionEvent event) throws IOException {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Forfeit Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to forfeit this game ? It will be considered a loss for you.");
        confirmationAlert.setContentText("Click on OK to forfeit.");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Send a message to the other player and give it the infamous award of the sacred boolean
            // If the player is the server
            if (currentGame.getPlayers()[0].isMe()) {
                server.getConnection().sendMessage("KO");
                currentGame.getPlayers()[1].setWinner(true);

                // Close the server
                server.stop();
            }
            // If the player is the client
            if (currentGame.getPlayers()[1].isMe()) {
                client.getConnection().sendMessage("KO");
                currentGame.getPlayers()[0].setWinner(true);

                // Close the client
                client.close();
            }

            // Set the game state to finished
            currentGame.setGameState(true);

            // Load the menu view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));

            // Get the current stage using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(loader.load()));
            stage.show();
        }
    }

    public void handleButtonClicked(int bigGridX, int bigGridY, int smallGridX, int smallGridY, Button button, GridPane gridPane, ImageView image) {
        // If it is your turn
        if (currentGame.getCurrentPlayer().isMe()) {
            // if the move is valid
            if (currentGame.getBoard() != null && currentGame.getBoard().validateMove(bigGridX,bigGridY,smallGridX,smallGridY)) {
                // Change the labels
                changeText();

                // Change the image on the button
                changeImage(bigGridX, bigGridY, smallGridX, smallGridY, (currentGame.getPlayers()[0] == currentGame.getCurrentPlayer()));

                // Send the move to the other player
                // If the current player is the server
                if (currentGame.getCurrentPlayer() == currentGame.getPlayers()[0]) {
                    //server.getConnection().sendMessage(coordinatesToMessage(bigGridX,bigGridY,smallGridX,smallGridY));
                    server.getConnection().sendMessage(String.valueOf(bigGridX) + String.valueOf(bigGridY) + String.valueOf(smallGridX) + String.valueOf(smallGridY));
                    // If the current player is the client
                } else {
                    client.getConnection().sendMessage(String.valueOf(bigGridX) + String.valueOf(bigGridY) + String.valueOf(smallGridX) + String.valueOf(smallGridY));
                }

                // Plays the move
                currentGame.playMove(bigGridX,bigGridY,smallGridX,smallGridY);

                // If the player wins the game
                if (currentGame.checkGameWin(currentGame.getCurrentPlayer())){
                    onWin();
                }

                // If the game is a tie
                boolean tie = true;
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        tie &= (currentGame.getBoard().getGrid()[i][j].isFull() || currentGame.getBoard().getGrid()[i][j].isWin());
                    }
                }
                if (tie) {
                    onTie();
                }

                // Not Allowed text becomes invisible
                adviceText.setOpacity(0.0);

                // If the player won the small grid with their move
                changeGridImage(bigGridX,bigGridY);

            // If the move is not valid
            }else{
                // The Not Allowed text appears
                adviceText.setText("Move not allowed !");
                adviceText.setOpacity(1.0);
            }
        // If it is not your turn
        } else {
            adviceText.setText("It is not your turn !");
            adviceText.setOpacity(1.0);
        }
    }

    public void changeGridImage(int bigGridX, int bigGridY) {
        if (currentGame.getBoard().getGrid()[bigGridX][bigGridY].isWin()) {
            // The grid becomes invisible and it is replaced with the player's symbol
            findGridPaneByCoordinates(bigGridX, bigGridY).setOpacity(0.0);
            // Add an image on top of won grid
            String winningImageUrl = null;
            if (currentGame.getSymbolSkin() == 0) {
                if (currentGame.getCurrentPlayer().symbol == Symbol.O) {
                    winningImageUrl = "X_icon.png";
                } else {
                    winningImageUrl = "O_icon.png";
                }
            }
            if (currentGame.getSymbolSkin() == 1) {
                if (currentGame.getCurrentPlayer().symbol == Symbol.O) {
                    winningImageUrl = "X_icon1.png";
                } else {
                    winningImageUrl = "O_icon1.png";
                }
            }
            if (currentGame.getSymbolSkin() == 2) {
                if (currentGame.getCurrentPlayer().symbol == Symbol.O) {
                    winningImageUrl = "X_icon2.png";
                } else {
                    winningImageUrl = "O_icon2.png";
                }
            }
            if (currentGame.getSymbolSkin() == 3) {
                if (currentGame.getCurrentPlayer().symbol == Symbol.O) {
                    winningImageUrl = "X_icon3.png";
                } else {
                    winningImageUrl = "O_icon3.png";
                }
            }
            findImageByCoordinates(bigGridX, bigGridY).setImage(new Image(winningImageUrl));
        }
    }

    private void onWin() {
        currentGame.setGameState(true);

        if (currentGame.getPlayers()[0].isMe()) {
            currentGame.getPlayers()[0].setWinner(true);
        } else {
            currentGame.getPlayers()[1].setWinner(true);
        }

        // If the player is the server
        if (currentGame.getPlayers()[0].isMe()) { // Server wins
            server.getConnection().sendMessage("OK");
            // If the player is the client
        } else {
            client.getConnection().sendMessage("OK");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Congratulations, " + currentGame.getCurrentPlayer().getUsername() + "! You have won the game!");

        alert.showAndWait();

        // If the user closes with the cross button
        alert.setOnCloseRequest(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) this.getAdviceText().getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) this.getAdviceText().getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void onTie() {
        // If the player is the server
        if (currentGame.getPlayers()[0].isMe()) {
            server.getConnection().sendMessage("XO");
            // If the player is the client
        } else {
            client.getConnection().sendMessage("XO");
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Unfortunately, this game ended on a tie !");

        alert.showAndWait();

        // If the user closes with the cross button
        alert.setOnCloseRequest(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) this.getAdviceText().getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) this.getAdviceText().getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onButtonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton == button0000) {
            handleButtonClicked(0, 0, 0, 0, button0000, gridPane00, image00);
        } else if (clickedButton == button0001) {
            handleButtonClicked(0, 0, 0, 1, button0001, gridPane00, image00);
        } else if (clickedButton == button0002) {
            handleButtonClicked(0, 0, 0, 2, button0002, gridPane00, image00);
        } else if (clickedButton == button0010) {
            handleButtonClicked(0, 0, 1, 0, button0010, gridPane00, image00);
        } else if (clickedButton == button0011) {
            handleButtonClicked(0, 0, 1, 1, button0011, gridPane00, image00);
        } else if (clickedButton == button0012) {
            handleButtonClicked(0, 0, 1, 2, button0012, gridPane00, image00);
        } else if (clickedButton == button0020) {
            handleButtonClicked(0, 0, 2, 0, button0020, gridPane00, image00);
        } else if (clickedButton == button0021) {
            handleButtonClicked(0, 0, 2, 1, button0021, gridPane00, image00);
        } else if (clickedButton == button0022) {
            handleButtonClicked(0, 0, 2, 2, button0022, gridPane00, image00);
        } else if (clickedButton == button0100) {
            handleButtonClicked(0, 1, 0, 0, button0100, gridPane01, image01);
        } else if (clickedButton == button0101) {
            handleButtonClicked(0, 1, 0, 1, button0101, gridPane01, image01);
        } else if (clickedButton == button0102) {
            handleButtonClicked(0, 1, 0, 2, button0102, gridPane01, image01);
        } else if (clickedButton == button0110) {
            handleButtonClicked(0, 1, 1, 0, button0110, gridPane01, image01);
        } else if (clickedButton == button0111) {
            handleButtonClicked(0, 1, 1, 1, button0111, gridPane01, image01);
        } else if (clickedButton == button0112) {
            handleButtonClicked(0, 1, 1, 2, button0112, gridPane01, image01);
        } else if (clickedButton == button0120) {
            handleButtonClicked(0, 1, 2, 0, button0120, gridPane01, image01);
        } else if (clickedButton == button0121) {
            handleButtonClicked(0, 1, 2, 1, button0121, gridPane01, image01);
        } else if (clickedButton == button0122) {
            handleButtonClicked(0, 1, 2, 2, button0122, gridPane01, image01);
        } else if (clickedButton == button0200) {
            handleButtonClicked(0, 2, 0, 0, button0200, gridPane02, image02);
        } else if (clickedButton == button0201) {
            handleButtonClicked(0, 2, 0, 1, button0201, gridPane02, image02);
        } else if (clickedButton == button0202) {
            handleButtonClicked(0, 2, 0, 2, button0202, gridPane02, image02);
        } else if (clickedButton == button0210) {
            handleButtonClicked(0, 2, 1, 0, button0210, gridPane02, image02);
        } else if (clickedButton == button0211) {
            handleButtonClicked(0, 2, 1, 1, button0211, gridPane02, image02);
        } else if (clickedButton == button0212) {
            handleButtonClicked(0, 2, 1, 2, button0212, gridPane02, image02);
        } else if (clickedButton == button0220) {
            handleButtonClicked(0, 2, 2, 0, button0220, gridPane02, image02);
        } else if (clickedButton == button0221) {
            handleButtonClicked(0, 2, 2, 1, button0221, gridPane02, image02);
        } else if (clickedButton == button0222) {
            handleButtonClicked(0, 2, 2, 2, button0222, gridPane02, image02);
        } else if (clickedButton == button1000) {
            handleButtonClicked(1, 0, 0, 0, button1000, gridPane10, image10);
        } else if (clickedButton == button1001) {
            handleButtonClicked(1, 0, 0, 1, button1001, gridPane10, image10);
        } else if (clickedButton == button1002) {
            handleButtonClicked(1, 0, 0, 2, button1002, gridPane10, image10);
        } else if (clickedButton == button1010) {
            handleButtonClicked(1, 0, 1, 0, button1010, gridPane10, image10);
        } else if (clickedButton == button1011) {
            handleButtonClicked(1, 0, 1, 1, button1011, gridPane10, image10);
        } else if (clickedButton == button1012) {
            handleButtonClicked(1, 0, 1, 2, button1012, gridPane10, image10);
        } else if (clickedButton == button1020) {
            handleButtonClicked(1, 0, 2, 0, button1020, gridPane10, image10);
        } else if (clickedButton == button1021) {
            handleButtonClicked(1, 0, 2, 1, button1021, gridPane10, image10);
        } else if (clickedButton == button1022) {
            handleButtonClicked(1, 0, 2, 2, button1022, gridPane10, image10);
        } else if (clickedButton == button1100) {
            handleButtonClicked(1, 1, 0, 0, button1100, gridPane11, image11);
        } else if (clickedButton == button1101) {
            handleButtonClicked(1, 1, 0, 1, button1101, gridPane11, image11);
        } else if (clickedButton == button1102) {
            handleButtonClicked(1, 1, 0, 2, button1102, gridPane11, image11);
        } else if (clickedButton == button1110) {
            handleButtonClicked(1, 1, 1, 0, button1110, gridPane11, image11);
        } else if (clickedButton == button1111) {
            handleButtonClicked(1, 1, 1, 1, button1111, gridPane11, image11);
        } else if (clickedButton == button1112) {
            handleButtonClicked(1, 1, 1, 2, button1112, gridPane11, image11);
        } else if (clickedButton == button1120) {
            handleButtonClicked(1, 1, 2, 0, button1120, gridPane11, image11);
        } else if (clickedButton == button1121) {
            handleButtonClicked(1, 1, 2, 1, button1121, gridPane11, image11);
        } else if (clickedButton == button1122) {
            handleButtonClicked(1, 1, 2, 2, button1122, gridPane11, image11);
        } else if (clickedButton == button1200) {
            handleButtonClicked(1, 2, 0, 0, button1200, gridPane12, image12);
        } else if (clickedButton == button1201) {
            handleButtonClicked(1, 2, 0, 1, button1201, gridPane12, image12);
        } else if (clickedButton == button1202) {
            handleButtonClicked(1, 2, 0, 2, button1202, gridPane12, image12);
        } else if (clickedButton == button1210) {
            handleButtonClicked(1, 2, 1, 0, button1210, gridPane12, image12);
        } else if (clickedButton == button1211) {
            handleButtonClicked(1, 2, 1, 1, button1211, gridPane12, image12);
        } else if (clickedButton == button1212) {
            handleButtonClicked(1, 2, 1, 2, button1212, gridPane12, image12);
        } else if (clickedButton == button1220) {
            handleButtonClicked(1, 2, 2, 0, button1220, gridPane12, image12);
        } else if (clickedButton == button1221) {
            handleButtonClicked(1, 2, 2, 1, button1221, gridPane12, image12);
        } else if (clickedButton == button1222) {
            handleButtonClicked(1, 2, 2, 2, button1222, gridPane12, image12);
        } else if (clickedButton == button2000) {
            handleButtonClicked(2, 0, 0, 0, button2000, gridPane20, image20);
        } else if (clickedButton == button2001) {
            handleButtonClicked(2, 0, 0, 1, button2001, gridPane20, image20);
        } else if (clickedButton == button2002) {
            handleButtonClicked(2, 0, 0, 2, button2002, gridPane20, image20);
        } else if (clickedButton == button2010) {
            handleButtonClicked(2, 0, 1, 0, button2010, gridPane20, image20);
        } else if (clickedButton == button2011) {
            handleButtonClicked(2, 0, 1, 1, button2011, gridPane20, image20);
        } else if (clickedButton == button2012) {
            handleButtonClicked(2, 0, 1, 2, button2012, gridPane20, image20);
        } else if (clickedButton == button2020) {
            handleButtonClicked(2, 0, 2, 0, button2020, gridPane20, image20);
        } else if (clickedButton == button2021) {
            handleButtonClicked(2, 0, 2, 1, button2021, gridPane20, image20);
        } else if (clickedButton == button2022) {
            handleButtonClicked(2, 0, 2, 2, button2022, gridPane20, image20);
        } else if (clickedButton == button2100) {
            handleButtonClicked(2, 1, 0, 0, button2100, gridPane21, image21);
        } else if (clickedButton == button2101) {
            handleButtonClicked(2, 1, 0, 1, button2101, gridPane21, image21);
        } else if (clickedButton == button2102) {
            handleButtonClicked(2, 1, 0, 2, button2102, gridPane21, image21);
        } else if (clickedButton == button2110) {
            handleButtonClicked(2, 1, 1, 0, button2110, gridPane21, image21);
        } else if (clickedButton == button2111) {
            handleButtonClicked(2, 1, 1, 1, button2111, gridPane21, image21);
        } else if (clickedButton == button2112) {
            handleButtonClicked(2, 1, 1, 2, button2112, gridPane21, image21);
        } else if (clickedButton == button2120) {
            handleButtonClicked(2, 1, 2, 0, button2120, gridPane21, image21);
        } else if (clickedButton == button2121) {
            handleButtonClicked(2, 1, 2, 1, button2121, gridPane21, image21);
        } else if (clickedButton == button2122) {
            handleButtonClicked(2, 1, 2, 2, button2122, gridPane21, image21);
        } else if (clickedButton == button2200) {
            handleButtonClicked(2, 2, 0, 0, button2200, gridPane22, image22);
        } else if (clickedButton == button2201) {
            handleButtonClicked(2, 2, 0, 1, button2201, gridPane22, image22);
        } else if (clickedButton == button2202) {
            handleButtonClicked(2, 2, 0, 2, button2202, gridPane22, image22);
        } else if (clickedButton == button2210) {
            handleButtonClicked(2, 2, 1, 0, button2210, gridPane22, image22);
        } else if (clickedButton == button2211) {
            handleButtonClicked(2, 2, 1, 1, button2211, gridPane22, image22);
        } else if (clickedButton == button2212) {
            handleButtonClicked(2, 2, 1, 2, button2212, gridPane22, image22);
        } else if (clickedButton == button2220) {
            handleButtonClicked(2, 2, 2, 0, button2220, gridPane22, image22);
        } else if (clickedButton == button2221) {
            handleButtonClicked(2, 2, 2, 1, button2221, gridPane22, image22);
        } else if (clickedButton == button2222) {
            handleButtonClicked(2, 2, 2, 2, button2222, gridPane22, image22);
        }
    }

    @FXML
    public void changeText() {
        // Change the turn label text and color
        if (turnText.getText().equals("It's Xs TURN")) {
            turnText.setText("It's Os TURN");
            turnText.setFill(Color.BLUE);
        } else {
            turnText.setText("It's Xs TURN");
            turnText.setFill(Color.RED);
        }
    }

    @FXML
    public void changeImage(int bigGridX, int bigGridY, int smallGridX, int smallGridY, boolean player1) {
        Platform.runLater(() -> {
            Button button = findButtonByCoordinates(bigGridX, bigGridY, smallGridX, smallGridY);

            // Load the image using getResource
            ImageView imageView;

            if (player1){
                imageView = new ImageView(new Image(imagePlayer1.toString()));
            } else {
                imageView = new ImageView(new Image(imagePlayer2.toString()));
            }

            // Set the properties of the ImageView
            imageView.setFitHeight(20); // Set the height of the image
            imageView.setFitWidth(15);  // Set the width of the image

            // Set the ImageView as the graphic of the button
            button.setGraphic(imageView);
        });
    }



    public void updatePlayingText(String text) {
        playingText.setText(text);
    }

    private Button findButtonByCoordinates(int bigGridX, int bigGridY, int smallGridX, int smallGridY) {
        return buttons[bigGridX][bigGridY][smallGridX][smallGridY];
    }
    private GridPane findGridPaneByCoordinates(int bigGridX, int bigGridY) {
        return gridPanes[bigGridX][bigGridY];
    }
    private ImageView findImageByCoordinates(int bigGridX, int bigGridY) {
        return images[bigGridX][bigGridY];
    }
}