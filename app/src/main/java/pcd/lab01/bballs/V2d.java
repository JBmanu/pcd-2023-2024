/*
 *   V2d.java
 *
 * Copyright 2000-2001-2002  aliCE team at deis.unibo.it
 *
 * This software is the proprietary information of deis.unibo.it
 * Use is subject to license terms.
 *
 */
package pcd.lab01.bballs;

/**
 *
 * 2-dimensional vector
 * objects are completely state-less
 *
 */
public class V2d implements java.io.Serializable {

    public double x,y;

    public V2d(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public V2d sum(final V2d v){
        return new V2d(this.x +v.x, this.y +v.y);
    }

    public double abs(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public V2d getNormalized(){
        final double module= Math.sqrt(this.x * this.x + this.y * this.y);
        return new V2d(this.x /module, this.y /module);
    }

    public V2d mul(final double fact){
        return new V2d(this.x *fact, this.y *fact);
    }

    public String toString(){
        return "V2d("+ this.x +","+ this.y +")";
    }
}
