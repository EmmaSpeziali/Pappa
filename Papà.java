package producerconsumer;

import java.util.Random;

public class Papà implements Runnable {
    private final Piatto piatto;
    private final Random random;

    public Papà(Piatto piatto) {
        this.piatto = piatto;
        this.random = new Random();
    }

    @Override
    public void run() {
        int contatore = 0;
        try {
            while (true) {
                String boccone = "Boccone " + (++contatore);
                piatto.aggiungiBoccone(boccone);
                Thread.sleep(500 + random.nextInt(501)); // implemento il random
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
