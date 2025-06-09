package com.ceva.ex1.ch02.methods;

/**
 * Methods: Ancient Egyptian Multiplication
 */
public class PeasantMultiplication {
    private static boolean isOdd(int value){
        return value % 2 != 0;
    }

    private static int multiply(int a, int b){
        int sum = 0;
        while (a > 0){
            if(isOdd(a)){
                // si es impar, sumamos el multiplicando (b)
                sum = sum + b;
            }

            a = a / 2;
            b = b * 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(multiply(27, 15));
    }
}
