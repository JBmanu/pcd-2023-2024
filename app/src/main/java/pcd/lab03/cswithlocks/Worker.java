package pcd.lab03.cswithlocks;

import java.util.*;

public abstract class Worker extends Thread {
	
	private final Random rand;
	
	public Worker(final String name){
		super(name);
        this.rand = new Random();
	}

	protected void wasteTime(final long ms){
		try {
			sleep(ms);
		} catch (final InterruptedException ex){
			ex.printStackTrace();
		}
	}

	protected void wasteRandomTime(final long min, final long max){
		try {
			final double value = this.rand.nextDouble();
			final double delay = min + value*(max-min);
			sleep((int)delay);
		} catch (final InterruptedException ex){
			ex.printStackTrace();
		}
	}

	protected void print(final String msg){
		synchronized (System.out){
			System.out.print(msg);
		}
	}

	protected void println(final String msg){
		synchronized (System.out){
			System.out.println(msg);
		}
	}

}
