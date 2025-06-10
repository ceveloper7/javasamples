package com.ceva.ex1.ch04.arrays.onedimension;

import java.util.Objects;

/**
 * Arrays one dimension : Search consecutives Strings nd Determine if Salty Snookus comming
 */
public class SaltySnook {
    private static final int MIN_OCCURRENCES = 4;

    private static boolean isProbablyApproaching(String[] signs){
        if(signs.length < MIN_OCCURRENCES)
            return false;

        for(int i = 0, count = 1; i < signs.length-1; i++){
            // Objects.requireNonNull lanza una excepcion si uno de los elementos del array es null
            String currentSign = Objects.requireNonNull(signs[i]);
            String nextSign = Objects.requireNonNull(signs[i+1]);

            if(currentSign.equals(nextSign)){
                // si encontramos dos cadenas iguales consecutivamente incrementamos el contador
                count++;
                // validamos si el contador alcanzo el numero de ocurrencias minimas para salir de programa
                if(count == MIN_OCCURRENCES)
                    return true;
            }else{
                count = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] flags = {"Argentina", "Chile", "Peru", "Venezuela", "Peru", "Peru", "Peru", "Perú" };
        System.out.println(isProbablyApproaching(flags));
    }
}
