package src.main.java;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;

/**
 * Sign up is used to sign up a client .
 */
public class SignUpImpl implements SignUp {
    private Account user;

    /**
     * Instantiates a new instance
     *
     * @param user the user
     */
    public SignUpImpl(Account user) {
        this.user = new Account();
    }

    /**
     * Gets full name of client.
     *
     * @param filename the filename
     */
    public void getFullName(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your first name");
        String f_name = scanner.nextLine();
        System.out.println("enter your last name");
        String l_name = scanner.nextLine();
        user.setFirstName(f_name);
        user.setLastName(l_name);

        if (isRepeated(f_name, filename)) {
            System.out.println("This user name is not valid");
        } else {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                fileWriter.write(f_name + "\n");
                fileWriter.write(l_name + "\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creat user name for the client.
     *
     * @param filename the filename
     */
    public void creatUserName(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your user name (it have to be unique)");
        String username = scanner.nextLine();
        user.setUsername(username);

        if (isRepeated(username, filename)) {
            System.out.println("This user name is not valid");
            creatUserName(filename);
        } else {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                fileWriter.write(username + "\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create password for account.
     *
     * @param filename the filename
     */
    public void createPassword(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your password");
        String pass = scanner.nextLine();
        user.setPassword(pass);

        if (isRepeated(pass,filename)) {
            System.out.println("This user name is not valid");
            createPassword(filename);
        } else {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                fileWriter.write(user.hash(pass) + "\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Write biography for account.
     *
     * @param filename the filename
     */
    public void writeBio(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter yor biography");
        String bio = scanner.nextLine();
        user.setBiography(bio);

        if (bio.length() <= 256) {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                fileWriter.write(bio + "\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter again!!");
            writeBio(filename);
        }
    }

    /**
     * Date of birth.
     *
     * @param filename the filename
     */
    public void dateOfBirth(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your data of birth (YY/MM/DD)");
        String date = scanner.nextLine();
        user.setDateOfBirth(date);

        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(date + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Date of joining paa-pari.
     *
     * @param filename the filename
     */
    public void dateOfJoin(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            user.setDateOfJoin();
            fileWriter.write(user.getDateOfJoin().toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checks if a username is repeated or not
     *
     * @param string content
     * @param filename name of file
     * @return that is repeated or not
     */
    private boolean isRepeated(String string, String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";

            while ((str = bufferedReader.readLine()) != null){
                if(string.equals(bufferedReader.readLine())){
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}