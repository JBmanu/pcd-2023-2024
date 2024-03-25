package pcd.lab05.chrono.version2_strict;

/**
 * Model designed as a monitor.
 * 
 * @author aricci
 *
 */
public class Counter {
	
	private int cont;
	private final int base;
	
	public Counter(final int base){
		this.cont = base;
		this.base = base;
	}
	
	public synchronized void inc(){
        this.cont++;
		System.out.println("count "+ this.cont);
	}
	
	public synchronized void reset(){
        this.cont = this.base;
	}
	
	public synchronized int getValue(){
		return this.cont;
	}
}
