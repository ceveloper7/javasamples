package com.ceva.ch05.mapping;


import java.util.Arrays;
import java.util.List;

/**
 * Dada una lista de numeros retornamos solo los pares cuya suma es divisible por 3
 * Lista 1: [1,2,3]
 * Lista 2: [3,4]
 * Result: [(1,3),(1,4), (2,3),(2,4),(3,3),(3,4)]
 */
public class Sample7 {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        List<int[]> pairs = numbers1
                // Stream<Integer> -> Strean<1,2,3>
                .stream()
                // Stream<Integer> -> Stream<1,2,3>
                .flatMap(i ->
                        // Stream<Integer> -> Stream<1,2,3,3,4>
                        numbers2.stream()
                                // Stream<Integer> -> Stream<2,4,3,3>
                                .filter(j -> (i+j)%3 ==0)
                                // Stream<int[]> -> Stream<[2,4], [3,3]>
                                .map(j -> new int[]{i,j}))
                // List<int[]> -> List<[2,4], [3,3]>
                .toList();

    }
}
