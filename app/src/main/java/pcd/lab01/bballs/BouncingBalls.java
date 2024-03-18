package pcd.lab01.bballs;

import javax.swing.SwingUtilities;

/**
 * Bouncing Ball demo 
 * 
 * - stressing the number of threads
 * - agents with non-terminating behaviour
 * 
 * @author aricci
 */
public class BouncingBalls {

    public static void main(final String[] args) {
        
        final Context ctx = new Context();
        
        final BallViewer viewer = new BallViewer(ctx);
        viewer.start();
      
        final ControlPanel control = new ControlPanel(ctx);
        SwingUtilities.invokeLater(() -> {
            control.setVisible(true);
        });

    }
}
