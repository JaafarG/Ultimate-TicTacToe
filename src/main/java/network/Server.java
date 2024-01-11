package network;

import org.example.ultimatetictactoe.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Listener {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private Connection connection;
    private Controller controller;
    private String IPAddress;
    private int port;
    private String name;

    public Server(String IPAddress, int port, String name) {
        this.IPAddress = IPAddress;
        this.port = port;
        this.name = (name==null) ? "Server" : name;
    }

    public Connection getConnection() { return this.connection; }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            System.out.println("Waiting for the connexion with the client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Configuration des flux de données
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            connection = new Connection(clientSocket, this);
        } catch (IOException e) {
            System.err.println("An error occurred while starting the server: " + e.getMessage());
        }
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
                    connection.sendMessage(name + ": " + input);
                }
            }
        }).start();
    }

    @Override
    public void onMessageReceived(String message) {
        System.out.println(message);
    }
}