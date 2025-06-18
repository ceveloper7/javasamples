package com.ceva.ex1.ch05.string;

/**
 * Character and String processing: Check if captian CiaoCiao es in the middle
 */
public class InMiddle {
    private static boolean isStringInMiddle(String string, String middle){
        if(middle.length() > string.length())
            return false;

        int start = string.length() / 2 - middle.length() / 2;
        return string.regionMatches(start, middle, 0, middle.length());
    }

    private static boolean isCiaoCiaoInMiddle(String string){
        return isStringInMiddle(string, "CiaoCiao");
    }

    public static void main(String[] args) {
        String word = "!! → .CiaoCiao";
        System.out.printf("La palabra %s tiene a CiaoCiao en el medio? %b", word, isCiaoCiaoInMiddle(word));
    }
}
