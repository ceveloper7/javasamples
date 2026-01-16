package com.algo.ch01.selectionsort;


public class Util {
    private static int findSmallest(int[] arr, int startIndex){
        int smallestIndex = startIndex;

        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = findSmallest(arr, i);

            // intercambio (swap)
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
