package com.ceva.ex1.ch02.control_flow;

import com.ceva.util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ex. PayDay
 */
public class Program1 {
    private static final Logger LOGGER = Logger.getLogger(Program1.class.getName());
    private final int ANTIQUE_POCKET_WATCH = 1000;

    private boolean validate(String input){
        return Util.isDigit(input);
    }

    private void userInput(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter a money amount: ");
            String input = reader.readLine();

            boolean inputOk = validate(input);

            if(inputOk)
                process(Double.parseDouble(input));
            else
                LOGGER.log(Level.SEVERE, "is not a valid amount");
        }
        catch (Exception ex){
            LOGGER.log(Level.SEVERE, "Bad input");
        }
    }

    private void process(double input){
        final double LESS_THAN_TEN_PERCENT = ANTIQUE_POCKET_WATCH - (0.1 * ANTIQUE_POCKET_WATCH);
        final double MORE_THAN_TWENTY_PERCENT = ANTIQUE_POCKET_WATCH + (0.2 * ANTIQUE_POCKET_WATCH);

        if(input >= LESS_THAN_TEN_PERCENT && input <= MORE_THAN_TWENTY_PERCENT)
            System.out.println("Good boy");
        else
            System.out.println("You son of b***ch");
    }

    public static void main(String[] args) {
        Program1 program = new Program1();
        program.userInput();
    }
}
