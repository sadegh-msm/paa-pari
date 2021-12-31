package src.main.resources;

import src.main.java.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * The type Client handler.
 */
public class ClientHandler extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private Menu menu;
    private Pari pari;
    private Account account = new Account();
    private PariService pariService = new PariService();
    private TimelineSystemImpl timeline = new TimelineSystemImpl();
    private ObserverSystemImpl os = new ObserverSystemImpl();
    private ReplyingSystemImpl rs = new ReplyingSystemImpl();

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
        this.menu = new Menu(pari, account, pariService, timeline, os, rs);
    }

    public void run() {
        String received;
        while (true) {
            try {
                // Ask user what he wants
                output.writeUTF("what do you want to do?\n" +
                        "1. sign in\n" +
                        "2. sign up\n" +
                        "3. tweets\n" +
                        "4. likes\n" +
                        "5. retweet\n" +
                        "6. timeline\n" +
                        "7. follow or unfollow\n" +
                        "8. reply\n" +
                        "type exit to close the app\n");
                // receive the answer from client
                received = input.readUTF();
                if (received.equals("exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                // write on output stream based on the
                // answer from the client
                System.out.println("What do you want to do");
                System.out.println(received);
                switch (received) {
                    //client choice
                    case "1":
                        menu.signIn();

                    case "2":
                        menu.signUp();

                    case "3":
                        menu.tweet();

                    case "4":
                        menu.likePari();

                    case "5":
                        menu.reTweetPari();

                    case "6":
                        menu.timeLine();

                    case "7":
                        menu.Observe();

                    case "8":
                        menu.reply();

                    default:
                        System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.input.close();
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}