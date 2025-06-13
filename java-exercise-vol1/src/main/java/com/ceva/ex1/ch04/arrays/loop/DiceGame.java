package com.ceva.ex1.ch04.arrays.loop;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Enhanced for loop: Numbers well shuffled
 */
public class DiceGame {
    // lanzar los dados
    private static int[] shuffleDice(){
        int[] result = new int[5];
        for(int i = 0; i < result.length; i++){
            result[i] = ThreadLocalRandom.current().nextInt(1,7);
        }
        return result;
    }

    private static boolean isHomogeneous(int[] values){
        int first = values[0];
        // enhanced loop
        for(int value : values){
            if(value != first)
                return false;
        }
        return true;
    }

    private static int[] occurrences(int[] values){
        int[] result = new int[6];
        for(int value : values){
            result[value - 1]++;
        }
        return result;
    }

    private static boolean isFullHouse(int[] values){
        boolean hasTwoOfAKind = false;
        boolean hasThreeOfAKind = false;

        for(int occurence : occurrences(values)){
            switch (occurence){
                case 2 -> hasTwoOfAKind = true;
                case 3 -> hasThreeOfAKind = true;
                //default -> { return false;}
            }
        }
        return hasThreeOfAKind && hasTwoOfAKind;
    }
    
    private static void printDiceValues(int[] values){
        int[]occurences = occurrences(values);

        boolean first = true;
        for(int value = 0; value < occurences.length; value++){
            if(occurences[value] > 0){
                System.out.printf("%s%s%c",
                        first ? "" : ", ",
                        times(occurences[value]),
                        dieFace(value));
                first = false;
            }
        }
    }

    private static String times(int value){
        return value == 1 ? "" : value + " x ";
    }

    private static char dieFace(int value){
        return new char[] {'\u2680', '\u2681', '\u2682', '\u2683', '\u2684', '\u2685'}[value];
    }

    public static void main(String[] args) {
        int[] shuffle = shuffleDice();
        System.out.println( Arrays.toString( shuffle ) );

        System.out.println( isHomogeneous( new int[]{ 1, 1, 1, 1, 1 } ) );
        System.out.println( isHomogeneous( new int[]{ 1, 1, 1, 2, 2 } ) );

        System.out.println( Arrays.toString( occurrences( new int[]{ 1, 1, 2, 3, 4 } ) ) );

        System.out.println( isFullHouse( new int[]{ 1, 1, 1, 2, 2 } ) );
        System.out.println( isFullHouse( new int[]{ 1, 1, 1, 1, 1 } ) );

        printDiceValues( shuffle );
    }
}
