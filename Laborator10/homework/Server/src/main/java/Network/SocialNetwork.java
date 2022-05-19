package Network;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    List<User> network;

    public SocialNetwork() {
        network = new ArrayList<>();
    }

    public List<User> getNetwork() {
        return network;
    }

    public void addUser(User user) {
        network.add(user);
    }

    public User getUser(String name) {
        return (User) network.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public User findUserBySocket(Socket socket) {
        return (User) network.stream().filter(user -> user.getUserSocket().equals(socket)).findFirst().orElse(null);
    }
}
