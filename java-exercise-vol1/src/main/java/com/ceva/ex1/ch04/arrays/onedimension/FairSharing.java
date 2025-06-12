package com.ceva.ex1.ch04.arrays.onedimension;

/**
 * Array: Raid the candy store and Share Fairly
 */
public class FairSharing {

    private static int findSplitPoint(int[] values){}

    private static int relativeDifference(int a, int b){
        if(a == b)
            return 0;
        int absDifference = Math.abs(a - b);

        return (int)(100. * absDifference / Math.max(a,b));
    }

    public static void main(String[] args) {

    }
}
