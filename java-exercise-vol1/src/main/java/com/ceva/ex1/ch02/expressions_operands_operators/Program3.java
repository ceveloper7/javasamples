package com.ceva.ex1.ch02.expressions_operands_operators;

import com.ceva.util.Util;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program 3: Convert Currency Amount to Coins
 */
public class Program3 {
    private static final Logger LOGGER = Logger.getLogger(Program3.class.getName());

    private Scanner input;
    private static final int CONVERT = 1;
    private static final int EXIT = 2;
    private static final String LIRETTA = "Liretta";
    private static final String CENTS = "LirettaCents";

    private int[] liretta = {2, 1, 50, 20, 10, 5, 2, 1};

    public Program3(){
        input = new Scanner(System.in);
    }

    private int displayMainMenu(){
        System.out.println("\nMoney Convert System: Main Menu");
        System.out.println("1 - Convert money to Lirettas");
        System.out.println("2 - Exit");

        return input.nextInt();
    }

    private void convert(){
        Util.displayMessage("\nPlease enter the amount of money to convert: ");
        String userInput = input.next();
        boolean inputOk = Util.isDigit(userInput);
        if(inputOk){

            System.out.println(Integer.parseInt(userInput));


        }else{
            LOGGER.log(Level.WARNING, "Ingreso un monto invalido, vuelva a intentarlo");
        }
    }

    private void process(){

        boolean userExited = false;
        while(!userExited){
            int mainMenuSelection = displayMainMenu();
            switch (mainMenuSelection){
                case CONVERT:
                    convert();
                    break;
                case EXIT:
                    Util.displayMessageLine("\nExiting the System...");
                    userExited = true;
                    break;
                default:
                    Util.displayMessageLine("\nYou did not enter a valid selection option, try again");
                    break;
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
