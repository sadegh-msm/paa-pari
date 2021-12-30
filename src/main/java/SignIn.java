package src.main.java;

/**
 * The interface Sign in.
 */
public interface SignIn {
    /**
     * Check.
     *
     * @param filename the filename
     */
    public abstract void check(String filename);

    /**
     * Is correct boolean.
     *
     * @param string   the string
     * @param filename the filename
     * @return the boolean
     */
    public abstract boolean isCorrect(String string, String filename);
}
