package pcd.lab05.chrono.version1_basic;

public class Flag {

	private boolean flag;
	
	public synchronized void reset() {
        this.flag = false;
	}
	
	public synchronized void set() {
        this.flag = true;
	}
	
	public synchronized boolean isSet() {
		return this.flag;
	}
}