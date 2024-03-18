package pcd.lab01.bballs;

/**
 *
 * 2-dimensional point
 * objects are completely state-less
 *
 */
public class P2d implements java.io.Serializable {

    public double x,y;

    public P2d(final double x, final double y){
        this.x=x;
        this.y=y;
    }

    public P2d sum(final V2d v){
        return new P2d(this.x +v.x, this.y +v.y);
    }

    public V2d sub(final P2d v){
        return new V2d(this.x -v.x, this.y -v.y);
    }

    public String toString(){
        return "P2d("+ this.x +","+ this.y +")";
    }

}
