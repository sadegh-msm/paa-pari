package com.company;

import java.util.Scanner;
import java.time.LocalDate;

public class SignUp {
    private Account user;

    public SignUp(Account user) {
        this.user = new Account();
    }

    public void getFullName(){
        Scanner scanner = new Scanner(System.in);
        String f_name = scanner.nextLine();
        String l_name = scanner.nextLine();
        user.setFirstName(f_name);
        user.setLastName(l_name);
            /*
              if(isRepeated(f_name)){
              sout("Repeated")
          }else{
          write to file
          }
             */
    }

    public void creatUserName(){
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        user.setUsername(username);
        /*
          if(isRepeated(username)){
              sout("Reapeated)
          }else{
          write to file
          }
         */
    }

    public void createPassword(){
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        user.setPassword(pass);
        /*
           if(isRepeated(pass)){
              sout("Reapeated)
          }else{

          write to file
          }
         */
    }

    public void writeBio(){
        Scanner scanner = new Scanner(System.in);
        String bio = scanner.nextLine();
        user.setBiography(bio);
        //then write it to file
    }

    public void dateOfBirth(){
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        user.setDateOfBirth(date);
        //then write to file
    }

    private void isRepeated(String string){  // should return boolean

    }
}
