package pcd.lab04.gui.chrono1_basic;

public class CounterAgent extends Thread {

	private final Counter counter;
	private final Flag stopFlag;
	private final long delta;
	
	public CounterAgent(final Counter c, final Flag stopFlag, final long delta){
        this.counter = c;
		this.stopFlag = stopFlag;
		this.delta = delta;
	}
	public void run(){
        this.stopFlag.reset();
		while (!this.stopFlag.isSet()){
            this.counter.inc();
			System.out.println(this.counter.getValue());
			try {
				Thread.sleep(this.delta);
			} catch(final Exception ex){
			}
		}
	}
}
