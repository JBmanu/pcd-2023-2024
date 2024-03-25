package pcd.lab05.chrono.version2_strict;

/**
 * 
 * A version strictly following the discipline 
 * about active (agent) & passive (monitor) components.
 * 
 * @author aricci
 *
 */
public class TestCounting {
	public static void main(final String[] args) {
		final Counter counter = new Counter(0);
		final Controller controller = new Controller(counter);
        final CounterView view = new CounterView(controller, counter.getValue());
        controller.setView(view);
        view.display();
	}
}
