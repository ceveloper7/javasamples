package com.ceva.ch05.filtering_with_predicate;

import java.util.Arrays;
import java.util.List;

/**
 * Filtering unique elements
 */
public class Sample2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
