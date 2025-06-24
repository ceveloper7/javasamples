package com.ceva.ex1.ch05.string;

/**
 * Test if the fruit is wrapped in Chocolate
 */
public class ChocolateCovered {
    private static final String FRUIT = "F";

    private static boolean checkChocolate(String string){
        return checkChocolate(string, 0);
    }

    private static boolean checkChocolate(String string, int layer){
        if(string.isEmpty())
            return false;

        if (string.length() == 1)
            return string.equals(FRUIT) && layer != 0;

        if (string.charAt(0) != string.charAt(string.length()-1)){
            return false;
        }

        return checkChocolate(string.substring(1, string.length() - 1), layer + 1);
    }

    public static void main(String[] args) {
        System.out.println(checkChocolate("dhFhd"));
    }
}
