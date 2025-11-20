package com.ceva.ch04.stream_operations;

import com.ceva.model.Dish;

import java.util.Comparator;
import java.util.List;

/**
 * Stream: secuencia de elementos de una fuente que soporta operaciones de procesamiento de datos.
 * Encadenando operaciones en un stream para formar un pipeline
 *
 * menu --> filter --> sorted --> map --> toList()
 */
public class Sample1 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        List<String> lowCaloricDishesName =
                 menu.stream()
                // parallelStream se usa para ejecutar el codigo en paralelo usando multicore platform
                //menu.parallelStream()
                // Encadenamiento de Operaciones Intermedias:
                // Seleccionamos platos menores a 400 calorias
                .filter((dish)-> dish.getCalories() < 400)
                // ordenamos la lista por calorias
                .sorted(Comparator.comparing(Dish::getCalories))
                // extraemos los nombre de los platos
                .map(Dish::getName).limit(5)
                // guardamos los nombres de platos en una lista
                .toList();

        for (String dishName : lowCaloricDishesName)
        {
            System.out.println(dishName);
        }
    }
}
