package ch03;

import java.util.Scanner;

public class AD_ArraySortsDemo {
    private Scanner scn = new Scanner(System.in);
    private static final int MAX_SIZE = 5;
    private int[] arr = new int[MAX_SIZE];
    private int choice = 0;
    private int numberOfElements = 0;

    private void setup(){
        System.out.print("Enter number of elements in arra: ");
        numberOfElements = scn.nextInt();

        System.out.println("Enter elements of array");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = scn.nextInt();
        }
    }

    private void printMenu(){
        System.out.println("*** Array Sort Techniques ***");
        System.out.println("1. Selection sort array");

        choice = scn.nextInt();
    }

    private void printArrayElements(){
        for (int i = 0; i < numberOfElements; i++){
            System.out.print(arr[i] + "\t");
        }
    }

    private void selectionSortArray(){
        int min = 0;
        int pos = 0;
        int temp = 0;

        for(int i = 1; i < numberOfElements; i++){
            min = arr[i - 1];
            pos = i - 1;
            for(int j = i; j < numberOfElements; j++){
                if(arr[j] < min){
                    min = arr[j];
                    pos = j;
                }
            }
            if(pos != i - 1){
                temp = arr[pos];
                arr[pos] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }

        printArrayElements();
    }

    private void process(){
        if(numberOfElements > MAX_SIZE){
            System.out.println("Overflow error");
        }else{
            switch (choice){
                case 1 -> selectionSortArray();
                default -> System.out.println("input value not accepted");
            }
        }
    }

    public static void main(String[] args) {
        AD_ArraySortsDemo sortsDemo = new AD_ArraySortsDemo();
        sortsDemo.setup();
        sortsDemo.printMenu();
        sortsDemo.process();
    }

}
