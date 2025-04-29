package com.epbs.console.ui;

import java.io.PrintWriter;

public class Screen {
    private final PrintWriter writer;

    public Screen(){
        writer = new PrintWriter(System.out, true);
    }

    public void displayMessage(String message){
        writer.print(message);
    }

    public void displayMessageLine(String message){
        writer.println(message);
    }

    public void displayDollarAmount(double amount){
       writer.printf("$%,.2f", amount);
    }
}
