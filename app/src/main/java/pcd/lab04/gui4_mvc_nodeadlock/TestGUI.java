package pcd.lab04.gui4_mvc_nodeadlock;

public class TestGUI {
  static public void main(final String[] args){
	  
	final MyModel model = new MyModel();
	final MyController controller = new MyController(model);
    final MyView view = new MyView(controller);
    model.addObserver(view);    
    view.setVisible(true);
    
    new MyAgent(model).start();

  }
  
}
