package com.tabata.Data_Structure;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges, Katy Diaz Beltran
 *
 * Class:
 *     our own implementation of a linked list
 */


public final class LinkedList {

    private Node head = null; //PTR esta "vacio" o nulo
    private Node tail = null;

    /* function made to add a new point */
    public void add(Point p){
        Node n = new Node(p);
        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.setNextPoint(n);
            tail = n;
        }
    }

    public void add(Pair p){
        Node n = new Node(p);
        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.setNextPoint(n);
            tail = n;
        }
    }

    public Node get(int index){
        Node result = null;
        Node current = head;
        int i = 0;
        while(current != null){
            if(i == index){
                return current;
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    /* Function made to display the list */
    public void display(){
        Node current = head;

        if(current == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");
        while(current != null){
            System.out.print(current.getPointData().toString() +" -> ");
            current = current.getNext();
        }
        if(current == null)
            System.out.print("null\n");
    }

    /* function made to return size of list*/
    public int size(){
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }


    /* functions to do the sorting function */
    /**
     * Sort
     * References:
     * [0]: https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/
     */
    public void sortList() {
        // Node current will point to head
        Node current = this.head, index = null;

        Point temp;

        if (this.head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.getNext();

                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    /* to check for x primarly */
                    if (current.getPointData().getX() > index.getPointData().getX()) {
                        temp = current.getPointData();
                        current.setPointData( index.getPointData());
                        index.setPointData(temp);
                    }else{
                        /* to check for y secondly */
                        if(current.getPointData().getX() == index.getPointData().getX()){
                            if(current.getPointData().getY() >= index.getPointData().getY()){
                                temp = current.getPointData();
                                current.setPointData( index.getPointData());
                                index.setPointData(temp);
                            }
                        }else{
                            index = index.getNext();
                        }
                    }
                }
                current = current.getNext();
            }
        }
    }



    public LinkedList sublist(LinkedList list, int init, int end){
        LinkedList result = new LinkedList();
        int i = 0;
        Node current = list.getHead();
        while(current != null){
            if(i >= init){
                result.add(current.getPointData());
            }
            if(i == end){
                break;
            }
            i++;
            current = current.getNext();
        }
        return result;
    }

    /* getter */
    public Node getHead(){
        return this.head;
    }
}
