package src.main.resources;


import src.main.java.Account;
import src.main.java.Pari;

import java.util.Scanner;


public class Menu {
    private Pari pari;
    private Account account;

    public Menu(Pari pari, Account account) {
        this.pari = pari;
        this.account = account;
    }

    public void signIn(String username, String password) {

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


    }

    public void timeLine() {

    }

    public void Observe() {

    }

    public void tweet() {
    }

    public void reTweet() {

    }

    public void reply() {

    }


}
