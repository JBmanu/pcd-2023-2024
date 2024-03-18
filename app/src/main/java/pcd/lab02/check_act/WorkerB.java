package pcd.lab02.check_act;

public class WorkerB extends Thread{
	
	private final BoundedCounter counter;
	private final int ntimes;
	
	public WorkerB(final BoundedCounter c, final int ntimes){
        this.counter = c;
		this.ntimes = ntimes;
	}
	
	public void run(){
		try {
			for (int i = 0; i < this.ntimes; i++){
				synchronized (this.counter) {
					if (this.counter.getValue() < 1){
                        this.counter.inc();
					}
				}
			}
		} catch (final Exception ex){
			ex.printStackTrace();
		}
	}
}
