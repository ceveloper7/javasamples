package com.ceva.ch05.mapping;

import java.util.Arrays;
import java.util.List;

/**
 * Flattering Stream
 */
public class Sample4 {
    /**
     * Case: Tenemos un stream de palabras y queremos obtener una lista de todos los caracteres unicos
     * ["Hello" "World"] ==> ['H', 'e', 'l', 'o', 'W', 'r', 'd']
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> unique =
                // Stream<String>
                // Stream<"Hello","World">
                words.stream()
                // convertimos cada palabra en un Stream<String[]>
                // Stream<["H","e","l","l","o"], ["W","o","r","l","d"]>
                .map(word -> word.split(""))
                // mapeamos cada array no con un Stream<String[]> sino con el contenido del Stream<String>
                // Arrays::stream lo fusionamos en un solo Stream<"H","e","l","l","o","W","o","r","l","d">
                .flatMap(Arrays::stream)
                // Stream<"H","e","l","o","W","r","d">
                .distinct()
                // List<"H","e","l","o","W","r","d">
                .toList();

        unique.forEach(System.out::print);
    }
}
