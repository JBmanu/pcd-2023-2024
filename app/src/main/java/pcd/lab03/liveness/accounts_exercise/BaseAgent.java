package pcd.lab03.liveness.accounts_exercise;

import java.util.Random;

public abstract class BaseAgent extends Thread {
 
	private final Random gen;
	
	public BaseAgent(){
        this.gen = new Random();
	}
	
	protected void waitAbit() {
		try {
			Thread.sleep(this.gen.nextInt(200));
		} catch (final Exception ex){}
	}

}
