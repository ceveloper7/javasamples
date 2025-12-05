package ch01;

/**
 * Terminos no dominantes
 * En el algoritmo hay dos complejidades Big O(N) y Big O(N^2)
 * Seria un error creer hay que hacer una suma de complejidades Big O(N+N^2)
 * La complejidad dominante en este algoritmo es aquella complejidad que crece mas rapido la cual es Big O(N^2)
 */
public class Sample3 {
    public static void main(String[] args) {
        int sum = 0;
        int result = 0;

        int[] array = new int[]{3,5,7,8,3,9};

        // complejidad Big O(N)
        for(int val : array)
            sum += val;

        // Complejidad Big O(N^2)
        for(int x : array){
            for(int y : array)
                result += x * y- sum;
        }
    }
}
