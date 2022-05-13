import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            if(Objects.equals(request, "stop")) {
                SimpleServer.running = false;
                System.out.println("Stopping the server...");
            }

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            System.out.println("Mesaj: " + request);
            String raspuns = "Mesajul primit este: " + request;
            out.println(raspuns);
            out.flush();

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
}