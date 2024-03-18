package pcd.lab03.liveness.deadlock_simplest;

import pcd.lab03.liveness.accounts_exercise.BaseAgent;

public class ThreadA extends BaseAgent {
 
	private final Resource res;
	
	public ThreadA(final Resource res){
		this.res = res;
	}
	
	public void run(){
		while (true){
            this.waitAbit();
            this.res.rightLeft();
		}
	}	
}
