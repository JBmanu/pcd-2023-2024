package pcd.lab01.ex01.sol;

public class AbstractWorker extends Thread {
		
	public AbstractWorker(final String name){
		super(name);
		
	}
	
	protected void log(final String msg) {
		System.out.println("[ " + this.getName()+ " ][ " + System.currentTimeMillis() + " ] " + msg); 
	}
	

}
