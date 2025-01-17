
import java.util.LinkedList;
import java.util.Queue;

public class Piatto {
    private final Queue<String> piatto = new LinkedList<>();
    private final int CAPACITÀ_MAX = 10;

    public synchronized void aggiungiBoccone(String boccone) throws InterruptedException {
        while (piatto.size() == CAPACITÀ_MAX) {
            wait();
        }
        piatto.add(boccone);
        System.out.println("Papà ha preparato: " + boccone);
        notifyAll();
    }

    public synchronized String rimuoviBoccone() throws InterruptedException {
        while (piatto.isEmpty()) {
            wait();
        }
        String boccone = piatto.poll();
        System.out.println("Bebè ha mangiato: " + boccone);
        notifyAll();
        return boccone;
}
}