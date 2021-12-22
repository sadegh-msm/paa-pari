package src.main.resources;


import src.main.java.Account;
import src.main.java.Pari;

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
    private Account account;

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
        this.menu = new Menu(pari, account);
    }

    public void run() {
        String received;
        String toReturn;
        Scanner scanner = new Scanner(System.in);
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
                        //Tweet
                    case "4":
                        //Like
                    case "5":
                        //Retweet
                    case "6":
                        //See time line
                    case "7":
                        //follow, unfollow
                    case "8":
                        //Reply
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