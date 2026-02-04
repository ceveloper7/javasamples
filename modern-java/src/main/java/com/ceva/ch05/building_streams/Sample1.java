package com.ceva.ch05.building_streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Sample1 {

    // 1. Building a stream with explicit values
    private void streamFromValues(){
        Stream<String> stream = Stream.of("Moder", "Java", "In", "Action");
        stream
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // 2. Stream from nullable
    private void streamNullable(){
        String home = System.getProperty("user.home");
        Stream<String> homeValueStream = home == null ?   Stream.empty() : Stream.of(home);
        homeValueStream.forEach(System.out::println);
    }

    // 3. Using Stream,ofNullable
    private void streamOfNullable(){
        Stream<String> property = Stream.ofNullable(System.getProperty("user.home"));
        property.forEach(System.out::println);
    }

    // 4. Using stream ofNullable with flatMap
    private void streamOfNullableV2(){
        Stream<String> values = Stream
                .of("os.arch", "os.name", "os.version")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        values.forEach(System.out::println);
    }

    // 5. Stream from arrays
    private void streamFromArray(){
        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers)
                .sum();

        System.out.println("Sum is: " + sum);
    }

    // 6. Stream from file
    private void streamFromFiles(){
        Path basePath = Path.of(System.getProperty("user.home") + "/magna-carta.txt");
        long uniqueWords = 0;

        try(Stream<String> lines = Files.lines(Paths.get(basePath.toUri()))){
            uniqueWords = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }catch (IOException e){}

        System.out.println("Unique words: " + uniqueWords);
    }

    public static void main(String[] args) {
        Sample1 sample = new Sample1();
        sample.streamFromValues();
        sample.streamNullable();
        sample.streamOfNullable();
        sample.streamOfNullableV2();
        sample.streamFromArray();

        sample.streamFromFiles();
    }
}
