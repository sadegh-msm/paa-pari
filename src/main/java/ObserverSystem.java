package src.main.java;

/**
 * The interface Observer system.
 */
public interface ObserverSystem {
    /**
     * Follow.
     *
     * @param user the user
     */
    public abstract void follow(Account user);

    /**
     * Unfollow.
     *
     * @param user the user
     */
    public abstract void unfollow(Account user);

    /**
     * Is following boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public abstract boolean isFollowing(Account user);
}
