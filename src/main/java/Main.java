package src.main.java;

import src.main.resources.ClientApplication;
import src.main.resources.ServerApplication;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ServerApplication serverApplication = new ServerApplication();
        ClientApplication clientApplication = new ClientApplication();
        try {
            serverApplication.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientApplication.StartClient();
    }
}
