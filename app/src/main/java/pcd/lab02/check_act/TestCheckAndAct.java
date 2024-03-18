package pcd.lab02.check_act;

/**
 * To enable assertions: run with -ea option
 *
 * @author aricci
 */
public class TestCheckAndAct {

    public static void main(final String[] args) throws Exception {

        final int ntimes = 10000;

        final BoundedCounter c = new BoundedCounter(0, 1);

        final WorkerA w1a = new WorkerA(c, ntimes);
        final WorkerA w1b = new WorkerA(c, ntimes);
        final WorkerB w2a = new WorkerB(c, ntimes);
        final WorkerB w2b = new WorkerB(c, ntimes);

        w1a.start();
        w1b.start();
        w2a.start();
        w2b.start();

        w1a.join();
        w1b.join();
        w2a.join();
        w2b.join();

        System.out.println("Counter final value: " + c.getValue());
    }
}
