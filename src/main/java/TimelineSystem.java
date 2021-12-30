package src.main.java;

/**
 * The interface Timeline system.
 */
public interface TimelineSystem {
    /**
     * Is in timeline boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public abstract boolean isInTimeline(Account user);

    /**
     * Display pari.
     *
     * @param user the user
     */
    public abstract void displayPari(Account user);
}
