package ch03;

import java.util.Scanner;

public class AB_ArrayDeleteDemo {

    private Scanner scn = new Scanner(System.in);
    private int[] arr = new int[5];
    private int choice = 0;
    private int value = 0;
    private int numberOfElements;
    private static final int MAX_SIZE = 5;

    private void printMenu(){
        System.out.println("*** Array Operations Menu ***");
        System.out.println("1. Delete from beginning");
        System.out.println("2. Delete from specified location");
        System.out.println("3. Delete from end");
        System.out.println("Enter your choice");

        choice = scn.nextInt();
    }

    private void printArrayElements(){
        for(int i = 0; i < numberOfElements - 1; i++){
            System.out.print(arr[i] + "\t");
        }
    }

    private void setup(){
        System.out.print("Enter the number of elements in array: ");
        numberOfElements = scn.nextInt();

        System.out.println("Enter the elements of array");
        for(int i = 0; i < numberOfElements; i++){
            arr[i] = scn.nextInt();
        }
    }

    private void deleteFromBeginning(){
        for(int i = 0; i < numberOfElements - 1; i++){
            arr[i] = arr[i+1];
        }
        System.out.println("After deletion array content is: ");
        printArrayElements();
    }

    private void deleteFromPosition(){
        System.out.print("Enter position: ");
        int pos = scn.nextInt();
        for(int i = pos-1; i < numberOfElements - 1; i++){
            arr[i] = arr[i + 1];
        }
        System.out.println("After deletion array content is:");
        printArrayElements();
    }

    private void deleteFromEnd(){
        numberOfElements -= 1;
        System.out.println("After deletion array content is");
        for(int i = 0; i < numberOfElements; i++){
            System.out.print(arr[i] + "\t");
        }
    }

    private void process(){
        if(numberOfElements == MAX_SIZE){
            System.out.println("Overflow error");
        }else{
            switch (choice){
                case 1 -> deleteFromBeginning();
                case 2 -> deleteFromPosition();
                case 3 -> deleteFromEnd();
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void main(String[] args) {
        AB_ArrayDeleteDemo deleteDemo = new AB_ArrayDeleteDemo();
        deleteDemo.setup();
        deleteDemo.printMenu();
        deleteDemo.process();
    }
}
