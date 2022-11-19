package com.tabata;

public class LinkedList {

    private Node head = null; //PTR esta "vacio" o nulo
    private Node tail = null;

    public void add(Point p){
        Node n = new Node(p);
        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.setNext(n);
            tail = n;
        }
    }

    // display() will display all the nodes in the singly linked list
    public void display(){
        // First lets create a node current that will point to the node head
        Node current = head;

        if(current == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");
        while(current != null){
            System.out.print(current.getData().toString() +" -> ");
            current = current.getNext();
        }
        if(current == null)
            System.out.print("null\n");
    }

    //countNumNodes() will count the number of nodes in the list
    public int countNumNodes(){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }

}
