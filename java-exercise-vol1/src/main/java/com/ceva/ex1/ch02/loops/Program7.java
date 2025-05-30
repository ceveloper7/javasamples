package com.ceva.ex1.ch02.loops;

import com.ceva.util.Util;

import java.util.Scanner;

/**
 * Loop: Determine if a Number is formed by factorial
 */
public class Program7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Util.displayMessage("Ingrese un numero entero: ");
        String consoleVal = input.next();

        boolean isValid = Util.isDigitWithNegatives(consoleVal);
        int value;

        if(isValid){
            value = Integer.parseInt(consoleVal);

            if(value > 0){
                int i = 1;
                int total = 1;

                for(; i <= value; i++){
                    total *= i;
                    if(total == value){
                        System.out.println(value + " = " + i + "!");
                        break;
                    }
                    else if (total > value) {
                        System.out.println(value + " is not a factorial");
                        break;
                    }
                }
            }else if (value == 0) {
                System.out.print("Output: " + value + "!= 1");
            }else{
                System.out.println("Output: Number must no be negative");
            }
        }else{
            System.out.println("Output: Is not a valid number");
        }
    }
}
