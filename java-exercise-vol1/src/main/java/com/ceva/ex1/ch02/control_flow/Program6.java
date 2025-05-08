package com.ceva.ex1.ch02.control_flow;

import java.util.Scanner;

/**
 * ReWrite switch statement to switch expression
 */
public class Program6 {

    private void usingSwitchStatement(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese un mes: ");
        int month = input.nextInt();

        System.out.print("Ingrese un año: ");
        int year = input.nextInt();

        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        int days;
        switch (month){
            case 2:
                days = isLeapYear ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }

        System.out.println("Los dias del mes ingresado son: " + days);
    }

    private void usingSwitchExpression(){
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese un mes: ");
        int month = input.nextInt();

        System.out.print("Ingrese un año: ");
        int year = input.nextInt();

        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        int days = switch (month){
            case 2 -> isLeapYear ? 29 : 28;
            case 4,6,9,11 -> 30;
            default -> 31;
        };

        System.out.println("Los dias del mes ingresado son: " + days);
    }

    public static void main(String[] args) {
        Program6 program6 = new Program6();
        program6.usingSwitchExpression();
    }
}
