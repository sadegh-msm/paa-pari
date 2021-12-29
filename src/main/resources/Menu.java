package src.main.resources;


import src.main.java.*;

import java.io.*;
import java.util.Scanner;


public class Menu {
    private Pari pari;
    private Account account;
    private PariService pariService;
    private TimelineSystemImpl timeline;
    private ObserverSystemImpl os;

    public Menu(Pari pari, Account account, PariService ps, TimelineSystemImpl timeline,
                ObserverSystemImpl os) {
        this.pari = pari;
        this.account = account;
        this.pariService = ps;
        this.timeline = timeline;
        this.os = os;
    }

    public void signIn(String username, String password) {
        System.out.println("Login in.......");
        if (readFromFile(username, password)) {
            System.out.println("Logged in successfully");
            timeline.displayPari(account);
        } else {
            signIn(username, password);
        }
    }

    public void signUp(String username, String password) {
        System.out.println("Enter your First name");
        Scanner scanner = new Scanner(System.in);
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

    public void timeLine() {
        for (int i = 0; i < os.getFollowedUsers().size(); i++) {
            timeline.displayPari(os.getFollowedUsers().get(i));
        }
    }

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

    public void tweet() {
        System.out.println("1.Please write your tweet\n2.Remove your tweet");
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                pari.writePari("paries");
            case 2:
                pari.removePari("paries",); // index ????
        }

    }

    public void reTweet() {

    }

    public void reply() {

    }

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
