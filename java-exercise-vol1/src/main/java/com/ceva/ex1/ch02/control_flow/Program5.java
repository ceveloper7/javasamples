package com.ceva.ex1.ch02.control_flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Evaluate Input string for Approval
 */
public class Program5 {
    private void askUserInput(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter a string: ");
            String input = reader.readLine().toLowerCase();

            String description = switch (input){
                case "ay", "aye", "ay, ay", "ja", "joo" -> "Keep it up";
                default -> "Do not you dare";
            };

            System.out.println(description);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Program5 program5 = new Program5();
        program5.askUserInput();
    }
}
