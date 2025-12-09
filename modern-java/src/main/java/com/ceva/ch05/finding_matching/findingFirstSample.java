package com.ceva.ch05.finding_matching;

import java.util.List;
import java.util.Optional;

/**
 * findFirst funciona similar a findAny
 */
public class findingFirstSample {
    public static void main(String[] args) {
        List<Integer> someNumbers = List.of(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers
                .stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        System.out.println(firstSquareDivisibleByThree.get());
    }
}
