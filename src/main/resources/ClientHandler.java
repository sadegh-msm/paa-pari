package src.main.resources;

import org.json.JSONObject;
import src.main.java.*;

import java.io.*;
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
    private Account account ;
    private PariService pariService;
    private TimelineSystemImpl timeline;
    private ObserverSystemImpl os;
    private ReplyingSystemImpl rs;
    private ChatClient chatClient;
    private ChatServer chatServer;

    /**
     * Instantiates a new Client handler.
     *
     * @param socket the socket
     * @param input  the input
     * @param output the output
     */
    public ClientHandler(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.output = output;
        this.input = input;
        this.rs = new ReplyingSystemImpl();
        this.os = new ObserverSystemImpl();
        this.timeline = new TimelineSystemImpl();
        this.pariService = new PariService();
        this.account = new Account();
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
                        "9. start server for chat\n" +
                        "10. start chat\n" +
                        "type exit to close the app\n" );
//                JSONObject json = new JSONObject(out);
                output.flush();
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
                System.out.println(received);
                switch (received) {
                    //sign in
                    case "1":
                        output.writeUTF("PLease enter your username and password");
                        output.flush();
                        String username;
                        String pass;
                        username = input.readUTF();
                        pass = input.readUTF();
                        output.writeUTF("Login in.......");
                        output.flush();
                        if (menu.readFromFile(username, pass)) {
                            output.writeUTF("Logged in successfully");
                            output.flush();
                            timeline.displayPari(account);
                        } else {
                            output.writeUTF("your username and password is wrong");
                            output.flush();
                            menu.signIn();
                        }
                    //sign up

                    case "2":
                        output.writeUTF("Please Enter your username and password");
                        output.flush();
                        String us, pas;

                        us = input.readUTF();
                        pas = input.readUTF();
                        output.writeUTF(us);
                        output.writeUTF(pas);
                        output.writeUTF("\n");
                        output.flush();
                        output.writeUTF("Enter your First name");
                        output.flush();
                        String fName = input.readUTF();
                        account.setFirstName(fName);
                        output.writeUTF("Enter your Last name");
                        output.flush();
                        String lName = input.readUTF();
                        account.setLastName(lName);
                        output.writeUTF("Write your biography (256 character)");
                        output.flush();

                        String bio;
                        bio = input.readUTF();
                        while (!account.setBiography(bio)) {
                            output.writeUTF("Enter again");
                            output.flush();
                            bio = input.readUTF();
                        }

                        output.writeUTF("Enter your date of birth");
                        output.flush();
                        String date;
                        date = input.readUTF();
                        account.setDateOfBirth(date);
                        account.setDateOfJoin();
                        menu.writeToFile();

                    //tweet
                    case "3":
                        output.writeUTF("1.Please write your tweet\n2.Remove your tweet");
                        output.flush();

                        String choice = input.readUTF();
                        switch (choice) {
                            case "1":
                                pari.writePari("E:\\GitHub\\paa-pari\\files\\model\\paries\\Paries.txt");

                            case "2":
                                output.writeUTF("please enter the index of pari you want to delete");
                                output.flush();
                                int index = input.readInt();
                                pari.removePari("E:\\GitHub\\paa-pari\\files\\model\\paries\\Paries.txt", index);
                        }
                    //like
                    case "4":
                        output.writeUTF("please enter the pari you want to like");
                        output.flush();
                        int index = input.readInt();

                        pariService.like(index);

                    //retweet
                    case "5":
                        output.writeUTF("please enter the tweet you want to retweet");
                        output.flush();
                        int index1 = input.readInt();

                        pariService.retweet("E:\\GitHub\\paa-pari\\files\\model\\users\\UsersInfo.txt", pari.getContent());
                        int retweetCount = 0;
                        retweetCount++;
                        pari.setRetweetCount(retweetCount);

                    //timeline
                    case "6":
                        for (int i = 0; i < os.getFollowedUsers().size(); i++) {
                            timeline.displayPari(os.getFollowedUsers().get(i));
                        }

                    //observer
                    case "7":
                        output.writeUTF("1.Followers list\n2.Follow\n3.Unfollow");
                        output.flush();
                        int choice1;

                        choice1 = input.readInt();
                        switch (choice1) {
                            case 1:
                                for (int i = 0; i < os.getFollowedUsers().size(); i++) {
                                    System.out.println(os.getFollowedUsers().get(i));
                                }

                            case 2:
                                os.follow(account);

                            case 3:
                                os.unfollow(account);
                        }

                        //reply
                    case "8":
                        rs.replyOnPari(pari);
                        rs.printReplied();

                        // server for chat
                    case "9":
                        int portServer = input.readInt();
                        chatServer = new ChatServer(portServer);
                        chatServer.startChatServer();

                        // client for chat
                    case "10":
                        int portClient = input.readInt();
                        chatClient = new ChatClient("localhost", portClient);
                        chatClient.startChatClient();

                    //again
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