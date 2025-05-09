package com.ceva.ex1.ch02.loops;

import java.util.Scanner;

/**
 * Loops: Sum Numbers from command line
 */
public class Program3 {
    public static void main(String[] args) {
        int value;
        int suma = 0;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Ingrese un numero (Ingreso 0 para ver resultado): ");
            value = input.nextInt();
            suma += value;
        }
        while (value != 0);

        System.out.println("La suma es: " + suma);
    }
}
