package src.main.java;

import java.time.LocalDate;
import java.util.*;

/**
 * The type Timeline system.
 */
public class TimelineSystemImpl extends ObserverSystemImpl implements TimelineSystem {
    private Account user;
    private Pari pari;
    private HashMap<LocalDate, String> par_pari = new HashMap<>();

    /**
     * Instantiates a new Timeline system.
     */
    public TimelineSystemImpl() {
        this.user = new Account();
        this.pari = new Pari();
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
            for(int i = 0; i < contents.size(); i++){
                par_pari.put(pari.getContents().get(i).getLocalDateOfPari(), pari.getContents().get(i).getContent());
            }
            ArrayList<LocalDate> sortedDates = new ArrayList<>(par_pari.keySet());
            Collections.sort(sortedDates);
            for(LocalDate localDate : sortedDates){
                System.out.println(localDate + " :");
                System.out.println(par_pari.get(localDate));
            }
        }
    }

}
