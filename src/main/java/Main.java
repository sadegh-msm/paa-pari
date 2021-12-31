package src.main.java;

import src.main.resources.ClientApplication;
import src.main.resources.ServerApplication;

import java.io.IOException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ServerApplication serverApplication = new ServerApplication();
        try {
            serverApplication.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
