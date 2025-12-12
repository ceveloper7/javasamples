package grokking.ch01;

public class Sample1 {

    public static void main(String[] args) {
        int[] array = new int[]{5,8,3,7,8,6};

        int sum = 0;
        int producto = 1;

        /**
         * algoritmo con complejidad temporal Big O(N) "Lineal"... siendo N = array.length
         * Debemos recorrer una vez cada elemento del array
         * SI el tamano del array crece entonces el tiempo de ejecucion del mismo crecera de forma lineal.
         */
        for(int val : array){
            sum += val;
            producto *= val;
        }
    }
}
