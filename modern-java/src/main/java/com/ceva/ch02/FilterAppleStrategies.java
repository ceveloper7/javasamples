package com.ceva.ch02;

import com.ceva.model.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Declaramos un metodo filterApple que acepte un objeto ApplePredicate para evaluar una condicion
 * sobre un objeto Apple
 */
public class FilterAppleStrategies {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory)
            if (predicate.test(apple))
                result.add(apple);

        return result;
    }
}
