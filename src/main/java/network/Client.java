package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client implements Listener {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private Connection connection;
    private String IPAddress;
    private int port;
    private String name;

    public Client(String IPAddress, int port, String name) {
        this.IPAddress = IPAddress;
        this.port = port;
        this.name = "Client";
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void startListeningForMove() {
        new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    String input = scanner.nextLine();
                    connection.sendMove(input);
                }
            }
        }).start();
    }

    @Override
    public void onMoveReceived(String move) {

    }
}
