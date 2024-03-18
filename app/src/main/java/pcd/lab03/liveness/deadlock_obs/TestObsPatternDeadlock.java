package pcd.lab03.liveness.deadlock_obs;

public class TestObsPatternDeadlock {
	public static void main(final String[] args) {
		
		final MyObservedEntity objA = new MyObservedEntity();
		final MyObserver objB = new MyObserver();
		objB.observe(objA);
		
		new AgentOne(objA).start();
		new AgentTwo(objB).start();

	}
}
