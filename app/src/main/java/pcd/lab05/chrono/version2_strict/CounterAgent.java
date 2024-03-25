package pcd.lab05.chrono.version2_strict;

/**
 * Active component doing counting. 
 * 
 * @author aricci
 *
 */
public class CounterAgent extends Thread {

	private final Counter counter;
	private final Flag stopFlag;
	private final long delta;
	private final CounterView view;
	
	public CounterAgent(final Counter c, final Flag stopFlag, final CounterView view, final long delta){
        this.counter = c;
		this.stopFlag = stopFlag;
		this.delta = delta;
		this.view = view;
	}
	public void run(){
        this.stopFlag.reset();
        this.view.setCountingState();
		while (!this.stopFlag.isSet()){
            this.counter.inc();
            this.view.updateCountValue(this.counter.getValue());
			System.out.println(this.counter.getValue());
			try {
				Thread.sleep(this.delta);
			} catch(final Exception ex){
			}
		}
	}
}
