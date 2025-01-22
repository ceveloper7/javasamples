package com.ceva.ch01.createAndTransformStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.*;

public class PrimitiveTypeStreams {

    private static Stream<String> getData() throws IOException{
        InputStream is = PrimitiveTypeStreams.class.getClassLoader().getResourceAsStream("alice.txt");
        Stream<String> words = null;
        if(is != null){
            byte[] bytes = is.readAllBytes();
            String contents = new String(bytes, StandardCharsets.UTF_8);
            words = Stream.of(contents.split("\\PL+"));
        }else{
            System.out.println("alice.txt file not found");
        }
        return words;
    }

    private static void show(String title, IntStream stream)
    {
        final int SIZE = 10;
        // toArray() retorna tipo primitivo array
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++)
        {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements[i]);
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        // create PrimitiveTypeStream
        IntStream intStream = IntStream.of(1,1,2,2,3,5);
        show("intStream", intStream);

        // create PrimitiveTypeStream second way
        int[] doubles = {5, 6, 15};
        IntStream intStream1 = Arrays.stream(doubles);
        show("intStream", intStream1);

        // generate stream primitive type
        IntStream is2 = IntStream.range(5,10);
        show("is2: ", is2);

        IntStream is3 = IntStream.rangeClosed(5,10);
        show("is3: ", is3);

        // convertir un stream de objetos a un stream de tipo primitivo
        IntStream is4 = getData().mapToInt(String::length);
        show("is4: ", is4);

        // get an IntStream of Unicode codes
        String sentence = "\uD835\uDD46 is the set of octonions";
        System.out.println(sentence);
        IntStream codes = sentence.codePoints();
        System.out.println(
                codes.mapToObj((code) -> "%X".formatted(code))
                        .collect(Collectors.joining())
        );

        // boxed() convertir un stream primitive type a object
        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5", is5);
    }
}
