package pcd.lab04.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {

    final private Semaphore pingDone;
    private final Semaphore pondDone;

    public Ponger(final Semaphore ping, final Semaphore pong) {
        this.pingDone = ping;
        this.pondDone = pong;
    }

    public void run() {
        while (true) {
            try {
                this.pingDone.acquire();
                System.out.println("pong!");
                this.pondDone.release();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}