package src.main.java;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Pari.
 */
public class Pari {
    private Account user;
    private int likes;
    private String content;
    private LocalDate localDate;
    protected ArrayList<Pari> contents;

    /**
     * Instantiates a new Pari.
     */
    public Pari() {
        user = new Account();
        contents = new ArrayList<>();
    }

    /**
     * Gets likes for that pari.
     *
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Sets likes for the pari.
     *
     * @param likes the likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Gets content for the pari.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content for pari.
     *
     * @param content the content
     */
    public void setContent(String content) {
        if (content.length() <= 256) {
            this.content = content;
        } else {
            System.out.println("Your content is more than 256 characters Enter again");
            setContent(content);
        }
    }
    public ArrayList<Pari> allContents(ArrayList<Pari> messages){
        return messages;
    }

    public void addContent(Pari content) {
        contents.add(content);
    }

    /**
     * Gets local date to get when pari is created.
     *
     * @return the local date
     */
    public LocalDate getLocalDateOfPari() {
        return localDate;
    }

    /**
     * Sets local date to set when pari is created.
     */
    public void setLocalDateOfPari() {
        this.localDate = LocalDate.now();
    }

    /**
     * Sets all.
     *
     * @param content the content
     */
    public void setAll(String content) {
        setContent(content);
        setLocalDateOfPari();
        setLikes(0);
    }

    /**
     * Get writer of a pari.
     *
     * @return the string
     */
    public String getWriter() {
        return user.getUsername();
    }
}
