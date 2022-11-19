package com.tabata;

import java.io.FileNotFoundException;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        ClosestPair closestPair = new ClosestPair();
        closestPair.run(22);
    }
}
