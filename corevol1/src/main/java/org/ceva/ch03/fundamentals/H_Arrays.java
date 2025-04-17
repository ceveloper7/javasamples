package org.ceva.ch03.fundamentals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class H_Arrays {
    public static void main(String[] args) {
        H_Arrays arrays = new H_Arrays();
        arrays.testScoreAverage();
    }

    private void testScoreAverage(){
        final int NUMBER_OF_STUDENTS = 5;
        int[] marks = new int[NUMBER_OF_STUDENTS];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (int i = 0; i < NUMBER_OF_STUDENTS; i++){
                System.out.println("Enter marks of Student #" + (i+1) + ": ");
                String str = reader.readLine();
                marks[i] = Integer.parseInt(str);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        int total = 0;
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++){
            total += marks[i];
        }

        // convertimos variable total a float
        System.out.println("Average marks: " + (float)total/NUMBER_OF_STUDENTS);
    }

    private void arrayOperations(){
        // 1. Copiando los valores del array primesNums al array primesNumV2
        int[] primesNums = {2, 3, 5, 7, 11, 13};
        // copyOf(int1, int2) -> int1 array source, int2 longitud de primesNumV2
        int[] primesNumV2 = Arrays.copyOf(primesNums, primesNums.length);
        for(Integer prime : primesNumV2){
            System.out.println(prime);
        }

        // copiando un array a un array con doble longitud. Las posiciones vacias se llenan con 0
        int[] copyVal = Arrays.copyOf(primesNums, 2 * primesNums.length);
    }

    private void arraysBasics(){
        //1. definicion e inicializacion de un array de manera antigua
        String[] names = new String[3];
        names[0] = "Manuel";
        names[1] = "Mario";
        names[2] = "Luis";

        // 2. Definicion e inicializacion de un array de forma abreviada
        int[] smallPrimes = {2,3,5,7,11,13};
        int[] otherNums = {4,6,8,12,40};
        String[] languaages = {"English", "Spanish", "German", "French"};

        // 3. reinicializamos el array otherNums con un nuevo array anonimo
        otherNums = new int[]{2,4,6,8};
        int[] moreNums = otherNums;

        // Accediendo a los elementos de un Array
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }

        // for each loop: for(variable : collection) statement(s)
        System.out.println();
        for(String name : names){
            System.out.println(name);
        }
    }
}
