package com.ceva.ex1.ch05.string;

/**
 * Character and String processing - Detetct Repetitions
 */
public class RepeatingStrings {
    private static String repeatingStrings(String string){
        if(string == null || string.length() < 2)
            return null;

        for(int i = 1; i < string.length()/2; i++){
            // validamos si i es una divisior exacto de la longitud de la cadena.
            if (string.length() % i == 0){
                String subString = string.substring(0, i);
                String repeatedString = subString.repeat(string.length()/i);

                if(string.equals(repeatedString))
                    return subString;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3C\uD83C\uDF3C" ) );
        System.out.println( repeatingStrings( "\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B\uD83C\uDF3C\uD83C\uDF3B" ) );
    }
}
