package com.ceva.ch02.dependencyInjection;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit inyecta el objeto TestInfo en el constructor de la clase y en tres metodos
 */
public class TestInfoTest {
    TestInfoTest(TestInfo testInfo) {
        // TestInfo de JUnit nos proporciona informacion sobre la clase
        // obtenemos el nombre de la clase de prueba
        assertEquals("TestInfoTest", testInfo.getDisplayName());
    }

    // metodo que se ejecuta antes de cada prueba. JUnit inyecta un objeto TestInfo
    @BeforeEach
    void setUp(TestInfo testInfo) {
        // obtenemos el nombre del metodo de prueba: testGetNameOfTheMethod(TestInfo)
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("display name of the method") || displayName.equals("testGetNameOfTheMethod(TestInfo)"));
    }

    @Test
    void testGetNameOfTheMethod(TestInfo testInfo) {
        assertEquals("testGetNameOfTheMethod(TestInfo)", testInfo.getDisplayName());
    }

    @Test
    @DisplayName("display name of the method")
    void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
        assertEquals("display name of the method", testInfo.getDisplayName());
    }
}
