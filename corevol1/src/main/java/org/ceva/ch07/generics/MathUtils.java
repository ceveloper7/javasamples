package org.ceva.ch07.generics;

public class MathUtils {
    // restringimos el tipo de generico a valores que extiende de Number
    public static <T extends Number> double sum(T val1, T val2){
        return val1.doubleValue() + val2.doubleValue();
    }
}
