package com.ceva.ch05.mapping;

import java.util.List;

/**
 * Dado una lista de numberos [1,2,3,4,5] retornamos la raiz cuadrada de cada elementos [1,4,9,16,25]
 *
 */
public class Sample5 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);

        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .toList();

        for (Integer n : squares)
            System.out.println(n);
    }
}
