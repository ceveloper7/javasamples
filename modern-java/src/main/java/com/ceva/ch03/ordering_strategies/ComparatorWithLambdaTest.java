package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.List;

public class ComparatorWithLambdaTest {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight()-a2.getWeight());
        System.out.println(inventory);
    }
}
