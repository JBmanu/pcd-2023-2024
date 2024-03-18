package pcd.lab02.lost_updates;

public class TestLostUpdates {

	public static void main(final String[] args) throws Exception {
		
		final int ntimes = 1000000; // try with different values: 100, 200, 1000, 5000, ...
		
		final UnsafeCounter c = new UnsafeCounter(0);
		final Worker w1 = new Worker("Worker-A", c, ntimes);
		final Worker w2 = new Worker("Worker-B", c, ntimes);

		final Cron cron = new Cron();
		cron.start();
		
		w1.start();
		w2.start();

		w1.join();
		w2.join();
		
		cron.stop();
		
		System.out.println("Counter final value: " + c.getValue() + " in " + cron.getTime()+"ms.");
	}
}
