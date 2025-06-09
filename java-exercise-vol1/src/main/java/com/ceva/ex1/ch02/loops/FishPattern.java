package com.ceva.ex1.ch02.loops;

public class FishPattern {
    private static final String RIGHT_FISH = "><>";
    private static final String LEFT_FISH = "<><";
    private static final char SPACER = ' ';

    public static void main(String[] args) {
        int repetitions = 2;

        for(int f = 0; f < repetitions; f++){
            for(int r = 0; r < repetitions; r++){
                System.out.print(RIGHT_FISH + SPACER);
            }

            for (int l = 0; l < repetitions; l++){
                System.out.print(LEFT_FISH + SPACER);
            }
            System.out.println();
        }
    }
}
