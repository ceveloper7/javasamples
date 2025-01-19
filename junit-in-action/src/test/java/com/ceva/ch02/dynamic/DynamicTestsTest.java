package com.ceva.ch02.dynamic;

import com.ceva.ch02.predicate.PositiveNumberPredicate;
import org.junit.jupiter.api.*;

import java.util.Iterator;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestsTest {
    private PositiveNumberPredicate predicate = new PositiveNumberPredicate();

    // Se ejecuta una vez al inicio
    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll method");
    }

    // se ejecuta una vez al final
    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll method");
    }

    // metodo que se ejecuta antes de la ejecucion del metodo @TestFactory
    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach method");
    }

    // metodo que se ejecuta despues de la ejecucion del metodo @TestFactory
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method");
    }

    /*
     * Factory method que genera tres metodos de prueba
     */
    @TestFactory
    Iterator<DynamicTest> positiveNumberPredicateTestCases() {
        return asList(
                dynamicTest("negative number", () -> assertFalse(predicate.check(-1))),
                dynamicTest("zero", () -> assertTrue(predicate.check(0))),
                dynamicTest("positive number", () -> assertTrue(predicate.check(1)))
        ).iterator();
    }
}
