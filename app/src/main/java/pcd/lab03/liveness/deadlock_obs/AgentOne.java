package pcd.lab03.liveness.deadlock_obs;

public class AgentOne extends Thread {
 	MyObservedEntity obj;
	
 	public AgentOne(final MyObservedEntity obj){
 		this.obj = obj;
 	}
 	
	public void run(){
		while (true){
            this.obj.changeState1();
            this.obj.changeState2();
		}
	}
}
