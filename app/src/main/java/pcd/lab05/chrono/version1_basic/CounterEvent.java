package pcd.lab05.chrono.version1_basic;


public class CounterEvent {
	private final int value;
	public CounterEvent(final int v){
        this.value = v;
	}
	public int getValue(){
		return this.value;
	}
}
