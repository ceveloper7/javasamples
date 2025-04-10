package com.ceva.ex1.ch02.expressions_operands_operators;

/**
 * The zero effect
 */
public class Program5 {
    public static void main(String[] args) {
        int zero = 0;
        int ten = 10;
        double anotherTen = 10;

        System.out.println(anotherTen / zero); // infinity
        System.out.println(ten / zero); // AritmethicException
    }
}
