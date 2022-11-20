package com.tabata.Algorithm;

import com.tabata.Data_Structure.LinkedList;
import com.tabata.Data_Structure.Pair;
import com.tabata.Data_Structure.Point;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges
 *
 * Class:
 *     implementation of the algorithm Brutal Force
 */

public class BrutalForce {

    public BrutalForce(){

    }

    /**
     * Funcion que implementa el algoritmo de brutalForce
     * @param coords: lista de coordenadas
     * @param n: tamaño de la lista de coordenadas
     * @return object Pair which contains the closest Pair and their distance of the coords given
     */
    public Pair run(LinkedList coords, int n){
        double d_min, distance;
        d_min = 1234567890;
        Point p1 = null, p2 = null;
        for(int i = 0; i <= n-1; i++){
            for(int j = i+1; j <= n-1; j++){
                distance = coords.get(i).getPointData().getDistance(coords.get(j).getPointData());
                if(distance < d_min){
                    p1 = coords.get(i).getPointData();
                    p2 = coords.get(j).getPointData();
                    d_min = distance;
                }
            }
        }
        return new Pair(p1, p2, d_min);
    }
}
