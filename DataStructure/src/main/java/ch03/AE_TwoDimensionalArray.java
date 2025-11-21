package ch03;

import java.util.Scanner;

public class AE_TwoDimensionalArray {
    private Scanner scn = new Scanner(System.in);
    int[][] a = new int[3][3];
    int[][] b = new int[3][3];
    int[][] c = new int[3][3];
    private int choice;

    private void setup(){
        if(choice == 4){
            System.out.println("Enter elements of array to Transpose");
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    a[r][c] = scn.nextInt();
                }
            }

            System.out.println("The elements of the matrix:");
            printArrayResult(a);

        }else{
            System.out.println("Enter elements of 2-D array A");
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    a[r][c] = scn.nextInt();
                }
            }

            System.out.println("Enter elements of 2-D array B");
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    b[r][c] = scn.nextInt();
                }
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

    private void printArrayResult(int[][] arr){
        for (int row = 0; row < 3; row++){
            System.out.println();
            for (int col = 0; col < 3; col++){
                System.out.println("array[" + row + "][" + col + "]= " + arr[row][col]);
            }
        }
    }

    private void sumTwoArrays(){
        setup();
        for (int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                c[row][col] = a[row][col] + b[row][col];
            }
        }
        printArrayResult(c);
    }

    private void transposeArray(){
        setup();
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                b[row][col] = a[col][row];
            }
        }

        System.out.println("Elements of transpose matrix");
        printArrayResult(b);
    }

    private void process(){
        switch (choice){
            case 1 -> sumTwoArrays();
            case 4 -> transposeArray();
            default -> System.out.println("Invalid option selected");
        }
    }

    public static void main(String[] args) {
        AE_TwoDimensionalArray twoDimensionalArray = new AE_TwoDimensionalArray();
        //twoDimensionalArray.setup();
        twoDimensionalArray.printMenu();
        twoDimensionalArray.process();
    }
}
