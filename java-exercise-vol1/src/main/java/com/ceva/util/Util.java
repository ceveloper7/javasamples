package com.ceva.util;

public class Util {

    public static boolean isDigit(String input){
        return input.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }

    public static void displayMessage(String message){
        System.out.print(message);
    }

    public static void displayMessageLine(String message){
        System.out.println(message);
    }

    public static void displayAmount(double amount){
        System.out.printf("$%,.2f", amount);
    }
}
