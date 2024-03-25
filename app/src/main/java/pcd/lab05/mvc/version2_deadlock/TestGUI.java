package pcd.lab05.mvc.version2_deadlock;

public class TestGUI {
  static public void main(final String[] args){
	  
	final MyModel model = new MyModel();
	final MyController controller = new MyController(model);
    final MyView view = new MyView(controller);
    model.addObserver(view);    
    view.display();
    
    // new MyAgent(model).start();

  }
  
}
