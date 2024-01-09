package org.example.ultimatetictactoe;


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


public class Controller {


    public Label turnLabel;
    public Label playingLabel;
    public ImageView imageViewX;
    public ImageView imageViewX2;
    public Text NotAllowedText;
    public GridPane gridpane00;
    public GridPane gridpane01;
    public GridPane gridpane02;
    public GridPane gridpane10;
    public GridPane gridpane11;
    public GridPane gridpane12;
    public GridPane gridpane20;
    public GridPane gridpane21;
    public GridPane gridpane22;
    private Game currentGame;
    private Board board;

    public Button button0000;
    public Button button0001;
    public Button button0002;
    public Button button0010;
    public Button button0011;
    public Button button0012;
    public Button button0020;
    public Button button0021;
    public Button button0022;

    public Button button0100;
    public Button button0101;
    public Button button0102;
    public Button button0110;
    public Button button0111;
    public Button button0112;
    public Button button0120;
    public Button button0121;
    public Button button0122;

    public Button button0200;
    public Button button0201;
    public Button button0202;
    public Button button0210;
    public Button button0211;
    public Button button0212;
    public Button button0220;
    public Button button0221;
    public Button button0222;

    public Button button1000;
    public Button button1001;
    public Button button1002;
    public Button button1010;
    public Button button1011;
    public Button button1012;
    public Button button1020;
    public Button button1021;
    public Button button1022;

    public Button button1100;
    public Button button1101;
    public Button button1102;
    public Button button1110;
    public Button button1111;
    public Button button1112;
    public Button button1120;
    public Button button1121;
    public Button button1122;

    public Button button1200;
    public Button button1201;
    public Button button1202;
    public Button button1210;
    public Button button1211;
    public Button button1212;
    public Button button1220;
    public Button button1221;
    public Button button1222;

    public Button button2000;
    public Button button2001;
    public Button button2002;
    public Button button2010;
    public Button button2011;
    public Button button2012;
    public Button button2020;
    public Button button2021;
    public Button button2022;

    public Button button2100;
    public Button button2101;
    public Button button2102;
    public Button button2110;
    public Button button2111;
    public Button button2112;
    public Button button2120;
    public Button button2121;
    public Button button2122;

    public Button button2200;
    public Button button2201;
    public Button button2202;
    public Button button2210;
    public Button button2211;
    public Button button2212;
    public Button button2220;
    public Button button2221;
    public Button button2222;
    private Player player1;
    private Player player2;

    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    public void setGameBoard(Board board) {
        this.board = board;
    }

    @FXML
    protected void onRulesButtonClick() {
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
    @FXML
    protected void onPlayGameButtonClick(ActionEvent event) throws IOException {

        // Load the game-view FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent gameViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(gameViewRoot));
        stage.show();

        /*if (currentGame.getBoard().currentPlayer == player2){
            changeText();
        }*/
    }

    @FXML
    protected void onPlayGameButtonClickDebug(ActionEvent event) throws IOException {

        player1 = new Player("p1", Symbol.X);
        player2 = new Player("p2", Symbol.O);

        // Create a new Game instance
        Game currentGame = new Game(player1, player2);
        board = currentGame.getBoard();

        // Load the game-view FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
        Parent gameViewRoot = loader.load();

        Controller gameViewController = loader.getController();
        gameViewController.setCurrentGame(currentGame);
        gameViewController.setGameBoard(currentGame.getBoard());

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(gameViewRoot));
        stage.show();

        /*if (currentGame.getBoard().currentPlayer == player2){
            changeText();
        }*/
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

    @FXML
    public void changeText() {

        if (turnLabel.getText().equals("It's Xs TURN")) {
            turnLabel.setText("It's Os TURN");
        } else {
            turnLabel.setText("It's Xs TURN");
        }
        // Change the playing label text and color
        if (playingLabel.getText().equals("You're playing X")) {
            playingLabel.setText("You're playing O");
            playingLabel.setTextFill(Color.BLUE); // Set text color to blue
        } else {
            playingLabel.setText("You're playing X");
            playingLabel.setTextFill(Color.RED); // Set text color to red
        }
    }



    @FXML
    public void ChangeImage(Button button) {
        // Load the image using getResource
        URL imageUrl = getClass().getResource("/X_icon.png");
        if(board.currentPlayer.getName() == "p2" ){
            imageUrl = getClass().getResource("/O_icon.png");
        }
        Image image = new Image(((URL) imageUrl).toString());
        ImageView imageView = new ImageView(image);

        // Set the properties of the ImageView
        imageView.setFitHeight(20); // Set the height of the image
        imageView.setFitWidth(15);  // Set the width of the image

        // Set the ImageView as the graphic of the button
        button.setGraphic(imageView);
    }
    public void handleButtonClicked(int a, int b , int c , int d , Button button, GridPane gridpane) {

        if (board != null && board.validateMove(a,b,c,d)) {
            changeText();
            ChangeImage(button);
            currentGame.playMove(a,b,c,d);
            NotAllowedText.setOpacity(0.0);
            if (board.grid[a][b].win){
                gridpane.setOpacity(0.0);
            }

        }else{
            NotAllowedText.setOpacity(1.0);
        }
        System.out.println("Current Player will be : " + board.currentPlayer.getName());
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


}