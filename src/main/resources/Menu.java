package src.main.resources;


import src.main.java.Account;
import src.main.java.Pari;

import java.io.*;
import java.util.Scanner;


public class Menu {
    private Pari pari;
    private Account account;

    public Menu(Pari pari, Account account) {
        this.pari = pari;
        this.account = account;
    }

    public void signIn(String username, String password) {
        System.out.println("Login in.......");
        if(readFromFile(username,password)){
            System.out.println("Logged in successfully");
        }else{
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
