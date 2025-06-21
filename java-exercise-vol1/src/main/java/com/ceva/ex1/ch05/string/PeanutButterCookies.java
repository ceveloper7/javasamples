package com.ceva.ex1.ch05.string;

/**
 * Character and String processing: Bake Peanut butter cookies
 */
public class PeanutButterCookies {

    private static void countCookies(String input){
        int cookies = 0;
        for(int i = 0; i < input.length()-2;){
            String triplet = input.substring(i, i+3);
            if(hasRecipeIngredients(triplet)){
                cookies++;
                i += 3;
            }else{
                i++;
            }
        }
        System.out.printf("Cookies: %d, Ingredients remaining: %d%n", cookies, input.length() - 3 * cookies);
    }

    private static boolean hasRecipeIngredients(String triplet){
        return triplet.length() == 3 &&
                triplet.contains("P") &&
                triplet.contains("S") &&
                triplet.contains("E");
    }

    public static void main(String[] args) {
        String r = "PPPEEESSS";
        countCookies(r);
    }
}
