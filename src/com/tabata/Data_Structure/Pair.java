package com.tabata.Data_Structure;


public final class Pair{

    /* data members */
    private final Point p1, p2; //points of pair
    private final double distance; //distance between those points

    /* constructor */

    public Pair(){
        this.p1 = null;
        this.p2 = null;
        this.distance = 0;
    }

    public Pair(Point p1, Point p2, double distance) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
    }

    public String toString() {
        return ("[" + this.p1.toString() + "," + this.p2.toString() + "] --> " + this.distance);
    }

    /* getters */
    public Point getP1(){
        return this.p1;
    }

    public Point getP2(){
        return this.p2;
    }

    public double getDistance() {
        return this.distance;
    }

}
