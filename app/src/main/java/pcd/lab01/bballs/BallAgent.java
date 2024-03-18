package pcd.lab01.bballs;

import java.util.*;

public class BallAgent extends BasicAgent {
    
    private P2d pos;
    private final V2d vel;
    private final double speed;
    private final Context ctx;
    private long lastUpdate;
    private static final int DELAY_MS = 5;
    
    public BallAgent(final int id, final Context ctx){
    	super("BallAgent-"+id);
    	this.ctx = ctx;
        this.pos = new P2d(0,0);
        final Random rand = new Random(System.currentTimeMillis());
        final double dx = rand.nextDouble();
        this.vel = new V2d(dx,Math.sqrt(1-dx*dx));
        this.speed = rand.nextDouble()*3;
    }

    public void run() {
        //log("INIT: vel "+vel+"speed "+speed);
        try {
            this.lastUpdate = System.currentTimeMillis();
	        while (!this.hasBeenStopped()){
                this.updatePos();
	            Thread.sleep(DELAY_MS);	
	        }
        } catch (final Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void updatePos(){
        final long time = System.currentTimeMillis();
        final long dt = time - this.lastUpdate;
        this.lastUpdate = time;
        this.pos = this.pos.sum(this.vel.mul(this.speed *dt*0.001));
        this.applyConstraints();
    }

    private void applyConstraints(){
        final Boundary bounds = this.ctx.getBounds();
        if (this.pos.x > bounds.getX1()){
            this.pos.x = bounds.getX1();
            this.vel.x = -this.vel.x;
        } else if (this.pos.x < bounds.getX0()){
            this.pos.x = bounds.getX0();
            this.vel.x = -this.vel.x;
        } else if (this.pos.y > bounds.getY1()){
            this.pos.y = bounds.getY1();
            this.vel.y = -this.vel.y;
        } else if (this.pos.y < bounds.getY0()){
            this.pos.y = bounds.getY0();
            this.vel.y = -this.vel.y;
        }
    }
    
    /**
     * 
     * Possible races?
     * 
     * @return
     */

    public P2d getPos(){        
    	return new P2d(this.pos.x, this.pos.y);
    }

}
