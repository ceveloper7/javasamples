package org.ceva.ch01.reductions;

import org.ceva.ch01.createAndTransformStreams.ACountLongWords;

import java.io.*;
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

        // get an Optional value
        Optional<String> optionalString = Optional.empty();
        // Si no hay valor presente, obtenemos N/A
        String result = optionalString.orElse("N/A");
        System.out.println("result " + result);

        // orElseGet() lambda function solo se llama cuando se necesite
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("Result: " + result);

        // lanzamos una excepcion si no hay valor
        try{
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        }
        catch (Throwable t){
            t.printStackTrace();
        }

        // Consumiendo un valor Optional.
        optionalValue = wordList.stream()
                .filter((word) -> word.contains("red"))
                .findFirst();
        optionalValue.ifPresent((value)-> System.out.println(value + " contains red"));

        // Agregamos el valor al set
        var results = new HashSet<String>();
        optionalValue.ifPresent(results::add);

        // si Optional tiene un valor hacemos una accion, si no posee valor hacemos otra accion
        optionalValue.ifPresentOrElse(
                (value)-> System.out.println("value found: " + value),
                () -> System.out.println("value not found")
        );

        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        // Componiendo funciones de valor Option con flatMap
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));

        // chain functions
        Optional<Double> result2 = Optional.of(16.0)
                .flatMap(OptionalTest::inverse)
                .flatMap(OptionalTest::squareRoot);
        System.out.println(result2);


    }

    // Metodo que retorna un objeto de tipo Optional
    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x)
    {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
