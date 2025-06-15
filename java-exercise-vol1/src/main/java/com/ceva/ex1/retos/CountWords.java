package com.ceva.ex1.retos;

import java.util.Arrays;

public class CountWords {

    private static void countWords(String word){
        // reemplazamos los espacios en blancos
        String w = word.toLowerCase().replaceAll("\\s+","");
        String[] array = new String[w.length()];

        for(int i = 0; i < w.length(); i++){
            array[i] = String.valueOf(w.charAt(i));
        }

        System.out.println(Arrays.toString(array));

        String first, second;

        for(int i = 0, count = 1; i < w.length(); i++){
            first = array[i];
            second = "";
            for(int j = i+1; j <= w.length()-1; j++){
                if(!array[j].equals("null"))
                    second = array[j];
                if(first.equals(second)){
                    count++;
                    array[j] = "null";
                }

            }
            if(!array[i].equals("null")){
                System.out.printf("%s--> %d%n", first, count);
                count=1;
            }
        }

    }

    public static void main(String[] args) {
        countWords("hello world java");
    }
}
