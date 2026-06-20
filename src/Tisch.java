//Der Tisch übernimmt die zentrale Koordination:

//Ein Agent darf nur dann Zutaten ablegen, wenn der Tisch leer ist
//Ein Smoker darf nur dann reagieren, wenn die Zutaten zu ihm passen

//Falls diese Bedingungen nicht erfüllt sind, wird der Thread mit wait() blockiert.
public class Tisch {

    private Zutaten zutat1;
    private Zutaten zutat2;
    private boolean istBelegt = false;

    // Agent legt Zutaten
    public synchronized void lege(Zutaten a, Zutaten b) throws InterruptedException {
        while (istBelegt) {
            wait();
        }
        zutat1 = a;
        zutat2 = b;
        istBelegt = true;
        System.out.println("Agent legt: " + a + " + " + b);
        notifyAll();
    }

    // Smoker versucht zu nehmen
    public synchronized void nehme(Zutaten meineZutat) throws InterruptedException {
        while (!istBelegt ||
                (zutat1 == meineZutat || zutat2 == meineZutat)) {
            wait();
        }
        // richtiger Smoker
        System.out.println("Smoker mit " + meineZutat + " raucht");
        istBelegt = false;
        notifyAll();
    }
}