package com.ceva.ex1.ch02.loops;

import com.ceva.util.Util;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Loop: calculate products for faculties
 */
public class Program6 {

    private static final Logger log = Logger.getLogger("Program6");

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
                int count = 1;
                while (i <= value){
                    System.out.print("Output: " + value + "!= 1");
                    for (;i <= value; i++){
                        count++;
                        if (i == value){
                            System.out.print(" = ");
                        }else{
                            System.out.print(" * " + (count));
                        }

                        total *= i;
                    }
                    System.out.print(" " + total);
                }
            }else if (value == 0){
                System.out.print("Output: " + value + "!= 1");
            }
            else{
                System.out.println("Output: Number must no be negative");
            }
        }else{
            System.out.println("Output: Is not a valid number");
        }
    }
}
