package com.ceva.util;

public class Util {

    public static boolean isDigit(String input){
        return input.matches("[0-9]{1,19}(\\.[0-9]*)?");
    }

    public static boolean isDigitWithNegatives(String input){
        // analiza cadenas de hasta 19 digitos
        return input.matches("^-?[0-9]{1,19}(\\.[0-9]*)?");
    }

    public static int[] getArrayOfNumbers(String input){
        int[] arrayL = null;
        int idx = input.indexOf('-');
        if(idx == 0){
            arrayL = getArraySigned(input);
        }else{
            arrayL = getArrayUnsigned(input);
        }
        return arrayL;
    }

    private static int[] getArraySigned(String input){
        int[] array = new int[input.length()-1];
        int j = 0;
        for(int i = 1; i < input.length(); i++){
            if(i ==1 ){
                array[j] = Integer.parseInt('-'+ input.substring(i, i+1));
                j++;
            }else{
                array[j] = Integer.parseInt(input.substring(i, i+1));
                j++;
            }
        }
        return array;
    }

    private static int[] getArrayUnsigned(String input){
        int[] array = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            array[i] = Integer.parseInt(input.substring(i, i+1));
        }
        return array;
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
