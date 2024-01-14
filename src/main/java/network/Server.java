package network;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.example.ultimatetictactoe.Controller.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

public class Server implements Listener {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private Connection connection;
    private GameController gameController;
    private String IPAddress;
    private int port;
    private String name;

    public Server(String IPAddress, int port, String name, GameController gameController) {
        this.IPAddress = IPAddress;
        this.port = port;
        this.name = (name==null) ? "Server" : name;
        this.gameController = gameController;
    }

    public Connection getConnection() { return this.connection; }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        System.out.println("Waiting for the connexion with the client...");
        clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        // Configuration des flux de données
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        connection = new Connection(clientSocket, this);
    }

    public void stop() {
        try {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
            System.out.println("Server stopped.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'arrêt du serveur : " + e.getMessage());
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
            // Client won
            case "OK" -> {
                gameController.getCurrentGame().setGameState(true);
                gameController.getCurrentGame().getPlayers()[0].setWinner(true);

                Platform.runLater(() -> {
                    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmationAlert.setTitle("Your opponent won the game !");
                    confirmationAlert.setHeaderText("Don't give up. But if you do, don't rate us 1 star on PlayStore. 🥹");
                    confirmationAlert.setContentText("Click on OK to return to the menu.");

                    // If the user closes with the cross button
                    confirmationAlert.setOnCloseRequest(event -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    Optional<ButtonType> result = confirmationAlert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            // Client forfeited
            case "KO" -> {
                gameController.getCurrentGame().setGameState(true);
                gameController.getCurrentGame().getPlayers()[1].setWinner(true);

                Platform.runLater(() -> {
                    Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
                    confirmationAlert.setTitle("Your opponent resigned !");
                    confirmationAlert.setHeaderText("Lucky you ! Your opponent resigned, offering you victory.");
                    confirmationAlert.setContentText("Click on OK to return to the menu.");

                    // If the user closes with the cross button
                    confirmationAlert.setOnCloseRequest(event -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    Optional<ButtonType> result = confirmationAlert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            // Game is a tie
            case "XO" -> {
                gameController.getCurrentGame().setGameState(true);

                Platform.runLater(() -> {
                    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmationAlert.setTitle("It's a tie !");
                    confirmationAlert.setHeaderText("Your opponent made the final possible move of the game and did not manage to win... What a loser !");
                    confirmationAlert.setContentText("Click on OK to return to the menu.");

                    // If the user closes with the cross button
                    confirmationAlert.setOnCloseRequest(event -> {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    Optional<ButtonType> result = confirmationAlert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/ultimatetictactoe/menu-view.fxml"));
                            Scene scene = new Scene(loader.load());
                            Stage stage = (Stage) gameController.getAdviceText().getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            default -> {
                // If the message is 4 characters long
                if (message.length() == 4) {
                    // Check if it is the opponent's turn
                    if (gameController.getCurrentGame().getCurrentPlayer() == gameController.getCurrentGame().getPlayers()[1]) {
                        int bigGridIndex1 = Integer.parseInt(String.valueOf(message.charAt(0)));
                        int bigGridIndex2 = Integer.parseInt(String.valueOf(message.charAt(1)));

                        int smallGridIndex1 = Integer.parseInt(String.valueOf(message.charAt(2)));
                        int smallGridIndex2 = Integer.parseInt(String.valueOf(message.charAt(3)));

                        gameController.changeImage(bigGridIndex1, bigGridIndex2, smallGridIndex1, smallGridIndex2, false);
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