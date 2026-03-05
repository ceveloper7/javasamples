package com.ceva.ch02;

import com.ceva.model.Apple;

import java.util.List;

public class FormattingAppleStrategies {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormater formatter){
        for (Apple apple : inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
