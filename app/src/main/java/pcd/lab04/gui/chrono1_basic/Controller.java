package pcd.lab04.gui.chrono1_basic;

public class Controller {

	private static final int DELTA_TIME = 10;
	private final Flag stopFlag;
	private CounterAgent agent;
	private final Counter counter;
	
	public Controller(final Counter counter) {
		this.counter = counter;
		this.stopFlag = new Flag();
	}
	
	public void notifyStarted() {
        this.agent = new CounterAgent(this.counter, this.stopFlag, DELTA_TIME);
        this.agent.start();
	}
	
	public void notifyStopped() {
        this.stopFlag.set();
	}

	public void notifyReset() {
        this.counter.reset();
        this.stopFlag.reset();
	}
}
