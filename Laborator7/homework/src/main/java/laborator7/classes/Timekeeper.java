package laborator7.classes;

public class Timekeeper implements Runnable {

    private Game game;

    private long startTime;
    private long maxTime;
    private final long ONE_SECOND = 1000000000;

    public Timekeeper(Game game, long maxSeconds) {
        this.game = game;
        maxTime = maxSeconds;
    }

    @Override
    public void run() {
        startTime = System.nanoTime();
        while (game.getBag().canContinue()) {
            if (System.nanoTime() - startTime > maxTime * ONE_SECOND) {
                System.out.print("\n\nTime's up!\n\n");
                game.getBoard().stopGame();
                return;
            }
        }
    }

    public void getTime() {
        System.out.print("\nTimp: " + (double) (System.nanoTime() - startTime) / ONE_SECOND + " secunde\n");
    }
}
