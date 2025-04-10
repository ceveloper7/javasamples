package com.ceva.ch05.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Flattering Stream
 */
public class Sample3 {
    /**
     * Case: Tenemos un stream de palabras y queremos obtener una lista de todos los caracteres unicos
     * ["Hello" "World"] ==> ['H', 'e', 'l', 'o', 'W', 'r', 'd']
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> unique = words.stream()
                // convertimos cada palabra en un Stream<String[]>
                .map(word -> word.split(""))
                // aplanamos cada stream generado en un solo Stream<String>
                .flatMap(Arrays::stream)
                // Stream<String>
                .distinct()
                // List<String>
                .toList();

        unique.forEach(System.out::print);
    }
}
