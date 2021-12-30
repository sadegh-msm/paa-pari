package src.main.java;

/**
 * The interface Sign up.
 */
public interface SignUp {
    /**
     * Gets full name.
     *
     * @param filename the filename
     */
    public abstract void getFullName(String filename);

    /**
     * Creat user name.
     *
     * @param filename the filename
     */
    public abstract void creatUserName(String filename);

    /**
     * Create password.
     *
     * @param filename the filename
     */
    public abstract void createPassword(String filename);

    /**
     * Write bio.
     *
     * @param filename the filename
     */
    public abstract void writeBio(String filename);

    /**
     * Date of birth.
     *
     * @param filename the filename
     */
    public abstract void dateOfBirth(String filename);

    /**
     * Date of join.
     *
     * @param filename the filename
     */
    public abstract void dateOfJoin(String filename);

    private boolean isRepeated(String string, String filename){
        return false;
    };
}
