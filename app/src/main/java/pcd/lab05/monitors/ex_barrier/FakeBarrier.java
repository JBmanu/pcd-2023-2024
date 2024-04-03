package pcd.lab05.monitors.ex_barrier;

/*
 * Barrier - to be implemented
 */
public class FakeBarrier implements Barrier {
    final int participants;
    int counter;

    public FakeBarrier(final int nParticipants) {
        this.participants = nParticipants;
        this.counter = 0;

    }

    // caso speciale: barrier uno dei pochi metodi
    // dove ce sia wait che signal nello stesso metodo
    // questa barriera non è riusabile
    // per una bariera ciclica allora serve il reset
    @Override
    public void hitAndWaitAll() throws InterruptedException {
        synchronized (this) {
            this.counter += 1;
            if (this.counter == this.participants) {
                this.notifyAll();
            } else {
                while (this.counter < this.participants) this.wait();
            }
        }
    }


}
