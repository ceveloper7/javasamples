package ch03;

import java.util.Scanner;

public class AA_ArrayInsertionDemo {

    private Scanner scn = new Scanner(System.in);
    private int[] arr = new int[5];
    private int choice = 0;
    private int value = 0;
    private int numberOfElements;
    private static final int MAX_SIZE = 5;

    private void setup(){
        System.out.print("Enter the number of elements in array: ");
        numberOfElements = scn.nextInt();

        System.out.println("Enter the elements of array");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = scn.nextInt();
        }
    }

    private void printMenu(){
        System.out.println("*** Array Operations Menu ***");
        System.out.println("1. Insertion from beginning");
        System.out.println("2. Insertion from specified location");
        System.out.println("3. Insertion from end");
        System.out.println("Enter your choice");

        choice = scn.nextInt();
    }

    private void printArrayElements(){
        for(int i = 0; i <= numberOfElements; i++){
            System.out.print(arr[i] + "\t");
        }
    }

    private void insertionFromBeginning(){
        for(int i = numberOfElements - 1; i >= 0; i--){ 
            arr[i+1] = arr[i];
        }

        System.out.print("Enter the new value: ");
        value = scn.nextInt();
        arr[0] = value;
        System.out.println("After insertion array is:");
        printArrayElements();
    }

    private void insertionAtPosition(){
        System.out.print("Enter position: ");
        int pos = scn.nextInt();

        for(int i = numberOfElements - 1; i >= pos - 1; i--) {
            arr[i + 1] = arr[i];
        }
            System.out.println("Enter new value:");
            value = scn.nextInt();
            arr[pos-1] = value;
            System.out.println("After insertion array is: ");
            printArrayElements();
    }

    private void insertionAtEnd(){
        System.out.println("Enter new value");
        value = scn.nextInt();
        arr[numberOfElements] = value;
        System.out.println("After insertion array is: ");
        printArrayElements();
    }

    private void process(){
        if (numberOfElements == MAX_SIZE){
            System.out.println("Overflow error");
        }else{
            switch (choice){
                case 1 -> insertionFromBeginning();
                case 2 -> insertionAtPosition();
                case 3 -> insertionAtEnd();
                default -> System.out.println("input value not accepted");
            }
        }
    }

    public static void main(String[] args) {
        AA_ArrayInsertionDemo arrayDemo = new AA_ArrayInsertionDemo();
        arrayDemo.setup();
        arrayDemo.printMenu();
        arrayDemo.process();
    }
}
