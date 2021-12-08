package src.main.java;

import java.io.BufferedReader;;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SignIn {
    private Account user;

    public SignIn(Account user) {
        this.user = new Account();
    }

    public void check(String filename) {
        System.out.println("Enter your password and username :");
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        String username = scanner.nextLine();
        if (isCorrect(username, filename)) {
            if (isCorrect(pass, filename)) {
                System.out.println("Signed in");
            } else {
                System.out.println("Your password or username is wrong");
                check(filename);
            }
        } else {
            System.out.println("Your password or username is wrong");
            check(filename);
        }
    }

    public boolean isCorrect(String string, String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((string = bufferedReader.readLine()) != null) {
                if (string.equals(bufferedReader.readLine())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
