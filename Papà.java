package producerconsumer;

public class Papà implements Runnable {
    private final Piatto piatto;

    public Papà(Piatto piatto) {
        this.piatto = piatto;
    }

    @Override
    public void run() {
        int contatore = 0;
        try {
            while (true) {
                piatto.aggiungiBoccone("Boccone " + (++contatore));
                Thread.sleep(500); // Simula il tempo necessario per preparare un boccone
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}