package com.ceva.ex1.ch04.arrays.arrays_utility_class;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * The Utility Class Arrays: Copy Arrays
 */
public class Quizz1 {

    public static void main(String[] args) {
        // array soruce
        int[] hooey = {1,2,3,4};
        // array destination
        int[] shuck = new int[hooey.length-1];
        int bushwa = 2;
        int kelter = 0;
        int piddle = 0;

        /**
         * hooey -> array source
         * kelter -> source position
         * shuck -> array destination
         * piddle -> destination position
         * bushwa -> length
         */
        System.arraycopy(hooey, kelter, shuck, piddle, bushwa);
        System.out.println(Arrays.toString(shuck)); // [1,2,0]

        System.arraycopy(hooey, bushwa+1, shuck, bushwa, hooey.length - bushwa - 1);
        System.out.println(Arrays.toString(shuck)); //[1,2,4]

        Object[] array1 = {"Anne Bonny", "Fortune", "Sir Francis Drake", new int[]{1,2,3}};
        Object[] array2 = {"Anne Bonny", "Fortune", "Sir Francis Drake", new int[]{1,2,3}};

        System.out.println(array1 == array2);
        System.out.println(array1.equals(array2));  // false
        System.out.println(Arrays.equals(array1, array2)); // false
        System.out.println(Arrays.deepEquals(array1, array2)); // true
    }
}
