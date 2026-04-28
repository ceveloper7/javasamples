package grokking.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortSample {

    public static int findSmallest(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static List<Integer> selectionSort(int[] arr){
        // Create a mutable list copy
        List<Integer> copiedArr = new ArrayList<>();
        for (int num : arr) {
            copiedArr.add(num);
        }

        List<Integer> newArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = findSmallest(copiedArr);
            newArr.add(copiedArr.remove(smallestIndex));  // pop(index) in Java
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 2};
        List<Integer> sorted = selectionSort(arr);

        System.out.println(sorted);  // [1, 2, 3, 5, 8]
    }
}
