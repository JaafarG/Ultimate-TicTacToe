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
    public Button button0202;
    public Button button0002;
    public Text NotAllowedText;
    private Game currentGame;
    private Board board;
    public Button button2222;

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

        Player player1 = new Player("p1", Symbol.X);
        Player player2 = new Player("p2", Symbol.O);

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
    public void onButton2020clicked() {
        if (board != null && board.validateMove(2,0,2,0)) {
            currentGame.playMove(2,0,2,0);
            button0202.setOpacity(1.0);
            changeText();
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }

    }



    public void onButton2222clicked() {
        ChangeImage(button2222);
        if (board != null && board.validateMove(2,2,2,2)) {
            currentGame.playMove(2,2,2,2);
            changeText();
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }
    }


    @FXML
    public void onButton2000clicked() {
        if (board != null && board.validateMove(2,0,0,0)) {
            currentGame.playMove(2,0,0,0);
            button0002.setOpacity(1.0);
            changeText();
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }

    }
    @FXML
    public void onButton0000clicked() {

       if (board != null && board.validateMove(0,0,0,0)) {
           changeText();
           imageViewX.setOpacity(1.0);
           currentGame.playMove(0,0,0,0);
           System.out.println("Board isn't  null");
           NotAllowedText.setOpacity(0.0);
       }else{
           NotAllowedText.setOpacity(1.0);
       }
       if (board == null) {
            System.out.println("Board is  null");
       }


    }

    @FXML
    public void onButton0010clicked() {

        if (board != null && board.validateMove(0,0,1,0)) {
            changeText();
            imageViewX2.setOpacity(1.0);
            currentGame.playMove(0,0,1,0);
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }


    }

    @FXML
    public void ChangeImage(Button button) {
        // Load the image using getResource
        URL imageUrl = getClass().getResource("/X_icon.png");
        if (imageUrl != null) {
            Image image = new Image(((URL) imageUrl).toString());
            ImageView imageView = new ImageView(image);

            // Set the properties of the ImageView
            imageView.setFitHeight(20); // Set the height of the image
            imageView.setFitWidth(15);  // Set the width of the image

            // Set the ImageView as the graphic of the button
            button2222.setGraphic(imageView);
        } else {
            System.out.println("Image file not found");
        }
    }
    public void handleButtonclicked(int a, int b , int c , int d) {

        if (board != null && board.validateMove(a,b,c,d)) {
            changeText();
            currentGame.playMove(a,b,c,d);
            NotAllowedText.setOpacity(0.0);
        }else{
            NotAllowedText.setOpacity(1.0);
        }
    }










































































    /*@FXML
    public void onButton0001clicked() { Game.playMove(0,0,0,1); }
    @FXML
    public void onButton0002clicked() { Game.playMove(0,0,0,2); }
    @FXML
    public void onButton0010clicked() { Game.playMove(0,0,1,0); }
    @FXML
    public void onButton0011clicked() { Game.playMove(0,0,1,1); }
    @FXML
    public void onButton0012clicked() { Game.playMove(0,0,1,2); }
    @FXML
    public void onButton0020clicked() { Game.playMove(0,0,2,0); }
    @FXML
    public void onButton0021clicked() { Game.playMove(0,0,2,1); }
    @FXML
    public void onButton0022clicked() { Game.playMove(0,0,2,2); }
    @FXML
    public void onButton0100clicked() { Game.playMove(0,1,0,0); }
    @FXML
    public void onButton0101clicked() { Game.playMove(0,1,0,1); }
    @FXML
    public void onButton0102clicked() { Game.playMove(0,1,0,2); }
    @FXML
    public void onButton0110clicked() { Game.playMove(0,1,1,0); }
    @FXML
    public void onButton0111clicked() { Game.playMove(0,1,1,1); }
    @FXML
    public void onButton0112clicked() { Game.playMove(0,1,1,2); }
    @FXML
    public void onButton0120clicked() { Game.playMove(0,1,2,0); }
    @FXML
    public void onButton0121clicked() { Game.playMove(0,1,2,1); }
    @FXML
    public void onButton0122clicked() { Game.playMove(0,1,2,2); }
    @FXML
    public void onButton0200clicked() { Game.playMove(0,2,0,0); }
    @FXML
    public void onButton0201clicked() { Game.playMove(0,2,0,1); }
    @FXML
    public void onButton0202clicked() { Game.playMove(0,2,0,2); }
    @FXML
    public void onButton0210clicked() { Game.playMove(0,2,1,0); }
    @FXML
    public void onButton0211clicked() { Game.playMove(0,2,1,1); }
    @FXML
    public void onButton0212clicked() { Game.playMove(0,2,1,2); }
    @FXML
    public void onButton0220clicked() { Game.playMove(0,2,2,0); }
    @FXML
    public void onButton0221clicked() { Game.playMove(0,2,2,1); }
    @FXML
    public void onButton0222clicked() { Game.playMove(0,2,2,2); }
    @FXML
    public void onButton1000clicked() { Game.playMove(1,0,0,0); }
    @FXML
    public void onButton1001clicked() { Game.playMove(1,0,0,1); }
    @FXML
    public void onButton1002clicked() { Game.playMove(1,0,0,2); }
    @FXML
    public void onButton1010clicked() { Game.playMove(1,0,1,0); }
    @FXML
    public void onButton1011clicked() { Game.playMove(1,0,1,1); }
    @FXML
    public void onButton1012clicked() { Game.playMove(1,0,1,2); }
    @FXML
    public void onButton1020clicked() { Game.playMove(1,0,2,0); }
    @FXML
    public void onButton1021clicked() { Game.playMove(1,0,2,1); }
    @FXML
    public void onButton1022clicked() { Game.playMove(1,0,2,2); }
    @FXML
    public void onButton1100clicked() { Game.playMove(1,1,0,0); }
    @FXML
    public void onButton1101clicked() { Game.playMove(1,1,0,1); }
    @FXML
    public void onButton1102clicked() { Game.playMove(1,1,0,2); }
    @FXML
    public void onButton1110clicked() { Game.playMove(1,1,1,0); }
    @FXML
    public void onButton1111clicked() { Game.playMove(1,1,1,1); }
    @FXML
    public void onButton1112clicked() { Game.playMove(1,1,1,2); }
    @FXML
    public void onButton1120clicked() { Game.playMove(1,1,2,0); }
    @FXML
    public void onButton1121clicked() { Game.playMove(1,1,2,1); }
    @FXML
    public void onButton1122clicked() { Game.playMove(1,1,2,2); }
    @FXML
    public void onButton1200clicked() { Game.playMove(1,2,0,0); }
    @FXML
    public void onButton1201clicked() { Game.playMove(1,2,0,1); }
    @FXML
    public void onButton1202clicked() { Game.playMove(1,2,0,2); }
    @FXML
    public void onButton1210clicked() { Game.playMove(1,2,1,0); }
    @FXML
    public void onButton1211clicked() { Game.playMove(1,2,1,1); }
    @FXML
    public void onButton1212clicked() { Game.playMove(1,2,1,2); }
    @FXML
    public void onButton1220clicked() { Game.playMove(1,2,2,0); }
    @FXML
    public void onButton1221clicked() { Game.playMove(1,2,2,1); }
    @FXML
    public void onButton1222clicked() { Game.playMove(1,2,2,2); }
    @FXML
    public void onButton2000clicked() { Game.playMove(2,0,0,0); }
    @FXML
    public void onButton2001clicked() { Game.playMove(2,0,0,1); }
    @FXML
    public void onButton2002clicked() { Game.playMove(2,0,0,2); }
    @FXML
    public void onButton2010clicked() { Game.playMove(2,0,1,0); }
    @FXML
    public void onButton2011clicked() { Game.playMove(2,0,1,1); }
    @FXML
    public void onButton2012clicked() { Game.playMove(2,0,1,2); }
    @FXML
    public void onButton2020clicked() { Game.playMove(2,0,2,0); }
    @FXML
    public void onButton2021clicked() { Game.playMove(2,0,2,1); }
    @FXML
    public void onButton2022clicked() { Game.playMove(2,0,2,2); }
    @FXML
    public void onButton2100clicked() { Game.playMove(2,1,0,0); }
    @FXML
    public void onButton2101clicked() { Game.playMove(2,1,0,1); }
    @FXML
    public void onButton2102clicked() { Game.playMove(2,1,0,2); }
    @FXML
    public void onButton2110clicked() { Game.playMove(2,1,1,0); }
    @FXML
    public void onButton2111clicked() { Game.playMove(2,1,1,1); }
    @FXML
    public void onButton2112clicked() { Game.playMove(2,1,1,2); }
    @FXML
    public void onButton2120clicked() { Game.playMove(2,1,2,0); }
    @FXML
    public void onButton2121clicked() { Game.playMove(2,1,2,1); }
    @FXML
    public void onButton2122clicked() { Game.playMove(2,1,2,2); }
    @FXML
    public void onButton2200clicked() { Game.playMove(2,2,0,0); }
    @FXML
    public void onButton2201clicked() { Game.playMove(2,2,0,1); }
    @FXML
    public void onButton2202clicked() { Game.playMove(2,2,0,2); }
    @FXML
    public void onButton2210clicked() { Game.playMove(2,2,1,0); }
    @FXML
    public void onButton2211clicked() { Game.playMove(2,2,1,1); }
    @FXML
    public void onButton2212clicked() { Game.playMove(2,2,1,2); }
    @FXML
    public void onButton2220clicked() { Game.playMove(2,2,2,0); }
    @FXML
    public void onButton2221clicked() { Game.playMove(2,2,2,1); }
    @FXML
    public void onButton2222clicked() { Game.playMove(2,2,2,2); }*/


}