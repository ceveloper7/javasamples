package com.ceva.ex1.ch04.arrays.onedimension;

public class Windy {
    // 1. Declaracion de constantes
    private static final int MAX_SPEED = 200;
    private static final int MAX_DEGREE = 360;
    private static final int LENGTH = 5;

    public static void main(String[] args) {
        // declaramos 2 arrays.
        int[] windSpeed = new int[LENGTH];
        int[] windDirection = new int[LENGTH];

        // 2. Cargamos los arrays con valores aleatorios.
        for(int i = 0; i < LENGTH; i++){
            // creamos dos valores aleatorios. (Math.random() retorna y valor entre 0 - 1)
            windSpeed[i] = (int)(Math.random() * MAX_SPEED); // 0 - 199
            windDirection[i] = (int)(Math.random() * MAX_DEGREE); // 0- 359
        }

        // 3. Accedemos a la informacion de los arrays
        for(int i = 0; i < LENGTH; i++){
            System.out.printf("Wind speed %d km/h and wind direction %d", windSpeed[i], windDirection[i]);

            if(i != LENGTH-1)
                System.out.print(", ");
        }
    }
}
