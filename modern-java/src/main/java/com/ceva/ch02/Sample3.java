package com.ceva.ch02;

import com.ceva.model.Apple;

import java.util.List;

public class Sample3 {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.appleInventory();
         FormattingAppleStrategies.prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}
