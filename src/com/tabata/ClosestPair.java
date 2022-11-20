package com.tabata;

import com.tabata.Algorithm.DivideAndConquer;
import com.tabata.Data_Structure.LinkedList;
import com.tabata.Data_Structure.Point;
import com.tabata.File_Management.File_Manager;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges
 *
 * Class:
 *     Class where all the logic is implemented
 */

class ClosestPair{

    public ClosestPair(){ }

    /**
     * Funcion que ejecuta todo el codigo
     * @param nmax max exponent of 2^n which gives total of coordinates that will be created
     * @throws FileNotFoundException
     */
    public void run(int nmax) throws FileNotFoundException {
        DivideAndConquer divAndConq = new DivideAndConquer();
        File_Manager file = new File_Manager("pruebas.txt");
        file.openWriter();
        int j = 3;
        int n = (int) Math.pow(2, j);
        while(n <= Math.pow(2,nmax)){
            LinkedList coords = createCoordinates(n);
            coords.display();
            coords = sort(coords);
            coords.display();
            divAndConq.run(coords, n);
            int numOper = divAndConq.getNumOperations();
            double elapsedTime = divAndConq.getElapsedTime();
            String line = n  + " " + elapsedTime + " " + numOper;
            file.write(line);
            n = (int) Math.pow(2,++j);
        }
        file.closeWriter();
    }

    /**
     * Funcion que crea el data set de las coordenadas
     * @param n: nro total de coordenadas que se crearan
     * @return lista de coordenadas a usar
     */
    public LinkedList createCoordinates(int n) {
        LinkedList coords = new LinkedList();
        Random rand = new Random();
        coords.add(new Point(0, rand.nextInt(11)));
        for(int i = 0; i < n-1; i++){
            int y = rand.nextInt(11);
            if(i < n/2){
                int x = rand.nextInt(11);
                coords.add(new Point(x+1,y));
                continue;
            }
            //to make the range of the other half of coordinates be between 10 to 20
            int x = (int)(Math.random()*10 + 11);
            coords.add(new Point(x,y));
        }
        return coords;
    }

    /**
     * Funcion que sort dado un dataset
     * @param coords dataset a organizar
     * @return coords sorted
     */
    public LinkedList sort(LinkedList coords){
        coords.sort(coords.getHead());
        return coords;
    }
}