package com.ceva.ch05.mapping;

import java.util.Arrays;
import java.util.List;

/**
 * Dada una lista de palabras, obtenemos la longitud de cada palabra y la guardamos en una List
 */
public class Sample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> lengths = words.stream()
                .map(word -> word.length())
                .toList();

        lengths.forEach(System.out::println);
    }
}
