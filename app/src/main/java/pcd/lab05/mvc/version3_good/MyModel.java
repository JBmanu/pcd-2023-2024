package pcd.lab05.mvc.version3_good;

import java.util.ArrayList;
import java.util.List;

public class MyModel {

	private final List<ModelObserver> observers;
	private int state;
	
	public MyModel(){
        this.state = 0;
        this.observers = new ArrayList<ModelObserver>();
	}
	
	public synchronized void update(){
        this.state++;
        this.notifyObservers();
	}
	
	public synchronized int getState(){
		return this.state;
	}
	
	public void addObserver(final ModelObserver obs){
        this.observers.add(obs);
	}
	
	private void notifyObservers(){
		for (final ModelObserver obs: this.observers){
			obs.modelUpdated(this);
		}
	}
}
