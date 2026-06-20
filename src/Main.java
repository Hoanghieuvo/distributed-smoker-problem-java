public class Main {

    public static void main(String[] args) {

        Tisch tisch = new Tisch();

        Agent a1 = new Agent("Agent-1", tisch);
        Agent a2 = new Agent("Agent-2", tisch);

        Smoker s1 = new Smoker("Smoker-Tabak", tisch, Zutaten.TABAK);
        Smoker s2 = new Smoker("Smoker-Papier", tisch, Zutaten.PAPIER);
        Smoker s3 = new Smoker("Smoker-Streichholz", tisch, Zutaten.STREICHHOLZER);

        a1.start();
        a2.start();
        s1.start();
        s2.start();
        s3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        a1.interrupt();
        a2.interrupt();
        s1.interrupt();
        s2.interrupt();
        s3.interrupt();

        System.out.println("---- ENDE ----");
    }
}
