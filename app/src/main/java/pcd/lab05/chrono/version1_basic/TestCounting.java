package pcd.lab05.chrono.version1_basic;

public class TestCounting {
	public static void main(final String[] args) {
		final Counter counter = new Counter(0);
		final Controller controller = new Controller(counter);
        new CounterGUI(counter, controller).display();
	}
}
