package com.ceva.ch06;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    public static Calculator calculator;

    @BeforeAll
    static  void createCalculator(){
        calculator = new Calculator();
    }

    @Test
    void testAdd(){
        double sum = calculator.add(10, 50);
        assertEquals(60, sum, 0);
    }

    @Test
    void testSqrt(){
        double sqrt = calculator.sqrt(25);
        assertEquals(5, sqrt, 0);
    }

    @Test
    void testDivide(){
        double div = calculator.divide(25, 5);
        assertEquals(5, div, 0);
    }

    @Test
    void expectedIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()-> calculator.sqrt(-1));
    }

    @Test
    void expectedArithmeticException(){
        assertThrows(ArithmeticException.class, ()-> calculator.divide(10, 0));
    }
}
