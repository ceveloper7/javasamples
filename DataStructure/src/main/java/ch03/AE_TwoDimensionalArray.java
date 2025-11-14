package ch03;

import java.util.Scanner;

public class AE_TwoDimensionalArray {
    private Scanner scn = new Scanner(System.in);
    int[][] a = new int[2][2];
    int[][] b = new int[2][2];
    int[][] c = new int[2][2];
    private int choice;

    private void setup(){
        System.out.println("Enter elements of 2-D array A");
        for(int r = 0; r < 2; r++){
            for(int c = 0; c < 2; c++){
                a[r][c] = scn.nextInt();
            }
        }

        System.out.println("Enter elements of 2-D array B");
        for(int r = 0; r < 2; r++){
            for(int c = 0; c < 2; c++){
                b[r][c] = scn.nextInt();
            }
        }
    }

    private void printMenu(){
        System.out.println("2-D Arrays Operation");
        System.out.println("1. Sum two arrays");
        System.out.println("2. Difference two arrays");
        System.out.println("3. Product of two arrays");
        System.out.println("4. Transpose of two arrays");

        System.out.print("Choose one of them: ");
        choice = scn.nextInt();
    }

    private void printArrayResult(){
        for (int row = 0; row < 2; row++){
            System.out.println();
            for (int col = 0; col < 2; col++){
                System.out.println("array[" + row + "][" + col + "]= " + c[row][col]);
            }
        }
    }

    private void sumTwoArrays(){
        for (int row = 0; row < 2; row++){
            for(int col = 0; col < 2; col++){
                c[row][col] = a[row][col] + b[row][col];
            }
        }
        printArrayResult();
    }

    private void process(){
        switch (choice){
            case 1 -> sumTwoArrays();
            default -> System.out.println("Invalid option selected");
        }
    }

    public static void main(String[] args) {
        AE_TwoDimensionalArray twoDimensionalArray = new AE_TwoDimensionalArray();
        twoDimensionalArray.setup();
        twoDimensionalArray.printMenu();
        twoDimensionalArray.process();
    }
}
