package pcd.lab05.monitors.ex_barrier;

import java.util.concurrent.locks.*;

/*
 * Barrier - to be implemented
 */
public class FakeBarrier implements Barrier {
	private final ReentrantLock mutex;
	private final Condition condition;
    final int participants;
    int counter;

    public FakeBarrier(final int nParticipants) {
        this.mutex = new ReentrantLock();
        this.condition = this.mutex.newCondition();
        this.participants = nParticipants;
        this.counter = 0;

    }

    @Override
    public void hitAndWaitAll() throws InterruptedException {
		this.mutex.lock();
		this.counter += 1;
        while (this.counter < this.participants) this.condition.await();
		this.condition.signalAll();
		this.mutex.unlock();
    }


}
