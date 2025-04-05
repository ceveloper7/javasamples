package com.ceva.ex1.ch02.expressions_operands_operators;

import com.ceva.util.Util;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Two numbers share the same Digit
 */
public class Program2 {
    private static final Logger LOGGER = Logger.getLogger(Program2.class.getName());

    private Scanner input = new Scanner(System.in);

    private boolean validate(String input){
        return Util.isDigit(input);
    }

    private void userInput(){
        String value1 = "";
        String value2 = "";

        System.out.print("Ingrese primer numero ");
        String num1 = input.nextLine();

        if(validate(num1)){
            value1 = num1;
        }else{
            LOGGER.log(Level.SEVERE, "Dato invalido");
            return;
        }

        System.out.print("Ingrese segundo numero ");
        String num2= input.nextLine();

        if (validate(num2)){
            value2 = num2;
        }else{
            LOGGER.log(Level.SEVERE, "Dato invalido");
            return;
        }

        process(value1, value2);
    }

    private void process(String val1, String val2){

        if(Integer.parseInt(val1) > Integer.parseInt(val2)){
            String temp = val2;
            val2 = val1;
            val1 = temp;
        }

        boolean ok = false;
        char c = ' ';
        int count = 0;

        if(Integer.parseInt(val1) >= 0 && Integer.parseInt(val2) <= 99){
            for(int i = 0; i < val1.length(); i++){
                 c = val1.charAt(i);
                for(int j = 0; j < val2.length(); j++){
                    if(c == val2.charAt(j)){
                        ok = true;
                        output(val1, val2, c, ok);
                        //break;
                    }
                }
            }
        }else{
            for (int i = 1; i < val1.length(); i++){
                c = val1.charAt(i);
                for(int j = 1; j < val2.length(); j++){
                    if(c == val2.charAt(j)){
                        ok = true;
                        output(val1, val2, c, ok);
                        //break;
                    }
                }
            }
        }
        if(!ok){
            output(val1, val2, c, ok);
        }
    }

    private void output(String val1, String val2, char t, boolean ok){
        System.out.println(val1 + " y " + val2 + ((ok) ? " tienen en comun el numero " + t : " no tienen un numero en comun"));
    }

    public static void main(String[] args) {
        Program2 program = new Program2();
        program.userInput();
    }
}
