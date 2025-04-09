package com.ceva.ch04.stream_operations;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Stream terminal operation
 */
public class Sample3 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        // terminal operation
        menu.stream().forEach(System.out::println);
    }
}
