package com.ceva.ch03;

import com.ceva.model.Apple;
import com.ceva.model.Color;
import com.ceva.model.Util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest2 {

    private void printRedApplesUsingPredicate(){
        Predicate<Apple> applePredicate = (Apple apple) -> apple.getColor() == Color.RED;
        List<Apple> apples = Util.filter(Apple.appleInventory(), applePredicate);

        System.out.println(apples);
    }

    private void printAppleDataUsingConsumer(){
        Consumer<Apple> appleData = (Apple apple) -> System.out.println("Apple: " + apple.getWeight() + ", Color: " + apple.getColor());
        Util.forEach(Apple.appleInventory(), appleData);
    }

    private void printDataUsingFunction(){
        List<Integer> data = Util.map(Arrays.asList("Lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(data);
    }

    public static void main(String[] args) {
        LambdaTest2 t = new LambdaTest2();
        // t.printRedApplesUsingPredicate();
        t.printAppleDataUsingConsumer();
        t.printDataUsingFunction();
    }
}
