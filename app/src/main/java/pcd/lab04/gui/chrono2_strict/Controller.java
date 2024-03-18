package pcd.lab04.gui.chrono2_strict;

/**
 * 
 * Passive controller part, designed as a monitor.
 * 
 * @author aricci
 *
 */
public class Controller {

	private static final int DELTA_TIME = 10;
	private final Flag stopFlag;
	private CounterAgent agent;
	private final Counter counter;
	private CounterView view;
	
	public Controller(final Counter counter) {
		this.counter = counter;
		this.stopFlag = new Flag();
	}
	
	public synchronized void setView(final CounterView view) {
		this.view = view;
	}
	
	public synchronized void notifyStarted() {
        this.agent = new CounterAgent(this.counter, this.stopFlag, this.view, DELTA_TIME);
        this.agent.start();
	}
	
	public synchronized void notifyStopped() {
        this.stopFlag.set();
	}

	public synchronized void notifyReset() {
        this.counter.reset();
        this.view.updateCountValue(this.counter.getValue());
	}
}
