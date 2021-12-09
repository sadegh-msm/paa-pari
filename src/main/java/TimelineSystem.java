package src.main.java;

/**
 * The type Timeline system.
 */
public class TimelineSystem extends ObserverSystem{
    private Account user;

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
        if (isFollowing(user)){
            return true;
        }
        return false;
    }

    /**
     * Display pari.
     *
     * @param user the user
     */
    public void displayPari(Account user) {
        System.out.println("-|" );
        System.out.println("-|" );
        System.out.println("-|" );
    }

    /**
     * Timeline.
     *
     * @param user the user
     */
    public void timeline(Account user) {
        if (isInTimeline(user)){
            displayPari(user);
        }
    }
}
