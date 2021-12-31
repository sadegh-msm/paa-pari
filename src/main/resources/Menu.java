package src.main.resources;


import src.main.java.*;

import java.io.*;
import java.util.Scanner;


/**
 * The type Menu.
 */
public class Menu {
    private Pari pari;
    private Account account;
    private PariService pariService;
    private TimelineSystemImpl timeline;
    private ObserverSystemImpl os;
    private ReplyingSystemImpl rs;

    /**
     * Instantiates a new Menu.
     *
     * @param pari     the pari
     * @param account  the account
     * @param ps       the ps
     * @param timeline the timeline
     * @param os       the os
     * @param rs       the rs
     */
    public Menu(Pari pari, Account account, PariService ps, TimelineSystemImpl timeline,
                ObserverSystemImpl os, ReplyingSystemImpl rs) {
        this.pari = pari;
        this.account = account;
        this.pariService = ps;
        this.timeline = timeline;
        this.os = os;
        this.rs = rs;
    }

    /**
     * Sign in.
     *
     */
    public void signIn() {
        System.out.println("PLease enter your username and password");
        String username;
        String pass;
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
        pass = scanner.nextLine();
        System.out.println("Login in.......");
        if (readFromFile(username, pass)) {
            System.out.println("Logged in successfully");
            timeline.displayPari(account);
        } else {
            signIn();
        }
    }

    /**
     * Sign up.
     *
     */
    public void signUp() {
        System.out.println("Please Enter your username and password");
        String us, pas;
        Scanner scanner = new Scanner(System.in);
        us = scanner.nextLine();
        pas = scanner.nextLine();
        System.out.println("Enter your First name");
        String fName = scanner.nextLine();
        account.setFirstName(fName);
        System.out.println("Enter your Last name");
        String lName = scanner.nextLine();
        account.setLastName(lName);
        System.out.println("Write your biography");
        System.out.println("Its length shouldn't be more than 256");
        String bio;
        bio = scanner.nextLine();
        while (!account.setBiography(bio)) {
            System.out.println("Enter again");
            bio = scanner.nextLine();
        }
        System.out.println("Enter your date of birth");
        String date;
        date = scanner.nextLine();
        account.setDateOfBirth(date);
        account.setDateOfJoin();
        writeToFile();
        scanner.close();
    }

    /**
     * Time line.
     */
    public void timeLine() {
        for (int i = 0; i < os.getFollowedUsers().size(); i++) {
            timeline.displayPari(os.getFollowedUsers().get(i));
        }
    }

    /**
     * Observe.
     */
    public void Observe() {
        System.out.println("1.Followers list\n2.Follow\n3.Unfollow");
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (int i = 0; i < os.getFollowedUsers().size(); i++) {
                    System.out.println(os.getFollowedUsers().get(i));
                }
            case 2:
                os.follow(account);
            case 3:
                os.unfollow(account);
        }
    }

    /**
     * Tweet.
     */
    public void tweet() {
        System.out.println("1.Please write your tweet\n2.Remove your tweet");
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                pari.writePari("E:\\GitHub\\paa-pari\\files\\model\\paries\\Paries.txt");
            case 2:
                System.out.println("please enter the index of pari you want to delete");
                int index = scanner.nextInt();
                pari.removePari("E:\\GitHub\\paa-pari\\files\\model\\paries\\Paries.txt", index);
        }
    }

    /**
     * Like pari.
     */
    public void likePari(){
        System.out.println("please enter the pari you want to like");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        pariService.like(index);
        scanner.close();
    }

    /**
     * Re tweet.
     */
    public void reTweetPari() {
        System.out.println("please enter the tweet you want to retweet");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        pariService.retweet("E:\\GitHub\\paa-pari\\files\\model\\users\\UsersInfo.txt", pari.getContent());
        int retweetCount = 0;
        retweetCount++;
        pari.setRetweetCount(retweetCount);
    }

    /**
     * Reply.
     */
    public void reply() {
        rs.replyOnPari(pari);
        rs.printReplied();
    }

    /**
     * Write to file.
     */
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("E:\\GitHub\\paa-pari\\files\\model\\users\\UsersInfo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(account.getFirstName());
            bufferedWriter.write(account.getLastName());
            bufferedWriter.write(account.getUsername());
            bufferedWriter.write(account.hash(account.getPassword()));
            bufferedWriter.write(account.getBiography());
            bufferedWriter.write(account.getDateOfBirth());
            bufferedWriter.write(account.getDateOfJoin().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public boolean readFromFile(String username, String password) {
        try {
            FileReader fileReader = new FileReader("E:\\GitHub\\paa-pari\\files\\model\\users\\UsersInfo.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(username)) {
                    if (line.contains(password)) {
                        System.out.println("Logged in");
                    } else {
                        System.out.println("Password is incorrect");
                        return false;
                    }
                } else {
                    System.out.println("Username is incorrect");
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


}
