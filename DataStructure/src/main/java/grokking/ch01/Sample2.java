package grokking.ch01;

public class Sample2 {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,6,8,2,9};

        int sum = 0;
        int producto = 1;

        /**
         * Aunque el algoritmo recorre el array 2 veces no debemos concluir que el algoritmo tiene una complejidad temporal de Big O(2N)
         * Debemos recordar que el numero de instrucciones no influye en la complejidad algoritmica
         *
         */
        for(int val : array)
            sum += val;

        for(int val : array)
            producto *= val;

    }
}
