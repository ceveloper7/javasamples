package com.ceva.ch05.mapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Dada una lista de numeros retornamos todos los pares de numeros
 * Lista 1: [1,2,3]
 * Lista 2: [3,4]
 * Result: [(1,3),(1,4), (2,3),(2,4),(3,3),(3,4)]
 */
public class Sample6 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(3,4);

        List<int[]> pairs =
                // Stream<[1,2,3]>
                list1.stream()
                        // Stream<1,2,3>
                        .flatMap(i ->
                                // Stream<[3,4]>
                                list2.stream()
                                    // Stream<[1,3],[1,4],[2,3],[2,4],[3,3],[3,4]>
                                    .map(j -> new int[]{i,j}))
                        .collect(toList());

    }
}
