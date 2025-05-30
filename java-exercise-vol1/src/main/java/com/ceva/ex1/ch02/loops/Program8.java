package com.ceva.ex1.ch02.loops;

import com.ceva.util.Util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Loop: Find the smallest and Largest digit of a number
 */
public class Program8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Util.displayMessageLine("Obtener el numero mayor y menor");
        Util.displayMessage("Ingrese una serie de numeros (5425896): ");

        String userData = input.next();
        boolean validInput = Util.isDigitWithNegatives(userData);

        if(validInput){
            int[] arr = Util.getArrayOfNumbers(userData);
            Integer min = arr[0];
            Integer max = arr[0];
            for (int i = 1; i < arr.length; i++){
                if(min.compareTo(arr[i]) > 0) min = arr[i];
                if(max.compareTo(arr[i]) < 0) max = arr[i];
            }
            System.out.println(min + ", " + max);
        }else {
            System.out.println("Error, dato invalido");
        }
    }
}
