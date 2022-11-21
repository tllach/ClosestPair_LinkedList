package com.tabata.Algorithm;

import com.tabata.Data_Structure.LinkedList;
import com.tabata.Data_Structure.Node;
import com.tabata.Data_Structure.Pair;
import com.tabata.Data_Structure.Point;
import com.tabata.Time_Management.Time_Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges
 *
 * Class:
 *     implementation of the algorithm Divide And Conquer
 */

public class DivideAndConquer {

    /* data members */
    private int numOperations;
    private double elapsedTime;
    private LinkedList closestPairs;

    public DivideAndConquer(){
        closestPairs = new LinkedList();
    }

    /**
     * Funcion que ejecuta el codugo de BrutalForce
     * @param coords dataset
     * @param n tamaño de las coordendas
     */
    public void run(LinkedList coords, int n){
        Time_Manager time = new Time_Manager();
        elapsedTime = 0;
        numOperations = 0;
        time.startTime();
        divideAndConquer(coords, n);
        findTheClosestPoint(closestPairs, n);
        time.stopTime();
        elapsedTime = time.getElapsedTime();
    }

    /**
     * Funcion que implementa el algoritmo divideAndConquer
     * @param coords lista de coordenadas a dividir
     */
    private void divideAndConquer(LinkedList coords, int n){
        BrutalForce brutalForce = new BrutalForce();
        LinkedList Lx = new LinkedList();
        LinkedList Rx = new LinkedList();
        Lx = Lx.sublist(coords, 0, n/2-1);
        Rx = Rx.sublist(coords,n/2, n);

        //list created just to iterate between List
        ArrayList<LinkedList> lists = new ArrayList<>();
        lists.add(Lx);
        lists.add(Rx);
        for(LinkedList list: lists){
            int size = list.size();
            //checking size of the list
            if(size <= 3){
                closestPairs.add(brutalForce.run(list, size));
            }else{
                divideAndConquer(list, size);
            }
        }
        numOperations = n*n;
    }

    /**
     * Funcion que encuentra la distancia menor para hhalar el par mas cercano
     * @param coords dataset
     * References:
     *  [0]: https://www.geeksforgeeks.org/comparator-comparingdouble-method-in-java-with-examples/
     */
    private void findTheClosestPoint(LinkedList coords, int n){
        double d_min =  Integer.MAX_VALUE;
        double distance;
        Node current = coords.getHead();
        while(current.getNext() != null){
            distance = current.getPairData().getDistance();
            if(distance < d_min){
                current = current.getNext();
            }else{
                break;
            }
        }
    }

    /* getters */
    public int getNumOperations(){
        return numOperations;
    }

    public double getElapsedTime(){
        return elapsedTime;
    }

}
