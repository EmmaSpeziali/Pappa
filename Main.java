package producerconsumer;

public class Main {
    public static void main(String[] args) {
        int maxSize = 10; 
        Piatto piatto = new Piatto(maxSize);

        Thread papà = new Thread(new Papà(piatto));
        Thread bebè = new Thread(new Bebè(piatto));

        papà.start();
        bebè.start();
    }
}