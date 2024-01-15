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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public void setOutput(PrintWriter output) {
        this.output = output;
    }

    public BufferedReader getInput() {
        return input;
    }

    public void setInput(BufferedReader input) {
        this.input = input;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Connection(Socket socket, Listener listener) throws IOException {
        this.socket = socket;
        this.listener = listener;

        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        new Thread(this::listenMessage).start();
        //new Thread(this::listenChat).start();
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

    private void listenMessage() {
        try {
            String message;

            while ((message = input.readLine()) != null) {
                // Notifier le listener lorsqu'un message est reçu
                if (listener != null) {
                    listener.onMessageReceived(message);
                }
            }
        } catch (IOException e) {
            close();
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    /*
    private void listenChat() {
        try {
            String chat;

            while ((chat = input.readLine()) != null) {
                // Notifier le listener lorsqu'un chat est reçu
                if (listener != null) {
                    listener.onChatReceived(chat);
                }
            }
        } catch (IOException e) {
            close();
        }
    }

    public void sendChat(String chat) {
        output.println(chat);
    }*/
}
