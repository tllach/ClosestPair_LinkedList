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
     * Merge sorting
     * References:
     * [0]: https://www.geeksforgeeks.org/merge-sort-for-linked-list/
     */
    public void sort(){
        this.mergeSort(this.head);
    }

    /* function used in merge sorting */
    private Node sortedMerge(Node a, Node b){
        Node result = null;

        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* to sort for x primarly */
        if (a.getPointData().getX() < b.getPointData().getX()) {
            result = a;
            result.setNextPoint(sortedMerge(a.getNext(), b));

        }else
            /* case both of x are equal */
            if(a.getPointData().getX() == b.getPointData().getX()) {
                /* to sort for y secondly */
                if (a.getPointData().getY() <= b.getPointData().getY()) {
                    result = a;
                    result.setNextPoint(sortedMerge(a.getNext(), b));
                } else {
                    result = b;
                    result.setNextPoint(sortedMerge(a, b.getNext()));
                }
            } else {
                result = b;
                result.setNextPoint(sortedMerge(a, b.getNext()));
            }
        return result;
    }

    private Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNextPoint(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);

        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    private Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
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
