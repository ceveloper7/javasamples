package com.ceva.ex1.ch02.expressions_operands_operators;

import com.ceva.util.Util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program 3: Convert Currency Amount to Coins
 * DecimalFormat [locale: "English (United States)", pattern: "¤#,##0.00"]
 */
public class Program3 {
    private static final Logger LOGGER = Logger.getLogger(Program3.class.getName());

    private Scanner input;
    private static final int CONVERT = 1;
    private static final int EXIT = 2;
    private static final String LIRETTA = "Liretta";
    private static final String CENTS = "LirettaCents";

    private int[] lirettaUnits = {2, 1};
    private int[] lirettaCents = {50, 20, 10, 5, 2, 1};
    private int[] money = new int[2];
    private int valUnits = 0;
    private int valCents = 0;

    public Program3(){
        input = new Scanner(System.in);
    }

    private int displayMainMenu(){
        System.out.println("\nMoney Convert System: Main Menu");
        System.out.println("1 - Convert money to Lirettas");
        System.out.println("2 - Exit");

        return input.nextInt();
    }

    private void units(int units){
        for(int i = 0; i < lirettaUnits.length; i++){
            System.out.println(units / lirettaUnits[i] + " x " + lirettaUnits[i] + " Liretta");
            if(units % lirettaUnits[i] == 0){
                System.out.println((units%lirettaUnits[i])+ " x " + lirettaUnits[i+1] + " Liretta");
                break;
            }
            System.out.println((units%lirettaUnits[i]) + " x " + lirettaUnits[i + 1] + " Liretta");
            break;
        }
    }

    private void cents(int cents){
        for(int i = 0; i < lirettaCents.length; i++){
            if(cents >= lirettaCents[i]){
                System.out.println((cents/lirettaCents[i]) + " x " + lirettaCents[i] + " LirettaCents");
                cents %= lirettaCents[i];
            }
            else{
                System.out.println(cents / lirettaCents[i] + " x " + lirettaCents[i] + " LirettaCents");
            }
        }
    }

    private void convert(){
        Util.displayMessage("\nPlease enter the amount of money to convert: ");
        String userInput = input.next();
        boolean inputOk = Util.isDigit(userInput);
        if(inputOk){
            int point = userInput.indexOf(".");
            if(point > 0){
                units(Integer.parseInt(userInput.substring(0,point)));
                cents(Integer.parseInt(userInput.substring(point+1)));
            }else{
                units(Integer.parseInt(userInput));
            }

        }else{
            LOGGER.log(Level.WARNING, "Ingreso un monto invalido, vuelva a intentarlo");
        }
    }

    private void process(){

        boolean userExited = false;
        while(!userExited){
            int mainMenuSelection = displayMainMenu();
            switch (mainMenuSelection){
                case CONVERT -> convert();
                case EXIT -> {
                    Util.displayMessageLine("\nExiting the System...");
                    userExited = true;
                }
                default -> Util.displayMessageLine("\nYou did not enter a valid selection option, try again");
            }
        }
    }

    private void run(){
        while(true){
            Util.displayMessageLine("\nWelcome");
            process();
            Util.displayMessageLine("\nThank you, have a good day");
        }
    }

    public static void main(String[] args) {
        Program3 program3 = new Program3();
        program3.run();
    }
}
