package com.ceva.ex1.ch04.arrays.varargs;

import java.util.Arrays;

/**
 * Array varargs : Help, Tetraphobia! Put All Fours Last
 */
public class Tetraphobia {
    private static boolean containsFour(int number){
        return String.valueOf(number).contains("4");
    }

    private static int[] fourLast(int... numbers){
        if(numbers.length < 2)
            return numbers;

        // bucle de izquierda a derechga
        for(int startIndex = 0; startIndex < numbers.length; startIndex++){
            // cuando se encuentra un elemento que sea 4 o contenga cuatro, ingresamos al segundo bucle que va de derecha a izquierda
            if(!containsFour(numbers[startIndex]))
                continue;

            for(int endIndex = numbers.length-1; endIndex > startIndex; endIndex--){
                // buscamos el primer espacio libre sin un 4
                if(containsFour(numbers[endIndex]))
                    continue;
                // intercambiamos el contenido del array
                int swap = numbers[startIndex];
                numbers[startIndex] = numbers[endIndex];
                numbers[endIndex] = swap;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers1 = { 1, 44, 2, 4, 43 };
        System.out.println( Arrays.toString( fourLast( numbers1 ) ) );
    }
}
