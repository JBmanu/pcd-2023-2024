package pcd.lab01.hello;

public class Main {

	public static void main(final String[] args) throws Exception {
		
		log("Number of processors: " + Runtime.getRuntime().availableProcessors());
		
		final MyThread myThread = new MyThread("MySimpleThread");
		myThread.start();		
		
		log("Thread spawned.");
		log("Waiting for its termination.");
		
		myThread.join();

		log("Completed.");
		
	}

	private static void log(final String msg) {
		System.out.println("[ " + Thread.currentThread().getName()+ " ][ " + System.currentTimeMillis() + " ] " + msg); 
	}
	
}
