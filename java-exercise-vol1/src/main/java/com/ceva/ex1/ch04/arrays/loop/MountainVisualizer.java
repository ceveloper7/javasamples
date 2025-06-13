package com.ceva.ex1.ch04.arrays.loop;

/**
 * enhanced loop: Draw Mountains
 */
public class MountainVisualizer {

    private static String mountainChar(){ return "*";}

    private static void printMountain(int[] altitudes){
        int maxAltitude = altitudes[0];
        // obtener el valor maximo en la matriz
        for(int altitude : altitudes){
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        // dibujamos las lineas, empezando por la altura maxima.
        for(int height = maxAltitude; height >= 0; height--){
            System.out.print(height + " ");
            for(int altitude : altitudes)
                System.out.print(altitude == height ? mountainChar() : " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // matriz de informacion de altitud
        int[] values = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
        printMountain(values);
    }
}
