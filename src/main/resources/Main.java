package src.main.resources;

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
