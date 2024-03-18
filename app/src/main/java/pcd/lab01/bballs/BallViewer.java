package pcd.lab01.bballs;

import javax.swing.SwingUtilities;

public class BallViewer extends BasicAgent {
    
    private final Context context;
    private final ViewerFrame frame;
    private static final int FRAMES_PER_SEC = 25;
    
    public BallViewer(final Context context){
    	super("BallViewer");
        this.context = context ;
        this.frame = new ViewerFrame(context,620,620);
        SwingUtilities.invokeLater(() -> {
            this.frame.setVisible(true);
        });
   }
    
    public void run(){
        while (!this.hasBeenStopped()) {
            final long t0 = System.currentTimeMillis();
            this.frame.updatePosition(this.context.getPositions());
            final long t1 = System.currentTimeMillis();
        	//log("update pos");
            final long dt = (1000 / FRAMES_PER_SEC) - (t1-t0);
            if (dt > 0){
	            try {
	                Thread.sleep(dt);     
	            } catch (final Exception ex){
	            }
            }
        }
    }
}
