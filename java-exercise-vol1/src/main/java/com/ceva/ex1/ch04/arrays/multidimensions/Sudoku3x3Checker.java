package com.ceva.ex1.ch04.arrays.multidimensions;

public class Sudoku3x3Checker {
    private static final int DIMENSION = 3;

    private static void sudokuChecker(int[][] array){
        for(int i = 1; i <= DIMENSION * DIMENSION; i++){
            // flag found
            boolean found = false;
            // label break
            matrixLoop:
            for(int row = 0; row < DIMENSION; row++){
                for(int col = 0; col < DIMENSION; col++){
                    int element = array[row][col];
                    if (element == i){
                        found = true;
                        break matrixLoop;
                    }
                }
            }
            // found sigue siendo false?
            if (!found)
                System.out.printf("Missing %d%n", i);
        }

        boolean[] numberExisted = new boolean[DIMENSION*DIMENSION];

        for (int row = 0; row < DIMENSION; row++){
            for(int col = 0; col < DIMENSION; col++){
                int element = array[row][col];
                if(element >= 1 && element <= 9)
                    numberExisted[element - 1] = true;
            }
        }

        for(int i = 0; i < numberExisted.length; i++){
            boolean found = numberExisted[i];
            if(!found)
                System.out.printf("Missing %d%n", i+1);
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 0, 9 }
        };

        sudokuChecker(matriz);
    }
}
