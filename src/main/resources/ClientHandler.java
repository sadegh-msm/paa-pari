package src.main.resources;

import src.main.java.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
        String toReturn;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                // Ask user what he wants
                output.writeUTF("what do you want to do?" +
                        "1. sing in" +
                        "2. sing up" +
                        "3. tweets" +
                        "4. likes" +
                        "5. retweet" +
                        "6. timeline" +
                        "7. follow or unfollow" +
                        "8. reply" +
                        "type exit to close the app");
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
                switch (received) {
                    //client choice
                    case "1":
                        System.out.println("Please Enter your username and password");
                        String us, pas;

                        us = scanner.nextLine();
                        pas = scanner.nextLine();
                        menu.signIn(us, pas);
                        scanner.close();

                    case "2":
                        System.out.println("PLease enter your username and password");
                        String username;
                        String pass;
                        username = scanner.nextLine();
                        pass = scanner.nextLine();
                        menu.signUp(username, pass);
                        scanner.close();
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