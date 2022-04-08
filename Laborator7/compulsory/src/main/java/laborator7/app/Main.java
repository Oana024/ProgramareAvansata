package laborator7.app;

import laborator7.classes.Game;
import laborator7.classes.Player;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
