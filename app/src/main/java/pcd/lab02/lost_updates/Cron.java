package pcd.lab02.lost_updates;

public class Cron {

	private boolean running;
	private long startTime;

	public Cron(){
		running = false;
	}
	
	public void start(){
		running = true;
		startTime = System.currentTimeMillis();
	}
	
	public void stop(){
		startTime = getTime();
        this.running = false;
	}
	
	public long getTime(){
		if (this.running){
			return 	System.currentTimeMillis() - this.startTime;
		} else {
			return this.startTime;
		}
	}
}
