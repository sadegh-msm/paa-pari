package src.main.resources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The type Client handler.
 */
public class ClientHandler extends Thread{
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;

    /**
     * Instantiates a new Client handler.
     *
     * @param socket the socket
     * @param input  the input
     * @param output the output
     */
    public ClientHandler(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }

    public void run() {
        String received;
        String toReturn;

        while (true) {
            try {
                // Ask user what he wants
                output.writeUTF("");
                // receive the answer from client
                received = input.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                // write on output stream based on the
                // answer from the client
                switch (received) {
                    //client choice
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.input.close();
            this.output.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}