package com.tabata.Data_Structure;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges, Katy Diaz Beltran
 *
 * Class:
 *     our own implementation of a Node, it'll be used in LinkedList
 */


public final class Node {
    /* data members */
    private Point data;
    private Pair dataPair;
    private Node next;

    /* constructor */
    public Node(){
        data = null;
        next = null;
    }

    public Node(Point d) {
        data = d;
        next = null;
    }

    public Node(Pair p){
        dataPair = p;
        next = null;
    }

    public void setPointData(Point p){
        data = p;
    }

    /* getters */

    public Node getNext(){
        return this.next;
    }

    //for points
    public Point getPointData() {
        return this.data;
    }

    public void setNextPoint(Node n){
        this.next = n;
    }

    //for pair
    public Pair getPairData() {
        return this.dataPair;
    }

    public void setNextPair(Node n){
        this.next = n;
    }
}
