package producerconsumer;

import java.util.Random;

public class Bebè implements Runnable {
    private final Piatto piatto;
    private final Random random;

    public Bebè(Piatto piatto) {
        this.piatto = piatto;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                piatto.rimuoviBoccone();
                Thread.sleep(1000 + random.nextInt(1001)); //implementa il random
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
