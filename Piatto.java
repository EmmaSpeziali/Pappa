package producerconsumer;

import java.util.ArrayList;

public class Piatto {
    private final ArrayList<String> listaBocconi;
    private final int maxSize;

    public Piatto(int maxSize) {
        this.listaBocconi = new ArrayList<>();
        this.maxSize = maxSize;
    }
//questo agg boccone
    public synchronized void aggiungiBoccone(String boccone) throws InterruptedException {
        while (listaBocconi.size() >= maxSize) {
            System.out.println("Piatto pieno. Il papà attende.");
            wait();
        }
        listaBocconi.add(boccone);
        System.out.println("Papà ha preparato: " + boccone);
        notifyAll(); 
    }

    // toglie boccone
    public synchronized String rimuoviBoccone() throws InterruptedException {
        while (listaBocconi.isEmpty()) {
            System.out.println("Piatto vuoto. Il bebè attende.");
            wait();
        }
        String boccone = listaBocconi.remove(0); 
        System.out.println("Bebè ha mangiato: " + boccone);
        notifyAll(); 
        return boccone;
    }
}
