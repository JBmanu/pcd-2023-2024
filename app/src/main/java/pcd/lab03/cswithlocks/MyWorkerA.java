package pcd.lab03.cswithlocks;

import java.util.concurrent.locks.Lock;

public class MyWorkerA extends Worker {
	
	private final Lock lock;
	
	public MyWorkerA(final String name, final Lock lock){
		super(name);
		this.lock = lock;
	}
	
	public void run(){
		while (true){
            this.action1();
		  try {
              this.lock.lockInterruptibly();
              this.action2();
              this.action3();
		  } catch (final InterruptedException ex) {
		  } finally {
              this.lock.unlock();
		  }
		}
	}
	
	protected void action1(){
        this.println("a1");
        this.wasteRandomTime(100,500);
	}
	
	protected void action2(){
        this.println("a2");
        this.wasteRandomTime(300,700);
	}
	protected void action3(){
        this.println("a3");
        this.wasteRandomTime(300,700);
	}
}

