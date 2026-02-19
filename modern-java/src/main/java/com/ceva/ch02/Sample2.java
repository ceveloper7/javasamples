package com.ceva.ch02;

import com.ceva.model.Apple;

import java.util.List;

public class Sample2 {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();
        List<Apple> result = FilterAppleStrategies.filterApples(inventory, new AppleRedAndHeavyPredicate());

        System.out.println(result);
    }
}
