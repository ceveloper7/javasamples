package com.epbs.console.ui;

import java.io.PrintWriter;

public class Screen {
    private static final PrintWriter writer = new PrintWriter(System.out, true);

//    public Screen(){
//        writer = new PrintWriter(System.out, true);
//    }

    public static void displayMessage(String message){
        writer.print(message);
    }

    public static void displayMessageLine(String message){
        writer.println(message);
    }

    public static void displayDollarAmount(double amount){
       writer.printf("$%,.2f", amount);
    }
}
