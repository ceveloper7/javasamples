package com.ceva.ch03;

import com.ceva.model.Apple;
import com.ceva.model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest3 {

    private List<Apple> passingConstructorReferencesToMap(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> results = new ArrayList<>();
        for (Integer i : list){
            results.add(f.apply(i));
        }
        return results;
    }

    private void constructorReferences1(){
        Supplier<Apple> c1 = () -> new Apple(850, Color.GREEN);
        Apple a1 = c1.get();
        System.out.println(a1);

        // Using references constructor with no arguments
        Supplier<Apple> c2 = Apple::new;
        Apple a2 = c2.get();
        System.out.println(a2);
    }

    // reference constructor with one arguments
    private void constructorReferences2(){
        Function<Integer, Apple> c1 = (weight) -> new Apple(weight);
        Apple a1 = c1.apply(777);
        System.out.println(a1);

        // Using constructor references
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(888);
        System.out.println(a2);
    }

    // pass each elements to constructor
    private void constructorReferences3(){
        List<Integer> in = Arrays.asList(700, 680, 885, 400);
        List<Apple> apples = passingConstructorReferencesToMap(in, Apple::new);
        System.out.println(apples);
    }

    // references constructor with two arguments
    private void constructorReferences4(){
        BiFunction<Integer, Color, Apple> c4 = (weight, color) -> new Apple(weight, color);
        Apple a3 = c4.apply(110, Color.GREEN);
        System.out.println(a3);

        BiFunction<Integer, Color, Apple> c5 = Apple::new;
        Apple a4 = c5.apply(190, Color.RED);
        System.out.println(a4);
    }

    public static void main(String[] args) {
        ConstructorRefTest3 c = new ConstructorRefTest3();
        c.constructorReferences1();
        c.constructorReferences2();
        c.constructorReferences3();
        c.constructorReferences4();
    }
}
