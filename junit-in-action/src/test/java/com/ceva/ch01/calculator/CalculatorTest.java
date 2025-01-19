package com.ceva.ch01.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calc = new Calculator();
        double result = calc.add(50,10);
        // verificamos el resultado de la prueba
        // delta 0 indica que no esperamos un valor punto flotante
        assertEquals(60, result, 0);
    }
}
