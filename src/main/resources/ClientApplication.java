package src.main.resources;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * The Client application can connect a server on given port.
 */
public class ClientApplication {

    /**
     * Starts a client on port 8000.
     */
    public void StartClient() {
        try {
            Scanner scanner = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip, 8000);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {
                System.out.println(input.readUTF());
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);

                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection : " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                // prints the info from server
                String received = input.readUTF();
                System.out.println(received);
            }

            scanner.close();
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}