package src.main.java;

import java.io.File;
import java.util.ArrayList;

/**
 * The type Observer system that about users following and unfollowing.
 */
public class ObserverSystemImpl extends Pari implements ObserverSystem {
    private ArrayList<Account> followedUsers;

    /**
     * Instantiates a new Observer system.
     */
    public ObserverSystemImpl() {
        this.followedUsers = new ArrayList<>();
    }

    /**
     * Follow a user.
     *
     * @param user the user
     */
    public void follow(Account user) {
        File directoryPath = new File("E:\\GitHub\\paa-pari\\files\\model\\users\\UsersInfo.txt");
        if (user.isValid(user.getUsername(), directoryPath.getPath())) {
            followedUsers.add(user);
        } else {
            System.out.println("this user doesnt exist");
            follow(user);
        }
    }

    /**
     * Unfollow a user.
     *
     * @param user the user
     */
    public void unfollow(Account user) {
        if (followedUsers.contains(user)) {
            followedUsers.remove(user);
        } else {
            System.out.println("this user doesnt exist");
            unfollow(user);
        }
    }

    /**
     * Is following boolean to show if a user follows other user or not.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean isFollowing(Account user) {
        if (followedUsers.contains(user)) {
            return true;
        }
        System.out.println("you dont have this user in your following list");
        isFollowing(user);

        return false;
    }
}
