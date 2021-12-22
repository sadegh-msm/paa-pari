package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;

/**
 * The type Account creates an account for client and saves the information from client
 */
public class Account extends Pari{
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String DateOfBirth;
    private LocalDate DateOfJoin;
    private String biography;


    /**
     * Instantiates a new Account.
     */
    public Account() {
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get sha byte for accounts password .
     *
     * @param pass the pass
     * @return the byte [ ]
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static byte[] getSHA(String pass) throws NoSuchAlgorithmException {
        // // Static getInstance method is called with hashing SHA
        MessageDigest messageDigest = MessageDigest.getInstance("SHA_256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return messageDigest.digest(pass.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * convert hash to hex string for account password
     *
     * @param hash the hash
     * @return the string
     */
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

    /**
     * Hash string.
     *
     * @param password the password
     * @return the string
     */
    public String hash(String password) {
        String s = null;
        try {
            s = toHexString(getSHA(password));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return s;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    /**
     * Gets date of join.
     *
     * @return the date of join
     */
    public LocalDate getDateOfJoin() {
        return DateOfJoin;
    }

    /**
     * Sets date of join.
     */
    public void setDateOfJoin() {
        DateOfJoin = LocalDate.now();
    }

    /**
     * Gets biography.
     *
     * @return the biography
     */
    public String getBiography() {
        return biography;
    }

    /**
     * Sets biography.
     *
     * @param biography the biography
     */
    public boolean setBiography(String biography) {
        if (biography.length() <= 256) {
            this.biography = biography;
            return true;
        } else {
            System.out.println("Out of Bound please enter again!");
             return false;
        }
    }

    /**
     * Is valid to check if user is valid or not.
     *
     * @param username the username
     * @param fileName the file name
     * @return the boolean
     */
    public boolean isValid(String username, String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";

            while ((str = bufferedReader.readLine()) != null){
                if(username.equals(bufferedReader.readLine())){
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
