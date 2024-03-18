package pcd.lab04.sem.ex;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(final String[] args) {
		// non è un mutex è un semaforo
		// non centra semaforo weak o strong
		final Semaphore pingDone = new Semaphore(0);
		final Semaphore pongDone = new Semaphore(0);

		new Pinger(pingDone, pongDone).start();
		new Ponger(pingDone, pongDone).start();

		System.out.println("INIT");
		pongDone.release();

		// cosi usiamo un solo semaforo
		// done lo puo scrivere solo una volta
		// vogliamo un totale farness
	}

}
