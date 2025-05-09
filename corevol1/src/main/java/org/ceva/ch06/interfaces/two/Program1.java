package org.ceva.ch06.interfaces.two;

import java.util.function.IntConsumer;

/**
 * 6.2.8 Processing Lambda Expressions
 */
public class Program1 {
    public static void repeat(int times, Runnable action){
        for(int i = 0; i < times; i++){
            action.run();
        }
    }

    public static void repeatWithConsumer(int times, IntConsumer action){
        for(int i = 1; i <= times; i++){
            action.accept(i);
        }
    }

    public static void main(String[] args) {
        Program1.repeatWithConsumer(10, (int i) -> System.out.println("Hello world Java " + i));
    }
}
