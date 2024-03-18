package pcd.lab04.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {
    private final Semaphore pingDone;
    private final Semaphore pondDone;

    public Pinger(final Semaphore ping, final Semaphore pong) {
        this.pingDone = ping;
        this.pondDone = pong;
    }

    public void run() {
        while (true) {
            try {
                this.pondDone.acquire();
                System.out.println("ping!");
                this.pingDone.release();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}