package com.ceva.ch05.reducing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SummingSample {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1,2,3,4,5);
        int sum = array
                .stream()
                .reduce(0, (a,b) -> a + b);

        int sumShortWay = array
                .stream()
                .reduce(0, Integer::sum);

        int product = array
                .stream()
                .reduce(1, (a,b) -> a * b);

        // reduce sin un valor inicial
        Optional<Integer> suma = array
                .stream()
                .reduce((a,b) -> (a+b));

        System.out.println("Sum is: " + sum);
        System.out.println("Sum in a show way is: " + sumShortWay);
        System.out.println("Multiply is: " + product);

        System.out.println("Suma: " + suma.get());
    }
}
