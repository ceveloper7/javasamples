package com.ceva.ex1.ch02.loops;

import java.util.Scanner;

/**
 * Given a positive int number, output the number of digits in that number
 */
public class NumberOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a integer number: ");
        int number = input.nextInt();

        int digits = 1;
        for(int numberOfDigits = number/10; numberOfDigits != 0; numberOfDigits /= 10){
            digits++;
        }
        System.out.println("Number of digits is: " + digits);
    }
}
