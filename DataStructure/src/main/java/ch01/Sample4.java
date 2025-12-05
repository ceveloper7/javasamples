package ch01;

/**
 * Cuando N Diferente
 * A primera vista parece la complejidad Big O(N) pero los arrays poseen tamanos diferentes
 * por lo que se debe tener enn cuenta estos tamanos distintos. POr lo que la complejidad es Big O(A+B)
 */
public class Sample4 {
    public static void main(String[] args) {
        int sum = 0;
        int[] arrayA = new int[]{5,3,7,6,8,3,9};
        int[] arrayB = new int[]{7,3,4,8};

        for(int val : arrayA)
            sum += val;

        for(int val : arrayB)
            sum += val;
    }
}
