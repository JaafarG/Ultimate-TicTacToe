package network;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.ultimatetictactoe.Controller.ConfigurationController;
import org.example.ultimatetictactoe.Controller.GameController;
import org.example.ultimatetictactoe.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

public class Client implements Listener {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private Connection connection;
    private GameController gameController;

    private int symbolSkin;

    private ConfigurationController configurationController;
    private String IPAddress;
    private int port;
    private String name;

    public Client(String IPAddress, int port, String name, GameController gameController, int symbolSkin) {
        this.IPAddress = IPAddress;
        this.port = port;
        this.name = (name==null) ? "Client" : name;
        this.gameController = gameController;
        this.symbolSkin = symbolSkin;
    }

    public Connection getConnection() { return this.connection; }

    public void connectToServer() throws IOException {
        socket = new Socket(IPAddress, port);
        System.out.println("Connected to the server.");

        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);

        connection = new Connection(socket, this);
    }

    public void close() {
        try {
            if (output != null) {
                output.close();
            }

            if (input != null) {
                input.close();
            }

            if (socket != null) {
                socket.close();
            }

            System.out.println("Connection is closed.");
        } catch (IOException e) {
            System.err.println("Error when closing the connection : " + e.getMessage());
        }
    }

    public void startListeningForMessage() {
        new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String input = scanner.nextLine();
                    connection.sendMessage(input);
                }
            }
        }).start();
    }

    @Override
    public void onMessageReceived(String message) {
        System.out.println("onMessageReceived " + message);

        switch (message) {
            // Client will play "X"
            case "X" -> {
                gameController.getCurrentGame().setCurrentPlayer(gameController.getCurrentGame().getPlayers()[1]);
                gameController.getCurrentGame().getCurrentPlayer().setStarter(true);
                gameController.getCurrentGame().getPlayers()[0].setSymbol(Symbol.O);
                gameController.getCurrentGame().getPlayers()[1].setSymbol(Symbol.X);
                gameController.updatePlayingText("You're playing X");
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
            }
            // Client will play "O"
            case "O" -> {
                gameController.getCurrentGame().setCurrentPlayer(gameController.getCurrentGame().getPlayers()[0]);
                gameController.getCurrentGame().getCurrentPlayer().setStarter(true);
                gameController.getCurrentGame().getPlayers()[0].setSymbol(Symbol.X);
                gameController.getCurrentGame().getPlayers()[1].setSymbol(Symbol.O);
                gameController.updatePlayingText("You're playing O");
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
            }
            // Server won
            case "OK" -> {
                gameController.getCurrentGame().setGameState(true);
                gameController.getCurrentGame().getPlayers()[0].setWinner(true);
            }
            // Server forfeited
            case "KO" -> {
                gameController.getCurrentGame().setGameState(true);
                gameController.getCurrentGame().getPlayers()[1].setWinner(true);
            }
            // Game is a tie
            case "XO" -> {
                gameController.getCurrentGame().setGameState(true);
            }
            default -> {
                // If the message is 4 characters long
                if (message.length() == 4) {
                    // Check if it is the opponent's turn
                    if (gameController.getCurrentGame().getCurrentPlayer() == gameController.getCurrentGame().getPlayers()[0]) {
                        int bigGridIndex1 = Integer.parseInt(String.valueOf(message.charAt(0)));
                        int bigGridIndex2 = Integer.parseInt(String.valueOf(message.charAt(1)));

                        int smallGridIndex1 = Integer.parseInt(String.valueOf(message.charAt(2)));
                        int smallGridIndex2 = Integer.parseInt(String.valueOf(message.charAt(3)));

                        gameController.changeImage(bigGridIndex1, bigGridIndex2, smallGridIndex1, smallGridIndex2, true);
                        gameController.changeText();
                        gameController.getCurrentGame().playMove(bigGridIndex1, bigGridIndex2, smallGridIndex1, smallGridIndex2);
                        gameController.changeGridImage(bigGridIndex1,bigGridIndex2);
                    } else {
                        System.out.println("Server tried to play a move but it was not its time to shine");
                    }
                } else {
                    System.out.println("The message must be 4 characters long");
                }
            }
        }
    }
}
