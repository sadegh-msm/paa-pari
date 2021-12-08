package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * signIn class for singing in a client to his account
 */
public class SignIn {
    private Account user;

    /**
     * constructor
     *
     * @param user the user
     */
    public SignIn(Account user) {
        this.user = new Account();
    }

    /**
     * Checks the user name and password that client gives to login
     *
     * @param filename the filename
     */
    public void check(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your user name");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String pass = scanner.nextLine();

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

    /**
     * checks that information matches or not
     *
     * @param string   the string
     * @param filename the filename
     * @return the boolean
     */
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
