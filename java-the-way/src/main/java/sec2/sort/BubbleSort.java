package sec2.sort;

import java.util.Arrays;

public class BubbleSort {
    private static void ordenamiento(int[] array){
        System.out.println(Arrays.toString(array));

        int iter = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                iter++;
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println("Nro iteraciones: " + iter);
    }

    public static void main(String[] args) {
        int[] a = {5,6,9,8,5,6,3,2,5,7};
        ordenamiento(a);
    }
}
