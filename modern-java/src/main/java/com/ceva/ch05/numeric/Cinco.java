package com.ceva.ch05.numeric;

import java.util.stream.IntStream;

/**
 * 5.7.2 Rangos numericos
 */
public class Cinco {
    public static void main(String[] args) {
        IntStream evenNumbers = IntStream
                .rangeClosed(1, 10)
                .filter(n -> n % 2 == 0);

        System.out.println("Los numeros pares entre 1 - 10 inclusivo son: " + evenNumbers.count());
    }
}
