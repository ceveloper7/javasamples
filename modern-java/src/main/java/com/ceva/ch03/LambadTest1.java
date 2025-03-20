package com.ceva.ch03;

import com.ceva.model.Apple;
import com.ceva.model.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambadTest1 {



    private void appleComparatorByWeight(){
        Comparator<Apple> comparator = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
        Apple.appleInventory().sort(comparator);
        System.out.println(Apple.appleInventory());
    }

    public static List<Apple> filter(List<Apple> inventory, AppleBooleanPredicate predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
           try {
               if(predicate.test(apple)){
                   result.add(apple);
               }
           }
           catch (IOException ex){
               ex.printStackTrace();
           }
        }
        return result;
    }

    private void printGreenApples(){
        List<Apple> result = filter(Apple.appleInventory(), (Apple apple) -> apple.getColor() == Color.GREEN);
        System.out.println(result);
    }

    public static void main(String[] args) {
        LambadTest1 t = new LambadTest1();

        System.out.println("--> Ordering Apples by weight");
        t.appleComparatorByWeight();

        System.out.println();

        System.out.println("--> Print green Apples");
        t.printGreenApples();

    }
}
