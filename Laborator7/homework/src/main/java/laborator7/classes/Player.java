package laborator7.classes;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private int index;
    private Game game;
    private static boolean running = true;
    private int totalPoints;
    private List<Tile> extracted;
    private boolean first = true;

    public void addPoints(int points) {
        totalPoints += points;
    }

    public int getPoints() {
        return totalPoints;
    }

    public Player(String name, int index) {
        this.name = name;
        this.index = index;
        totalPoints = 0;
    }

    private boolean createWord() {
        if (first) {
            extracted = game.getBag().extractTiles(7);
            first = false;
        } else {
            if (extracted.size() == 0)
                extracted = game.getBag().extractTiles(7);
            else
                extracted.addAll(game.getBag().extractTiles(7 - extracted.size()));
        }

        List<Tile> copyOfExtracted = new ArrayList<>();
        Tile usedTile = null;
        StringBuilder buildWord = new StringBuilder();

        if (extracted.isEmpty()) {
            return false;
        }

        for (Tile tile : extracted) {
            buildWord.append(tile.getLetter());
        }
        String word = buildWord.toString();

        WordGenerator generator = new WordGenerator();
        List<String> possibleWords = generator.search(game.getDictionary(), word);

        int ok = 1, points = 0, maxpoints = 0;
        String bestWord = null;

        for (String s : possibleWords) {
            points = 0;
            for (char c : s.toCharArray()) {
                for (Tile tile : extracted) {
                    if (tile.getLetter() == c) {
                        points += tile.getPoints();
                        break;
                    }
                }
            }
            if (points > maxpoints) {
                maxpoints = points;
                bestWord = s;
            }
        }

        if (bestWord == null) {
            game.getBag().addTiles(extracted);
            extracted.clear();
        } else {
            game.getBoard().addWord(this, bestWord, maxpoints);
            copyOfExtracted.addAll(extracted);

            for (char c : bestWord.toCharArray()) {
                ok = 0;
                usedTile = null;
                for (Tile tile : extracted)
                    if (tile.getLetter() == c) {
                        ok = 1;
                        usedTile = tile;
                        break;
                    }
                if (ok == 1)
                    extracted.remove(usedTile);
            }
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void run() {
        game.getBoard().nr++;
        while (running) {
            game.getBoard().waitTurn(index);
            running = createWord();
            game.getBoard().nextPlayer();
        }
        //System.out.println(name + " a terminat");
        game.getBoard().verify(index);
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
