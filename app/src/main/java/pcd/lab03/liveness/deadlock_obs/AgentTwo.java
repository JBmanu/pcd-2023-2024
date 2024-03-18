package pcd.lab03.liveness.deadlock_obs;

public class AgentTwo extends Thread {
 	MyObserver obj;
	
 	public AgentTwo(final MyObserver obj){
 		this.obj = obj;
 	}
 	
	public void run(){
		while (true){
            this.log("overall state: "+ this.obj.getOverallState());
		}
	}

	private void log(final String msg){
		synchronized(System.out){
			System.out.println("["+this+"] "+msg);
		}
	}
}

