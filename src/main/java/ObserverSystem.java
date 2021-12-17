package src.main.java;

public interface ObserverSystem {
    public abstract void follow(Account user);

    public abstract void unfollow(Account user);

    public abstract boolean isFollowing(Account user);
}
