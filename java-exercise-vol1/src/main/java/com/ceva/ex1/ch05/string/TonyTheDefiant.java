package com.ceva.ex1.ch05.string;

import java.util.Scanner;

/**
 * Character and String processor: Give Defiant answers
 */
public class TonyTheDefiant {
    private static void defiantAnswer(){
        String input = new Scanner(System.in).nextLine().trim();
        if(input.equalsIgnoreCase("no idea?")){
            System.out.println("Aye!");
        }else if(input.endsWith("?")){
            System.out.println(input + " No idea!");
        }
    }

    public static void main(String[] args) {
        defiantAnswer();
    }
}
