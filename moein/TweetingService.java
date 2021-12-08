package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TweetingService extends Tweet {
    private ArrayList<Tweet> tweets;

    public TweetingService() {
        tweets = new ArrayList<>();
    }

    public void writeTweet(String filename) {
        Tweet tweet = new Tweet();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        tweet.setContent(str);
        tweets.add(tweet);
        writeToFile(tweets, tweets.indexOf(tweet), true,filename);
    }

    public void removeTweet(String filename, int index) {
        Iterator<Tweet> iterator = tweets.iterator();
        while (iterator.hasNext()) {
            if (correctIndex(index)) {
                tweets.remove(index);
                writeToFile(tweets, index, false,filename);
            } else {
                System.out.println("Wrong index");
                removeTweet(filename, index);
            }
        }
    }

    public void writeToFile(ArrayList<Tweet> messages, int index, boolean bool, String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename, bool);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (correctIndex(index)) {
                bufferedWriter.write(messages.get(index).getContent());
                bufferedWriter.close();
                fileWriter.close();
            } else {
                System.out.println("Wrong index");
                writeToFile(messages, index, bool, filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean correctIndex(int index) {
        if (index < tweets.size()) {
            System.out.println("Out of Bound");
            return false;
        }
        return true;
    }

}
