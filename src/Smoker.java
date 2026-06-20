import java.util.Random;

public class Smoker extends Thread {

    private Tisch tisch;
    private Zutaten meineZutat;
    private Random rand = new Random();

    public Smoker(String name, Tisch tisch, Zutaten zutat) {
        setName(name);
        this.tisch = tisch;
        this.meineZutat = zutat;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                tisch.nehme(meineZutat);
                rauchen();
                System.out.println(getName() + " fertig");
            }
        } catch (InterruptedException e) {
            interrupt();
        }

        System.out.println(getName() + " beendet");
    }

    private void rauchen() throws InterruptedException {
        Thread.sleep(rand.nextInt(200));
    }
}