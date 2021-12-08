package com.company;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;

public class SignUp {
    private Account user;

    public SignUp(Account user) {
        this.user = new Account();
    }

    public void getFullName(String filename) {
        Scanner scanner = new Scanner(System.in);
        String f_name = scanner.nextLine();
        String l_name = scanner.nextLine();
        user.setFirstName(f_name);
        user.setLastName(l_name);

        if (isRepeated(f_name, filename)) {
            System.out.println("Repeated");
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

    public void creatUserName(String filename) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        user.setUsername(username);
        if (isRepeated(username, filename)) {
            System.out.println("Repeated");
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

    public void createPassword(String filename) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        user.setPassword(pass);
        if (isRepeated(pass,filename)) {
            System.out.println("Repeated");
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

    public void writeBio(String filename) {
        Scanner scanner = new Scanner(System.in);
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

    public void dateOfBirth(String filename) {
        Scanner scanner = new Scanner(System.in);
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

    public void dateOfJoin(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(user.getDateOfJoin().toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
