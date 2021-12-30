package src.main.java;

/**
 * The interface Replying system.
 */
public interface ReplyingSystem {
    /**
     * Reply on pari.
     *
     * @param repliedOn the replied on
     */
    public abstract void replyOnPari(Pari repliedOn);

    /**
     * Print replied.
     */
    public abstract void printReplied();
}
