package pcd.lab04.sem;

import java.util.concurrent.Semaphore;

public class TestCSWithSem {

	public static void main(final String[] args) {
		final Semaphore mutex = new Semaphore(1,true);
		new MyWorkerA("MyAgent-01", mutex).start();		
		new MyWorkerB("MyAgent-02", mutex).start();
		new MyWorkerC("MyAgent-03", mutex).start();
	}

}
