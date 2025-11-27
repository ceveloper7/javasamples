package com.ceva.ch05.mapping;

import com.ceva.model.Dish;

import java.util.List;

public class Sample3 {
    public static void main(String[] args) {
        List<Integer> dishNameLength =
                // Stream<Dish>
                Dish.crearListaDePlatos().stream()
                        // Stream<String>
                        .map(Dish::getName)
                        // Stream<Integer>
                        .map(String::length)
                        // List<Integer>
                        .toList();
    }
}
