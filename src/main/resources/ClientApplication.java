package src.main.resources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The Client application can connect a server on given port.
 */
public class ClientApplication {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    /**
     * Instantiates a new Client application for connecting to server.
     *
     * @param address the address
     * @param port    the port
     */
    public ClientApplication(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("connected");

            input = new DataInputStream(System.in);

            output = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        String line = "";

        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        try
        {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    /**
     * Run and start a client on localhost and port 8000.
     */
    public void run() {
        ClientApplication clientApplication = new ClientApplication("127.0.0.1", 8000);
    }
}

