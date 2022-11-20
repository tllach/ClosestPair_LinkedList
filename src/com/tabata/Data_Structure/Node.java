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

    /* getters */
    public Point getData() {
        return this.data;
    }

    public Node getNext(){
        return this.next;
    }

    public void setData(Point p){
        this.data = p;
    }

    public void setNext(Node n){
        this.next = n;
    }

}
