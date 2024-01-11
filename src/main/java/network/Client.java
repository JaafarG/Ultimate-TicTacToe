package network;

import org.example.ultimatetictactoe.Controller;
import org.example.ultimatetictactoe.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import java.util.Scanner;

public class Client implements Listener {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private Connection connection;
    private Controller controller;
    private String IPAddress;
    private int port;
    private String name;

    public Client(String IPAddress, int port, String name) {
        this.IPAddress = IPAddress;
        this.port = port;
        this.name = (name==null) ? "Client" : name;
    }

    public void connectToServer() throws IOException {
        try {
            socket = new Socket(IPAddress, port);
            System.out.println("Connected to the server.");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            connection = new Connection(socket, this);
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            System.err.println("Try connecting to the server again.");
        }
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
                    connection.sendMessage(name + ": " + input);
                    receiveMessage(input);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void onMessageReceived(String message) {
        System.out.println(message);
    }

    public void receiveMessage(String message) throws IOException {
        switch (message) {
            case "X":
                controller.getCurrentGame().getPlayers()[0].setSymbol(Symbol.O);
                controller.getCurrentGame().getPlayers()[1].setSymbol(Symbol.X);
                break;
            case "O":
                controller.getCurrentGame().getPlayers()[0].setSymbol(Symbol.X);
                controller.getCurrentGame().getPlayers()[1].setSymbol(Symbol.O);
                break;
        }
    }
}
