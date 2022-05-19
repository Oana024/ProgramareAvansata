package app;

import Network.SocialNetwork;
import Network.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SimpleServer {
    public static final int PORT = 8100;
    public static Boolean running = true;
    public static SocialNetwork socialNetwork = new SocialNetwork();

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                serverSocket.setSoTimeout(1000);
                try {
                    Socket socket = serverSocket.accept();
                    new ClientThread(socket).start();
                } catch (SocketTimeoutException e) {
                    // System.err.println("acceptam un nou client");
                }
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }

}