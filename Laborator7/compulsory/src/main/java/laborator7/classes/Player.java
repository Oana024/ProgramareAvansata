package laborator7.classes;

import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        StringBuilder buildWord = new StringBuilder();

        if (extracted.isEmpty()) {
            return false;
        }

        for (Tile tile : extracted)
            buildWord.append(tile.getLetter());

        String word = buildWord.toString();

        game.getBoard().addWord(this, word);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void run() {
        do {
            running = submitWord();
        } while (running);
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
