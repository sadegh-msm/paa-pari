package src.main.java;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;
/**
 * The type Timeline system.
 */
public class TimelineSystem extends ObserverSystem {
    private Account user;
    private ArrayList<Pari> paris;
    private HashMap<Pari, LocalDate> par_pari = new HashMap<Pari,LocalDate>();

    /**
     * Instantiates a new Timeline system.
     */
    public TimelineSystem() {
        this.user = new Account();
    }

    /**
     * Is in timeline boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean isInTimeline(Account user) {
        return isFollowing(user);
    }

    /**
     * Display pari.
     *
     * @param user the user
     */
    public void displayPari(Account user, Pari tweet) {
        if (isInTimeline(user)) {
            par_pari.put(tweet,tweet.getLocalDate());
            List<Map.Entry<Pari,LocalDate>> list = new LinkedList<Map.Entry<Pari, LocalDate>>(par_pari.entrySet());

        }
    }


}
