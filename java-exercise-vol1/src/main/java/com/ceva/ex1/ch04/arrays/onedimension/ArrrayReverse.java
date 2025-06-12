package com.ceva.ex1.ch04.arrays.onedimension;

import java.util.Arrays;

public class ArrrayReverse {
    private static void reverse(int[] numbers) throws Exception{
        if(numbers.length == 0)
            throw new Exception("Error: No se permiten array vacios");

        int size = numbers.length-1;
        for(int i = 0; i < size; i++, size--){
            int a = numbers[i];
            numbers[i] = numbers[size];
            numbers[size] = a;
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void reverseV2(int[] numbers)throws Exception{
        int middle = numbers.length / 2;
        for(int left = 0; left < middle; left++){
            int right = numbers.length - left - 1;
            intercambio(numbers, left, right);
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void intercambio(int[] numbers, int i, int j){
        int swap = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = swap;
    }
    
    public static void main(String[] args) {
        try{
            int[] nums = {1,2,3,4,5};
            reverseV2(nums);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
