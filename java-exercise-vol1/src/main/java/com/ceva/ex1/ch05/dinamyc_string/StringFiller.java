package com.ceva.ex1.ch05.dinamyc_string;

/**
 * Fill String
 */
public class StringFiller {
    private static boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }

    private static String mix(String string, String fill){
        // si es nulo o vacion, return cadena vacia
        if(isNullOrEmpty(string))
            return "";

        // si fill es nulo o vacio, no hacemos nada
        if(isNullOrEmpty(fill))
            return string;

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < string.length() -1; i++){
            char c = string.charAt(i);
            result.append(c).append(fill);
        }
        result.append(string.charAt(string.length()-1));

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(mix("Hello", "."));
    }
}
