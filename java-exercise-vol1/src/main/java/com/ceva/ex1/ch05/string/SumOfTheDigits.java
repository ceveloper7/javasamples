package com.ceva.ex1.ch05.string;

/**
 * Character and String processing : Calculate sum of Digits
 */
public class SumOfTheDigits {

    private static int digitSum(long value){
        int i = digitSum(String.valueOf(value));
        return i;
    }

    private static int digitSum(String value){
        int sum = 0;
        for(int i = 0; i < value.length(); i++){
            sum += Character.getNumericValue(value.charAt(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digitSum(125698L));
    }
}
