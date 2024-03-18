package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private final UnsafeCounter counter;
	private final int ntimes;
	
	public Worker(final String name, final UnsafeCounter counter, final int ntimes){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
	}
	
	public void run(){
        this.log("started");
		for (int i = 0; i < this.ntimes; i++){
            this.counter.inc();
		}
        this.log("completed");
	}
	
	private void log(final String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}
