package com.ceva.ch05.reducing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Calcular el maximo y minimo numero en un stream
 */
public class MaximunMinimumSample {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5,6,7,3,4,75,26,8,2,47);
        Optional<Integer> max = array
                .stream()
                .reduce(Integer::max);
        Optional<Integer> min = array
                .stream()
                .reduce(Integer::min);

        System.out.println("Max value in array " + max.get());
        System.out.println("Min value in array " + min.get());
    }
}
