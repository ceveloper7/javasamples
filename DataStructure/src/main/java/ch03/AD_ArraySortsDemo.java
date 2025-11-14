package ch03;

import java.util.Scanner;

public class AD_ArraySortsDemo {
    private Scanner scn = new Scanner(System.in);
    private static final int MAX_SIZE = 6;
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
        System.out.println("2. Insertion sort array");

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

        /**
         * 1. Para cada posicion de array
         * 2. Asume que el primer elemento es el menor
         * 3. Busca si hay otro elemento mas pequeno en el resto del array
         * 4. SI lo encuentra, intercambia valores
         * 5. Continua con la siguiente posicion.
         */
        for(int i = 1; i < numberOfElements; i++){
            // suponemos que el elemento actual es el mas chico
            min = arr[i - 1];
            // almacenamos la posicion
            pos = i - 1;
            // buscamos los valores mas pequenos hasta recorrer el resto del array
            for(int j = i; j < numberOfElements; j++){
                // si encontramos un valor menos a min
                if(arr[j] < min){
                    // actualizamos min
                    min = arr[j];
                    // actualizamos la posicion donde esta el valor menor
                    pos = j;
                }
            }
            // intercambio si se encontro un nuevo numero menor
            // si el menor numero encontrado no esta en la posicion actual
            if(pos != i - 1){
                // intercambiamos valores
                temp = arr[pos];
                arr[pos] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }

        printArrayElements();
    }

    private void insertSortArray(){
        // sub-arreglo arr[1] hasta arr[i-1]
        for(int i = 1; i < numberOfElements; i++){
            // guardamos el elemento actual
            int key = arr[i];
            // partimos del elemento inmediatamente anterior al seleccionado
            int j = i - 1;
            // Mientras no salgamos del arreglo y el elemento previo sea mayor que key
            while(j >= 0 && arr[j] > key){
                // movemos arr[j] una posición a la derecha para hacer espacio para key
                arr[j + 1] = arr[j];
                // Retrocedemos para seguir comparando hacia la izquierda
                j = j - 1;
            }
            // colocamos key en el lugar correcto
            arr[j+1] = key;
        }
        printArrayElements();
    }

    private void process(){
        if(numberOfElements > MAX_SIZE){
            System.out.println("Overflow error");
        }else{
            switch (choice){
                case 1 -> selectionSortArray();
                case 2 -> insertSortArray();
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
