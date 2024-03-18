package pcd.lab04.gui4_mvc_nodeadlock;

public class MyAgent extends Thread {

	private final MyModel model;
	
	public MyAgent(final MyModel model){
		this.model = model;
	}
	
	public void run(){
		while (true){
			try {
                this.model.update();
				Thread.sleep(500);
			} catch (final Exception ex){
			}
		}
	}
}
