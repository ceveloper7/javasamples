package ch03;

import java.util.Scanner;

public class AC_ArraySearchingDemo {
    private Scanner scn = new Scanner(System.in);
    private int numberOfElements;
    private int[] arr1;
    private int choice;

    private void setup(){
        System.out.print("Enter number of elements in array: ");
        numberOfElements = scn.nextInt();
        arr1 = new int[numberOfElements];

        System.out.println("Enter elements of array");
        for(int i = 0; i < numberOfElements; i++){
            arr1[i] = scn.nextInt();
        }
    }

    private void printMenu(){
        System.out.println("More Array Operations");
        System.out.println("1. Linear Search");
        System.out.println("2. Merge two Arrays");

        System.out.print("Enter your choice: ");
        choice = scn.nextInt();
    }
    private void linearSearch(){
        System.out.print("Enter value to search: ");
        int valueToSearch = scn.nextInt();
        int rpta = -1;
        for(int i = 0; i < numberOfElements; i++){
            if (arr1[i] == valueToSearch)
                rpta = i;
        }
        if(rpta == -1){
            System.out.println("Value not found");
        }else{
            System.out.println( valueToSearch + " found at " + (rpta+1) + " position");
        }
    }

    private void mergeTwoArrays(){
        int[] arr1, arr2, arr3;
        int i = 0, j = 0, k = 0;
        System.out.print("Enter number of elements in array 1: ");
        int m1 = scn.nextInt();
        arr1 = new int[m1];
        System.out.print("Enter elements of array 1: ");
        for (int s = 0; s < m1; s++) {
            arr1[s] = scn.nextInt();
        }

        System.out.print("Enter number of elements in array 2: ");
        int m2 = scn.nextInt();
        arr2 = new int[m2];
        System.out.print("Enter elements of array 2: ");
        for (int s = 0; s < m2; s++) {
            arr2[s] = scn.nextInt();
        }

        arr3 = new int[m1 + m2];
        while (i < m1 && j < m2) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else if (arr2[j] < arr1[i]) {
                arr3[k] = arr2[j];
                j++;
                k++;              } else {
                arr3[k] = arr1[i];
                k++;
                i++;
                arr3[k] = arr2[j];
                k++;
                j++;
            }

        } // End of while loop

        while (i < m1) {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        while (j < m2) {
            arr3[k] = arr2[j];
            k++;
            j++;      }
        System.out.println("After merging new array is: ");
        for (int s = 0; s < (m1 + m2); s++) {
            System.out.print(arr3[s] + ' ');
        }
    }

    private void process(){
        switch (choice){
            case 1 -> linearSearch();
            case 2 -> mergeTwoArrays();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    public static void main(String[] args) {
        AC_ArraySearchingDemo searchingDemo = new AC_ArraySearchingDemo();
        //searchingDemo.setup();
        searchingDemo.printMenu();
        searchingDemo.process();
    }
}
