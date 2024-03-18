package pcd.lab04.gui3_mvc_deadlock;


public class MyController {
	
	private final MyModel model;
	public MyController(final MyModel model){
		this.model = model;
	}
	
	public void processEvent(final String event) {
		try {
			new Thread(() -> {
				try {
					System.out.println("[Controller] Processing the event "+event+" ...");
					Thread.sleep(1000);
                    this.model.update();
					System.out.println("[Controller] Processing the event done.");
				} catch (final Exception ex){
					ex.printStackTrace();
				}
			}).start();
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}

}
