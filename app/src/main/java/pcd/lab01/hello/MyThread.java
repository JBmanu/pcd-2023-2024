package pcd.lab01.hello;

public class MyThread extends Thread {

	public MyThread(final String myName){
		super(myName);
	}
	
	public void run(){
        this.log("Hello concurrent world!");
        this.log("Sleeping for 5 secs...");
		try {
			Thread.sleep(5000);
		} catch (final InterruptedException ex) {
			ex.printStackTrace();
		}
        this.log("Done.");
	}
	
	private void log(final String msg) {
		System.out.println("[ " + this.getName()+ " ][ " + System.currentTimeMillis() + " ] " + msg); 
	}
}
