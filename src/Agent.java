import java.util.Random;

public class Agent extends Thread {

    private Tisch tisch;
    private Random rand = new Random();

    public Agent(String name, Tisch tisch) {
        setName(name);
        this.tisch = tisch;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                Zutaten[] z = Zutaten.values();

                Zutaten a = z[rand.nextInt(3)];
                Zutaten b;
                do {
                    b = z[rand.nextInt(3)];
                } while (a == b); // zwei unterschiedliche Zutaten
                tisch.lege(a, b);
            }
        } catch (InterruptedException e) {
            // Thread beendet
        }
        System.out.println(getName() + " beendet");
    }
}