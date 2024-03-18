package pcd.lab02.lost_updates;

public class UnsafeCounter {

	private int cont;
	
	public UnsafeCounter(final int base){
		this.cont = base;
	}
	
	public void inc(){
        this.cont++;
	}
	
	public int getValue(){
		return this.cont;
	}
}
