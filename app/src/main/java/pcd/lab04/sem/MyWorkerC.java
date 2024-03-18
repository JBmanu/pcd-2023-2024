package pcd.lab04.sem;

import java.util.concurrent.Semaphore;

public class MyWorkerC extends Worker {
	
	private final Semaphore mutex;
	
	public MyWorkerC(final String name, final Semaphore lock){
		super(name);
		this.mutex = lock;
	}

	public void run(){
		while (true){
		  try {
              this.mutex.acquire();
              this.action1();
              this.action2();
              this.action3();
		  } catch (final InterruptedException ex) {
              this.log("interrupted.");
		  } finally {
              this.mutex.release();
		  }
		}
	}
	
	protected void action1(){
        this.println("c1");
        this.wasteRandomTime(0,2000);
	}
	
	protected void action2(){
        this.println("c2");
        this.wasteRandomTime(100,200);
	}
	protected void action3(){
        this.println("c3");
        this.wasteRandomTime(1000,2000);
	}
}
