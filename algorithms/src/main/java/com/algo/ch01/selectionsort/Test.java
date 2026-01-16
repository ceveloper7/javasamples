package com.algo.ch01.selectionsort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {5,3,6};
        Util.selectionSort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
