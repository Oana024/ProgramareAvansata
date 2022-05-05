package laborator7.app;

import laborator7.classes.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player 1", 1));
        game.addPlayer(new Player("Player 2", 2));
        game.addPlayer(new Player("Player 3", 3));
      //  game.addPlayer(new Player("Player 4", 4));
        game.play();
    }
}
