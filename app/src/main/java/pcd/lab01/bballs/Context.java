package pcd.lab01.bballs;

import java.util.*;

public class Context {

    private final Boundary bounds;
    private final ArrayList<BallAgent> balls;
    private int id = 0;
    
    public Context(){
        this.bounds = new Boundary(-1.0,-1.0,1.0,1.0);
        this.balls = new ArrayList<BallAgent>();
    } 
    
    public void createNewBall(){
        this.id++;
        final BallAgent agent = new BallAgent(this.id, this);
        this.balls.add(agent);
        agent.start();
    }
    
    public void removeBall(){
        if (this.balls.size()>0){
            final BallAgent ball = this.balls.get(0);
            this.balls.remove(ball);
            ball.notifyStopped();
       	}
    }
    
    /**
     * 
     * Possible races?
     * 
     * @return
     */
    public P2d[] getPositions(){
    	final P2d[] array = new P2d[this.balls.size()];
        for (int i=0; i<array.length; i++){
            array[i] = this.balls.get(i).getPos();
        }
        return array;
    }
    
    public  Boundary getBounds(){
        return this.bounds;
    }
}
