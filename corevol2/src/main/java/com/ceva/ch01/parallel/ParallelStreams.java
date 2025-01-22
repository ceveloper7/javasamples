package com.ceva.ch01.parallel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ParallelStreams {
    private static List<String> getData() throws IOException {
        InputStream is = ParallelStreams.class.getClassLoader().getResourceAsStream("alice.txt");
        List<String> words = null;
        if(is != null){
            byte[] bytes = is.readAllBytes();
            String contents = new String(bytes, StandardCharsets.UTF_8);
            words = List.of(contents.split("\\PL+"));
        }
        else{
            System.out.println("alice.txt file not found");
        }

        return words;
    }

    public static void main(String[] args) throws IOException{
        List<String> wordList = getData();

        // Un ejemplo de lo que no debemos hacer
        var shortWords = new int[10];
        // MAL CODIGO: forEach() se ejecuta en multiples hilos cada uno actualizando el array compartido
        wordList.parallelStream().forEach(s ->
        {
            if (s.length() < 10) shortWords[s.length()]++;
        });
        // ERROR = RACE CONDITIONS
        System.out.println(Arrays.toString(shortWords));

        // Try again--the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s ->
        {
            if (s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        //******************************//
        // Calculo paralelizado seguro  //
        //******************************//
        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                // agrupamos String por length y los contamos
                .collect(groupingBy(String::length, counting()));
        System.out.println(shortWordCounts);

        // Downstream order not deterministic
        Map<Integer, List<String>> result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(13));

        result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
                groupingByConcurrent(String::length, counting()));
        System.out.println(wordCounts);
    }
}
