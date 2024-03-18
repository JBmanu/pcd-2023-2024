package pcd.lab04.gui.chrono2_strict;

/**
 * 
 * View designed as a monitor.
 * 
 * @author aricci
 *
 */
public class CounterView {

	private final CounterGUI gui;
	
	public CounterView(final Controller contr, final int initialValue){
        this.gui = new CounterGUI(contr,initialValue);
	}
	
	public synchronized void setCountingState() {
        this.gui.setCountingState();
	}

	public synchronized void setIdleState() {
        this.gui.setIdleState();
	}

	public synchronized void updateCountValue(final int value) {
        this.gui.updateCountValue(value);
	}
	
	public synchronized void display() {
        this.gui.display();
    }
}
