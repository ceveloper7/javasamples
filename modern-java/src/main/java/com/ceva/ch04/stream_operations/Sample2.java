package com.ceva.ch04.stream_operations;

import com.ceva.model.Dish;

import java.util.List;

/**
 * Obtenemos los 3 primeros platos que superen las 800 calorias
 */
public class Sample2 {
    public static void main(String[] args) {
        List<Dish> menu = Dish.crearListaDePlatos();

        /**
         *
         */
        List<String> threeHighCaloricsDishNames =
                menu.parallelStream()
                        // Operacion intermedia: filtramos los platos con mas de 800 calorias
                        .filter((dish) -> {
                            System.out.println("filtering: " + dish.getName());
                            return dish.getCalories() > 800;
                        })
                        // Operacion intermedia: a los platos filtrados, obtenemos su nombre
                        .map((dish) ->{
                            System.out.println("mapping: " + dish.getName());
                            return dish.getName();
                        })
                        // Operacion Intermedia: del mapa de platos, limitamos a los primeros 3 elementos
                        .limit(3)
                        // Operacion terminal: retorna un resultado que no es de tipo stream como List, Integer o incluso void
                        .toList();

        for(String dishName : threeHighCaloricsDishNames){
            System.out.println(dishName);
        }
    }
}
