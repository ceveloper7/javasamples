package com.ceva.ch05.numeric;

import com.ceva.model.Dish;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Convertiendo de regreso a un Stream de Objetos
 */
public class Tres {
    public static void main(String[] args) {
        // Obtener primitive Stream
        IntStream caloriasIntStream = Dish.crearListaDePlatos()
                .stream().mapToInt(Dish::getCalories);

        Stream<Integer> stream = caloriasIntStream.boxed();
    }
}
