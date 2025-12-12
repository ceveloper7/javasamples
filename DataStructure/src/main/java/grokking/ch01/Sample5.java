package grokking.ch01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Binary search algo
 */
public class Sample5 {
    private static int binarySearch(int[] arr, int item){
        /**
         * low & high mantiene registro que parte de la lista buscaremos
         * low -> primer indice
         * high -> ultimo indice
         */
        int low = 0;
        int high = arr.length - 1;

        /**
         * Mientras aun existan elementos entre los indices low & high
         */
        while (low <= high){
            // calculamos el punto medio en el array
            int mid = (low + high) / 2;
            // obtenemos el valor medio
            int guess = arr[mid];

            // evaluamos el valor medio del array
            if(guess == item){
                // retornamos su posicion
                return mid;
            }
            // si guess > item -> el valor buscado esta a la izquierda
            else if (guess > item){
                // disminuimos high
                high = mid - 1;
            }
            // si guess menor item.
            else{
                // aumentamos low
                low = mid + 1;
            }
        }
        // no se encontro el elemento buscado.
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,4,5,6,7,9};
        int result = binarySearch(array, 3);
        System.out.println("La posicion del elemento 5 es " + result);
    }
}
