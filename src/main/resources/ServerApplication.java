package src.main.resources;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server application for clients to connect to it.
 */
public class ServerApplication {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    /**
     * Instantiates a new Server application for clients to connect to it.
     *
     * @param port the port
     */
    public ServerApplication(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("server is up!");

            socket = server.accept();
            System.out.println("client accepted");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over"))
            {
                try
                {
                    line = input.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    /**
     * Run and starts rhe server on port 8000.
     */
    public void run() {
        ServerApplication serverApplication = new ServerApplication(8000);
    }
}
