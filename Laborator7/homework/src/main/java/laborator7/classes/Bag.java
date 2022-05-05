package laborator7.classes;

import java.util.*;

public class Bag {
    private final Queue<Tile> tiles = new LinkedList<>();
    public static List<String> generatedWords = new ArrayList<>();

    public Bag() {

        for (int i = 0; i < 1; i++) {
            tiles.add(new Tile('j', 8));
            tiles.add(new Tile('k', 5));
            tiles.add(new Tile('q', 10));
            tiles.add(new Tile('x', 8));
            tiles.add(new Tile('z', 10));
        }

        for (int i = 0; i < 2; i++) {
            tiles.add(new Tile('b', 3));
            tiles.add(new Tile('c', 3));
            tiles.add(new Tile('f', 4));
            tiles.add(new Tile('h', 4));
            tiles.add(new Tile('m', 3));
            tiles.add(new Tile('p', 3));
            tiles.add(new Tile('v', 4));
            tiles.add(new Tile('w', 4));
            tiles.add(new Tile('y', 4));
        }

        for (int i = 0; i < 3; i++)
            tiles.add(new Tile('g', 2));


        for (int i = 0; i < 4; i++) {
            tiles.add(new Tile('d', 2));
            tiles.add(new Tile('l', 1));
            tiles.add(new Tile('s', 1));
            tiles.add(new Tile('u', 1));
        }

        for (int i = 0; i < 6; i++) {
            tiles.add(new Tile('t', 1));
            tiles.add(new Tile('r', 1));
            tiles.add(new Tile('n', 1));
        }

        for (int i = 0; i < 8; i++)
            tiles.add(new Tile('o', 1));

        for (int i = 0; i < 9; i++) {
            tiles.add(new Tile('a', 1));
            tiles.add(new Tile('i', 1));
        }

        for (int i = 0; i < 12; i++)
            tiles.add(new Tile('e', 1));

        Collections.shuffle((List<?>) tiles);

        StringBuilder buildWord = new StringBuilder();

        for (Tile tile : tiles) {
            buildWord.append(tile.getLetter());
        }
        String word = buildWord.toString();

        Dictionary dictionary = new MockDictionary();
        WordGenerator generator = new WordGenerator();
        generatedWords = generator.search(dictionary, word);
    }

    public void addTiles(List<Tile> remTiles) {
        tiles.addAll(remTiles);
        Collections.shuffle((List<?>) tiles);
    }

    public boolean canContinue() {
        return generatedWords.size() > 0;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        StringBuilder buildWord = new StringBuilder();

        for (Tile tile : tiles) {
            buildWord.append(tile.getLetter());
        }
        String word = buildWord.toString();

        Dictionary dictionary = new MockDictionary();
        WordGenerator generator = new WordGenerator();
        generatedWords = generator.search(dictionary, word);

        if (canContinue()) {
            for (int i = 0; i < howMany; i++) {
                if (tiles.isEmpty()) {
                    break;
                }
                extracted.add(tiles.poll());
            }
        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return extracted;
    }

    public Queue<Tile> getTiles() {
        return tiles;
    }
}
