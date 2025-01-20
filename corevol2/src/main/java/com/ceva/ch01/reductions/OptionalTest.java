package com.ceva.ch01.reductions;

import com.ceva.ch01.createAndTransformStreams.ACountLongWords;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class OptionalTest {
    private static final Class<?> cl = ACountLongWords.class;

    public static void main(String[] args) throws IOException{
        InputStream stream = cl.getClassLoader().getResourceAsStream("alice.txt");
        String contents = new String(stream.readAllBytes());
        List<String> wordList = List.of(contents.split("\\PL+"));

        // Optional type. es la mejor manera la falta de un valor de retorno
        Optional<String> largest = wordList.stream()
                .max(String::compareToIgnoreCase);
        System.out.println("Largest: " + largest.orElse("No value"));

        // get any word start with Q
        Optional<String> anyQWord = wordList.stream()
                .filter((word)-> word.startsWith("Z"))
                .findAny();
        System.out.println("Word with Z in text is " + anyQWord.orElse("No value"));

        // get first word with Q
        Optional<String> optionalValue = wordList.stream()
                .filter((word) -> word.startsWith("Q"))
                .findFirst();
        System.out.println("First word with Q is " + optionalValue.orElse("No value"));

        // Get first word with fred
        Optional<String> firstFredWord = wordList.stream()
                .filter((word)-> word.contains("fred"))
                .findFirst();
        System.out.println(firstFredWord.orElse("No value") + " contains fred");

        // si hay un match
        boolean aWordStartWithX = wordList.stream()
                .parallel()
                .anyMatch((word)-> word.startsWith("X"));
        System.out.println("is there a word who start with X: " + aWordStartWithX);

        
    }
}
