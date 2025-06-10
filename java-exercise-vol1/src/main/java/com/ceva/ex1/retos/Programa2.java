package com.ceva.ex1.retos;

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */

import java.util.Arrays;

public class Programa2 {

    private static void simpleFibSerie(){
        int[] serie = new int[50];
        long[] result = new long[serie.length];
        for(int i = 0; i < serie.length; i++){
            serie[i] = i;
        }
        System.out.println(Arrays.toString(serie));
        result[1] = serie[0] + serie[1];
        for(int i =1; i < result.length-1; i++){
            result[i+1] = result[i-1] + result[i];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        simpleFibSerie();
    }
}
