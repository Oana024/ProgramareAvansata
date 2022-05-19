package app;

import Network.User;
import app.SimpleServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

class ClientThread extends Thread {
    private Socket socket = null;
    public User currentUser;
    private Boolean running = true;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            socket.setSoTimeout(60 * 1000);
            while (running) {
                currentUser = SimpleServer.socialNetwork.findUserBySocket(socket);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String request = in.readLine();

                System.out.println("Request: " + request);

                String response = processCommand(request);

                PrintWriter out = new PrintWriter(socket.getOutputStream());

                out.println(response);
                out.flush();
            }

        } catch (SocketTimeoutException e) {
            System.err.println("Utilizatorul a fost prea mult timp inactiv");
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private String processCommand(String message) {
        String[] command = message.trim().toLowerCase().split(" ");
        String response;

        switch (command[0]) {
            case "register":
                response = "Utilizatorul " + command[1] + " a fost inregistrat cu succes";
                SimpleServer.socialNetwork.addUser(new User(command[1]));
                break;
            case "login":
                if (currentUser == null) {
                    if (SimpleServer.socialNetwork.getUser(command[1]) != null) {
                        if (SimpleServer.socialNetwork.getUser(command[1]).getLoggedIn())
                            response = "utilizatorul " + command[1] + " este conectat deja";
                        else {
                            response = "utilizatorul " + command[1] + " s-a logat cu succes!";
                            SimpleServer.socialNetwork.getUser(command[1]).setLoggedIn(true);
                            SimpleServer.socialNetwork.getUser(command[1]).setUserSocket(socket);
                        }
                    } else
                        response = "Utilizatorul " + command[1] + " nu este inregistrat";
                } else
                    response = "Este alt utilizator logat deja";
                break;
            case "friend":
                if (currentUser != null) {
                    for (int i = 1; i < command.length; i++)
                        if (SimpleServer.socialNetwork.getUser(command[i]) != null) {
                            currentUser.addFriend(SimpleServer.socialNetwork.getUser(command[i]));
                        }
                    response = "Prietenii au fost adaugati";
                } else
                    response = "Trebuie sa va autentificati inainte";
                break;
            case "send":
                if (currentUser != null) {
                    response = "Mesajul a fost trimis";
                    String fullMessage = "";
                    for (int i = 1; i < command.length; i++)
                        fullMessage = fullMessage + command[i] + " ";

                    if (!currentUser.getFriends().isEmpty()) {
                        for (User friend : currentUser.getFriends())
                            friend.addMessage(fullMessage);
                    }
                } else
                    response = "Trebuie sa va autentificati inainte";

                break;
            case "stop":
                response = "exit";
                SimpleServer.running = false;
                this.running = false;
                break;
            case "read":
                if (currentUser != null) {
                    if (currentUser.getMessages().isEmpty())
                        response = "Userul nu are mesaje";
                    else {
                        response = "";
                        for (String msg : currentUser.getMessages())
                            response = response + "[" + msg.substring(0, msg.length() - 1) + "]";
                    }
                } else
                    response = "Trebuie sa va autentificati inainte";
                break;
            case "exit":
                response = "exit";
                this.running = false;
                break;
            default:
                response = "Comanda incorecta";
                break;
        }
        return response;
    }
}