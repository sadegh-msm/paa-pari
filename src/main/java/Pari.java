package src.main.java;


import java.time.LocalDate;
import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * The type Pari.
 */
public class Pari extends PariService {
    private int likes;
    private int retweetCount;
    private String content;
    private LocalDate localDate;
    private Account user;
    /**
     * The Contents.
     */
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

    /**
     * All contents array list.
     *
     * @return the array list
     */
    public ArrayList<Pari> getContents() {
        return contents;
    }

    /**
     * Add content.
     *
     * @param content the content
     */
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
     * Gets retweet count.
     *
     * @return the retweet count
     */
    public int getRetweetCount() {
        return retweetCount;
    }

    /**
     * Sets retweet count.
     *
     * @param retweetCount the retweet count
     */
    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    /**
     * Author string.
     *
     * @return the user's name
     */
    public String Author() {
        return user.getUsername();
    }
}
