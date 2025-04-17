package org.ceva.ch03.fundamentals;

import java.util.Arrays;

public class I_ArrayMultidimensional {
    public static void main(String[] args) {
        I_ArrayMultidimensional arrayMultidimensional = new I_ArrayMultidimensional();
        arrayMultidimensional.passingArrayToMethod();
    }

    private void passingArrayToMethod(){
        int[] array = {1,2,3,4,5};

        System.out.printf("Effects of passing reference to entire array:%n" + "The values of the original array are:%n");

        for(int value : array){
            System.out.printf("   %d", value);
        }

        modifyArray(array);
        System.out.printf("%n%nThe values of the modified array are:%n");

        for(int value : array){
            System.out.printf("   %d", value);
        }

        System.out.printf("%n%nEffects of passing array element value:%n" + "array[3] before modifyElement: %d%n", array[3]);
        System.out.printf("array[3] after modifyElement: %d%n", array[3]);
    }

    private void modifyArray(int[] array2){
        for(int counter = 0; counter < array2.length; counter++){
            array2[counter] *= 2;
        }
    }

    private void modifyArrayElement(int element){
        element *= 2;
        System.out.printf("Value of element in modifyElement: %d%n", element);
    }

    private void arrayUtilitiesDemo(){
        int[] array = {4,2};
        System.out.println(Arrays.toString(array));

        Arrays.stream(array)
                .forEach(num -> System.out.println(num));

        Arrays.sort(array);
        Arrays.stream(array)
                .forEach(System.out::println);

        array = new int[]{4,2,1,5,7};
        int foundAt = Arrays.binarySearch(array, 5);
        System.out.println(foundAt);
    }

    private void arrayClassName(){
        final int SIZE = 5;
        int[] integerArray = new int[SIZE];
        float[] floatArray = new float[]{5.0f, 3.0f, 2.0f, 1.5f};
        String[] weeDays = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        int[][] jaggedArray = {
                {5,4},
                {10,15,12,15,18},
                {6,9,10},
                {12,5,8,11}
        };

        Class cls = integerArray.getClass();
        System.out.println("The class name of integerArray is: " + cls.getName());

        cls = floatArray.getClass();
        System.out.println("The class name of floatArray is: " + cls.getName());

        cls = weeDays.getClass();
        System.out.println("The class name of weekDaysArray is: " + cls.getName());

        cls = jaggedArray.getClass();
        System.out.println("The class name of jaggedArray is: " + cls.getName());
        System.out.println();

        cls = cls.getSuperclass();
        System.out.println("The super class of an array object is: " + cls.getName());
    }

    private void multiDimArrayApp(){
        final int MAX_STUDENTS = 50;
        final int MAX_SUBJECTS = 3;
        int[][] marks = new int[MAX_STUDENTS][MAX_SUBJECTS];

        // Agregamos datos al array
        for(int id = 0; id< MAX_STUDENTS; id++){
            for(int subject = 0; subject< MAX_SUBJECTS; subject++){
                marks[id][subject] = (int)(Math.random() * 100);
            }
        }

        // print array
        System.out.print("Student\t");
        for(int subject = 0; subject < MAX_SUBJECTS; subject++){
            System.out.print("\t" + "Subject " + subject);
        }
        System.out.println();
        for (int id = 0; id < MAX_STUDENTS; id++){
            System.out.print("Student " + (id+1) + "\t");
            for (int subject = 0; subject < MAX_SUBJECTS; subject++){
                if (subject >=1)
                    System.out.print("\t");
                System.out.print("\t" + marks[id][subject] + "\t");
            }
            System.out.println();
        }
    }

    private void multiDimensionalArrayBasics(){
        final int NYEARS = 5;
        final int NRATES = 10;

        // 1. definiendo
        double[][] balances = new double[NYEARS][NRATES];
        // Inicializando un array de dos dimensiones con valores literales
        int[][] numbers =
                {
                        {16,3,2,13},
                        {5,10,11,8},
                        {9,6,7,12},
                        {4,15,14,1}
                };
    }
}
