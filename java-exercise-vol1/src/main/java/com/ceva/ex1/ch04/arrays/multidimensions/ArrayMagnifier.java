package com.ceva.ex1.ch04.arrays.multidimensions;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * { {1, 2, 3},
 *   {4, 5, 6} }
 */
public class ArrayMagnifier {
    private static int[][] magnify(int[][] array, int factor){
        int width = array[0].length; // print nro columns (width)
        int height = array.length; // print nro rows (height)

        // create new multidimensional array
        int[][] result = new int[height * factor][width * factor];

        // recorrer todas las filas
        for (int row = 0; row < result.length; row++){
            // obtenemos la primera fila que muestra el nro de columnas
            int[] cols = result[row];
            for(int col = 0; col < cols.length; col++){
                cols[col] = array[row/factor][col/factor];
            }
        }
        return result;
    }

    private static void printValues(int[][] array){
        for (int[]rows : array){
            for(int col = 0; col < rows.length; col++){
                System.out.printf("%03d%s", rows[col],
                        col == rows.length-1? "" : ", ");
            }
            System.out.println();
        }
    }

    private static void fillWithRandomValues(int[][] array){
        for(int row = 0; row < array.length; row++){
            int[] cols = array[row];
            for(int col = 0; col < cols.length; col++){
                array[row][col] = ThreadLocalRandom.current().nextInt(256);
            }
        }
    }

    public static void main(String[] args) {
        int[][] testArray = new int[ 2 ][ 5 ];
        fillWithRandomValues( testArray );
        printValues( testArray );
        System.out.println();
        int[][] result = magnify( testArray, 2 );
        printValues( result );
    }
}
