package laborator7.classes;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int nr = 0;
    private final List<String> words = new ArrayList<>();
    private static int maxPoints;
    private Player winner;
    private boolean[] isPlaying = new boolean[100];
    private boolean runningGame = true;

    public synchronized void addWord(Player player, String word, Integer points) {
        if(runningGame) {
            words.add(word);
            System.out.println(player.getName() + ": " + word + "  +" + points);
            player.addPoints(points);
            if (player.getPoints() > maxPoints) {
                maxPoints = player.getPoints();
                winner = player;
            }
        }
    }

    public synchronized void nextPlayer() {
        do {
            Game.currPlayer = (Game.currPlayer % Game.numberOfPlayers) + 1;
        } while (!isPlaying[Game.currPlayer - 1]);
        notifyAll();
    }

    public synchronized void waitTurn(int index) {
        while (index != Game.currPlayer && isPlaying[index - 1] && runningGame) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void verify(int indexPlayer) {
        nr--;
        isPlaying[indexPlayer - 1] = false;
        while (!isPlaying[Game.currPlayer - 1] && nr > 0)
            Game.currPlayer = (Game.currPlayer % Game.numberOfPlayers) + 1;
        if (nr == 0) {
            System.out.println(winner.getName() + " a castigat cu " + winner.getPoints() + " puncte");
            runningGame = false;
            Game.timer.getTime();
        }
    }

    public synchronized void stopGame() {
        runningGame = false;
    }

    public Board() {
        for (int i = 0; i < 100; i++)
            isPlaying[i] = true;
    }

    public boolean isRunningGame() {
        return runningGame;
    }

    public Player getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Board{" +
                "words=" + words +
                '}';
    }
}
