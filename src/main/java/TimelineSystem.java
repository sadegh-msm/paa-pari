package src.main.java;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;
/**
 * The type Timeline system.
 */
public class TimelineSystem extends ObserverSystem {
    private Account user;
    private HashMap<LocalDate, String> par_pari = new HashMap<>();

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
    public void displayPari(Account user) {
        if (isInTimeline(user)) {
            par_pari.put(user.getLocalDateOfPari(), user.getContent());
            ArrayList<LocalDate> sortedDates = new ArrayList<>(par_pari.keySet());
            Collections.sort(sortedDates);
            for(LocalDate localDate : sortedDates){
                System.out.println(localDate + " :");
                System.out.println(par_pari.get(localDate));
            }
        }
    }


}
