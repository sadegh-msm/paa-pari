package src.main.resources;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server application for clients to connect to it.
 */
public class ServerApplication {
    /**
     * Start server.
     *
     * @throws IOException the io exception
     */
    public void startServer() throws IOException {
        // server is listening on port 5056

        ServerSocket serverSocket = new ServerSocket(4000);
        // running infinite loop for getting
        // client request
        while(true) {

            Socket socket = null;
            try {
                // socket object to receive incoming client requests
                socket = serverSocket.accept();
                System.out.println("A new client is connected : " + socket);

                // obtaining input and out streams
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                DataInputStream input = new DataInputStream(socket.getInputStream());


                System.out.println("Assigning new thread for this client");

                Thread t1 = new ClientHandler(socket, input, output);
                //Thread t2 = new ClientHandler(socket, output);
                t1.start();
                //t2.start();
//                class Reader extends Thread{
//                    @Override
//                    public void run(){
//                        while (true){
//
//                        }
//                    }
//                }
//
//                class Writer extends Thread{
//                    @Override
//                    public void run(){
//                        while (true){
//
//                        }
//                    }
//                }
            } catch (Exception e){
                socket.close();
                e.printStackTrace();
            }
        }
    }
}