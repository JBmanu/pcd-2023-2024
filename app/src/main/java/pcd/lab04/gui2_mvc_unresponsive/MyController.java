package pcd.lab04.gui2_mvc_unresponsive;

public class MyController {

	private final MyModel model;

	public MyController(final MyModel model) {
		this.model = model;
	}

	public void processEvent(final String event) {
		try {
			System.out.println("[Controller] Processing the event " + event + " ...");
			Thread.sleep(5000);
            this.model.update();
			System.out.println("[Controller] Processing the event done.");
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

}
