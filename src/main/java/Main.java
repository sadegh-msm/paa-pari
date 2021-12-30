package src.main.java;

import src.main.resources.ServerApplication;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ServerApplication serverApplication = new ServerApplication();
        try {
            serverApplication.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
