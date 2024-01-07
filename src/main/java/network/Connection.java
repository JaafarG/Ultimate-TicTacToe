package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;
    private Listener listener;

    public Connection(Socket socket, Listener listener) throws IOException {
        this.socket = socket;
        this.listener = listener;

        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Thread(this::listenMove).start();
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

        } catch (IOException e) {
            System.err.println("Error when closing the connection : " + e.getMessage());
        }
    }

    private void listenMove() {
        try {
            String move;

            while ((move = input.readLine()) != null) {
                // Notifier le listener lorsqu'un move est reçu
                if (listener != null) {
                    listener.onMoveReceived(move);
                }
            }
        } catch (IOException e) {
            close();
        }
    }

    public void sendMove(String move) {
        String movePattern = "^[a-i][1-9]$";

        if (move.matches(movePattern)) {
            output.println(move);
        } else {
            System.out.println("Invalid move format. Move must be in the format 'xy' where x=a-i and y=1-9.");
        }
    }
}
