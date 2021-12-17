package src.main.java;

public interface SignIn {
    public abstract void check(String filename);

    public abstract boolean isCorrect(String string, String filename);
}
