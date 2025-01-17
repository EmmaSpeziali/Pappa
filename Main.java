package producerconsumer;

public class Main {
    public static void main(String[] args) {
        Piatto piatto = new Piatto();

        Thread papà = new Thread(new Papà(piatto));
        Thread bebè = new Thread(new Bebè(piatto));

        papà.start();
        bebè.start();
    }
}