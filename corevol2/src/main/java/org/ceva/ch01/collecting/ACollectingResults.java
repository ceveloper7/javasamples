package org.ceva.ch01.collecting;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.*;

public class ACollectingResults {

    private static Stream<String> noVowels()throws IOException{
        InputStream is = ACollectingResults.class.getClassLoader().getResourceAsStream("alice.txt");
        Stream<String> words = null;
        if (is != null){
            byte[] bytes = is.readAllBytes();
            String contens = new String(bytes, StandardCharsets.UTF_8);
            List<String> wordList = List.of(contens.split("\\PL+"));
            words = wordList.stream()
                    .map(w -> w.replaceAll("[aeiouAEIOU]", ""));
        }else{
            System.out.println("resource alice.txt not found");
        }
        return words;
    }

    public static <T> void show(String label, Set<T> set)
    {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.println("["
                + set.stream().limit(10).map(Object::toString).collect(Collectors.joining(", "))
                + "]");
    }

    public static void main(String[] args) throws IOException{
        Iterator<Integer> iter = Stream
                .iterate(0, n -> n+1)
                .limit(10)
                .iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        // obtener un array de un stream
        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array:" + numbers);
        // Note it's an Object[] array

        try
        {
            var number = (Integer) numbers[0]; // OK
            System.out.println("number: " + number);
            //System.out.println("The following statement throws an exception:");
            //var numbers2 = (Integer[]) numbers; // Throws exception
        }
        catch (ClassCastException e)
        {
            System.out.println(e);
        }

        // asignamos un tipo especifico para el array que obtenemos del stream
        Integer[] numbers3 = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .toArray(Integer[]::new);
        System.out.println("Integer array: " + numbers3);
        // Note it's an Integer[] array

        // recolectar elementos de un stream a otro target (Set)
        // si el target es un List podemos usar Collectors.toList()
        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        // indicamos que queremos obtener del stream un tipo de coleccion distinta a List o Set
        TreeSet<String> noVowelsTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelsTreeSet);

        // obtenemos todos los elementos de un stream y los concatenamos
        String result = noVowels()
                .limit(10)
                .collect(Collectors.joining());
        System.out.println("Joining: " + result);

        // obtenemos todos los elementos de un stream y los concatenamos con un delimitador
        result = noVowels()
                .limit(10)
                .collect(Collectors.joining(", "));
        System.out.println("Joining with commas " + result);

        // reduce a stream a un numero
        IntSummaryStatistics summary = noVowels()
                .collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach:");
        noVowels()
                .limit(10)
                .forEach(System.out::println);


    }
}
