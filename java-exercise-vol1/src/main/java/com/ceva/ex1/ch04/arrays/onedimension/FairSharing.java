package com.ceva.ex1.ch04.arrays.onedimension;

import java.util.logging.Logger;

/**
 * Array: Raid the candy store and Share Fairly
 */
public class FairSharing {

    private static int findSplitPoint(int[] values){
        if(values.length < 2)
            return 0;

        // values = { 10, 20, 30, 40, 50 };
        int sumLeft = values[0]; // 10
        int sumRight = 0;

        for(int i = 1; i < values.length; i++){
            sumRight += values[i]; // 140
        }

        for(int splitIndex = 1; splitIndex < values.length; splitIndex++){
            int relativeDifference = relativeDifference(sumLeft, sumRight);
            Logger.getLogger("MuggingFairly")
                    .info("splitIndex = " + splitIndex + ", sum left/right = " + sumLeft + "/" + sumRight
                    + ", difference = " + relativeDifference);
            if(relativeDifference <= 10)
                return splitIndex;

            int element = values[splitIndex]; //20,30,40,50
            // suma al elemento izquierda y resta a elemento derecha
            sumLeft += element; //10+20=30,30+30=60,60+40=100,100+50=150
            sumRight -= element;//140-20=120,120-30=90,90-40=50,50-50=0
        }
        return -1;
    }

    private static int relativeDifference(int a, int b){
        if(a == b)
            return 0;
        int absDifference = Math.abs(a - b);

        return (int)(100. * absDifference / Math.max(a,b));
    }

    public static void main(String[] args) {
        int[] values = {10,20,30,40,50};
        System.out.println(findSplitPoint(values));
    }
}
