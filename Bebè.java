package producerconsumer;

public class Bebè implements Runnable {
    private final Piatto piatto;

    public Bebè(Piatto piatto) {
        this.piatto = piatto;
    }

    @Override
    public void run() {
        try {
            while (true) {
                piatto.rimuoviBoccone();
                Thread.sleep(1000); // Simula il tempo necessario per mangiare un boccone
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}