package pcd.lab02.cs_raw;

public class MyWorkerB extends Worker {
	
	private final Object lock;
	
	public MyWorkerB(final String name, final Object lock){
		super(name);
		this.lock = lock;
	}

	public void run(){
		while (true){
		  synchronized(this.lock){
              this.action1();
              this.action2();
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
