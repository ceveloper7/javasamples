package com.ceva.ch03.ordering_strategies;

import com.ceva.model.Apple;

import java.util.List;

public class AppleComparatorTest {

    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();

        inventory.sort(new AppleComparator());
        System.out.println(inventory);
    }
}
