package src.main.java;

import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;

public class Account {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String DateOfBirth;
    private LocalDate DateOfJoin;
    private String biography;



    public Account() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static byte[] getSHA(String pass) throws NoSuchAlgorithmException {
        // // Static getInstance method is called with hashing SHA
        MessageDigest messageDigest = MessageDigest.getInstance("SHA_256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return messageDigest.digest(pass.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger num = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(num.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public String hash(String password) {
        String s = null;
        try {
            s = toHexString(getSHA(password));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return s;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfJoin() {
        return DateOfJoin;
    }

    public void setDateOfJoin() {
        DateOfJoin = LocalDate.now();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        if (biography.length() <= 256) {
            this.biography = biography;
        } else {
            System.out.println("Out of Bound please enter again!");
            setBiography(biography);
        }
    }

}

