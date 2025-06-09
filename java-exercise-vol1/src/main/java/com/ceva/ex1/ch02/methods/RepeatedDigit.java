package com.ceva.ex1.ch02.methods;

/**
 * A Repeated digits has only identical digits
 */
public class RepeatedDigit {
    private static boolean isRepdigit(long n){
        if((n % 100) / 10 != n % 10){
            return n < 10;
        }
        return isRepdigit(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(isRepdigit(99));
    }
}
