package pcd.lab03.cswithlocks;

import java.util.concurrent.locks.Lock;

public class MyWorkerB extends Worker {
	
	private final Lock lock;
	
	public MyWorkerB(final String name, final Lock lock){
		super(name);
		this.lock = lock;
	}

	public void run(){
		while (true){
		  try {
              this.lock.lockInterruptibly();
              this.action1();
              this.action2();
		  } catch (final InterruptedException ex) {
		  } finally {
              this.lock.unlock();
		  }
            this.action3();
		}
	}
	
	protected void action1(){
        this.println("b1");
        this.wasteRandomTime(0,1000);
	}
	
	protected void action2(){
        this.println("b2");
        this.wasteRandomTime(100,200);
	}
	protected void action3(){
        this.println("b3");
        this.wasteRandomTime(1000,2000);
	}
}
