package com.ceva.ex1.ch02.control_flow;

import com.ceva.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convert Liters Exercise
 */
public class Program2 {

    private static final Logger LOGGER = Logger.getLogger(Program2.class.getName());

    public void doSetup(){

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out, true)){
            userInput(reader, writer);
        }
        catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
        }
    }

    private boolean validateInput(String input){
        boolean validateOk = false;
        try{
            validateOk = Util.isDigit(input);
        }
        catch (NumberFormatException ex){
            LOGGER.log(Level.SEVERE, "Invalid input");
        }
        return validateOk;
    }

    private void userInput(BufferedReader reader, PrintWriter writer) throws IOException{
        while (true){
            writer.println("Enter liquid quantity: ");
            String input = reader.readLine();
            if(!input.isBlank()){
                try{
                    double value = Double.parseDouble(input);
                    if(value <= 0){
                        writer.println("Invalid input, please enter a valid liquid quantity");
                        continue;
                    }
                    process(value);
                    break;
                }
                catch (NumberFormatException ex){
                    LOGGER.log(Level.SEVERE, "Invalid input, please enter a valid liquid quantity");
                    continue;
                }
            }
            break;
        }
    }

    private void process(double input){}

    public static void main(String[] args) {
        Program2 program2 = new Program2();
        program2.doSetup();
    }
}
