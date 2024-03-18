package pcd.lab03.liveness.deadlock_simplest;

/**
 * Deadlock example 
 * 
 * @author aricci
 *
 */
public class TestDeadlockedResource {
	public static void main(final String[] args) {
		final Resource res = new Resource();
		new ThreadA(res).start();
		new ThreadB(res).start();
	}

}
