package pcd.lab04.gui.chrono1_basic;

import java.util.*;

public class Counter {
	
	private final ArrayList<CounterEventListener> listeners;
	private int cont;
	private final int base;
	
	public Counter(final int base){
		this.cont = base;
		this.base = base;
        this.listeners = new ArrayList<CounterEventListener>();
	}
	
	public synchronized void inc(){
        this.cont++;
		System.out.println("count "+ this.cont);
        this.notifyEvent(new CounterEvent(this.cont));
	}
	
	public synchronized void reset(){
        this.cont = this.base;
        this.notifyEvent(new CounterEvent(this.cont));
	}
	
	public synchronized int getValue(){
		return this.cont;
	}
	
	public synchronized void addListener(final CounterEventListener l){
        this.listeners.add(l);
	}
	
	private void notifyEvent(final CounterEvent ev){
		for (final CounterEventListener l: this.listeners){
			l.counterChanged(ev);
		}
	}
}
