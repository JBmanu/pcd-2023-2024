package pcd.lab03.liveness.deadlock_obs;

import java.util.ArrayList;
import java.util.List;

public class MyObservedEntity implements Observed {

	private final List<Observer> obsList;
	private int state;

	public MyObservedEntity(){
        this.obsList = new ArrayList<Observer>();
	}

	public void register(final Observer obs) {
        this.obsList.add(obs);
	}

	public synchronized int getState() {
		return this.state;
	}

	public synchronized void changeState1() {
        this.state++;
		for (final Observer o: this.obsList){
			o.notifyStateChanged(this);
		}
	}

	public synchronized void changeState2() {
        this.state--;
		for (final Observer o: this.obsList){
			o.notifyStateChanged(this);
		}
	}
}
