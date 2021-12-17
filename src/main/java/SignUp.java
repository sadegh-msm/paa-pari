package src.main.java;

public interface SignUp {
    public abstract void getFullName(String filename);

    public abstract void creatUserName(String filename);

    public abstract void createPassword(String filename);

    public abstract void writeBio(String filename);

    public abstract void dateOfBirth(String filename);

    public abstract void dateOfJoin(String filename);

    private boolean isRepeated(String string, String filename){
        return false;
    };
}
