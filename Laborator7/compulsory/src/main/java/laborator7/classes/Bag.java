package laborator7.classes;

import java.util.*;

public class Bag {
    private final Queue<Tile> tiles = new LinkedList<>();

    public Bag() {
        Random rand = new Random();

        List<Character> alphabet = new ArrayList<>();//salvez alfabetul
        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.add(letter);
        }

        //scot 100 de litere random din alfabet
        for (int i = 0; i < 100; i++)
            tiles.add(new Tile(alphabet.get(rand.nextInt(alphabet.size())), rand.nextInt(10) + 1));
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.poll());
        }
        return extracted;
    }

    public Queue<Tile> getTiles() {
        return tiles;
    }
}
