package pcd.lab02.check_act;

public class WorkerA extends Thread{
	
	private final BoundedCounter counter;
	private final int ntimes;
	
	public WorkerA(final BoundedCounter c, final int ntimes){
        this.counter = c;
		this.ntimes = ntimes;
	}
	
	public void run(){
		try {
			for (int i = 0; i < this.ntimes; i++){
				synchronized (this.counter) {
					if (this.counter.getValue() > 0){
                        this.counter.dec();
					}
				}
			}
		} catch (final Exception ex){
			ex.printStackTrace();
		}
	}
}
