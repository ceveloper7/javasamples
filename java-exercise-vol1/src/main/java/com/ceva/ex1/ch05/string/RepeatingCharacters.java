package com.ceva.ex1.ch05.string;

/**
 * Character and STring processing: Check safe transmision by doubling characters
 */
public class RepeatingCharacters {
    private static int isEveryCharacterTwice(String string){
        int FAILURE_CODE = 0;
        int SUCCESS_CODE = 1;

        // validamos si es impar
        if(string.length() % 2 != 0)
            return FAILURE_CODE;

        for(int i = 0; i < string.length(); i+= 2){
            char first = string.charAt(i);
            char second = string.charAt(i+1);

            if (first != second)
                return -(i+1);
        }
        return SUCCESS_CODE;
    }

    public static void main(String[] args) {
        System.out.println(isEveryCharacterTwice("jjoovveellyynn"));
        System.out.println(isEveryCharacterTwice("ccapptttaaiinn"));
        System.out.println(isEveryCharacterTwice("222"));
        System.out.println(isEveryCharacterTwice(null));
    }
}
