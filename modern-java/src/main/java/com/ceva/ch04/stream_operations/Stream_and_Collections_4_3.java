package com.ceva.ch04.stream_operations;

import com.ceva.model.Dish;

import java.util.List;
import java.util.stream.Stream;

public class Stream_and_Collections_4_3 {
    // 4.3.1 Los stream solo se pueden recorrer una vez
    public void traverseOnce(){
        List<Dish> menu = Dish.crearListaDePlatos();
        Stream<Dish> dishes = menu.stream();
        dishes
                .map(Dish::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Stream_and_Collections_4_3 stream = new Stream_and_Collections_4_3();
        stream.traverseOnce();
    }
}
