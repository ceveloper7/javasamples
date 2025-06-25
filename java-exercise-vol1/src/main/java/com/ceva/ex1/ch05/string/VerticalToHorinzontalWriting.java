package com.ceva.ex1.ch05.string;

/**
 * From Top to Bottom, from left to right
 */
public class VerticalToHorinzontalWriting {

    private static void printVerticalToHorizontalWriting(String string){
        String oneLine = string.replace("\n", "");
        int numberOfLines = string.length() - oneLine.length()+1;
        for(int i = 0; i < oneLine.length(); i++){

        }
    }

    public static void main(String[] args) {
        String text = "s u\ney!\nao";

        System.out.println(text);
    }
}
