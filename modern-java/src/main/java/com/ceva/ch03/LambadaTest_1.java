package com.ceva.ch03;

import com.ceva.model.Apple;
import com.ceva.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambadaTest_1 {

    List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(77, Color.GREEN),
            new Apple(91, Color.RED),
            new Apple(77, Color.GREEN),
            new Apple(88, Color.RED),
            new Apple(110, Color.GREEN)
    );

    private void appleComparatorByWeight(){
        Comparator<Apple> comparator = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
        inventory.sort(comparator);
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory, AppleBooleanPredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private void printGreenApples(){
        List<Apple> result = filter(inventory, (Apple apple) -> apple.getColor() == Color.GREEN);
        System.out.println(result);
    }

    public static void main(String[] args) {
        LambadaTest_1 t = new LambadaTest_1();

        System.out.println("--> Ordering Apples by weight");
        t.appleComparatorByWeight();

        System.out.println();

        System.out.println("--> Print green Apples");
        t.printGreenApples();

    }
}
