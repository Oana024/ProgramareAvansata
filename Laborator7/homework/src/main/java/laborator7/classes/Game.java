package laborator7.classes;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final List<Player> players = new ArrayList<>();
    private final Dictionary dictionary = new MockDictionary();
    public static int currPlayer = 1;
    public static Timekeeper timer;
    public static int numberOfPlayers = 0;

    public void addPlayer(Player player) {
        players.add(player);
        numberOfPlayers ++;
        player.setGame(this);
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void play() {
        timer = new Timekeeper(this, 2);
        Thread timerThread = new Thread(timer);
        timerThread.setDaemon(true);
        timerThread.start();

        for (Player player : players) {
            Thread thread = new Thread(player);
            thread.start();
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

}
