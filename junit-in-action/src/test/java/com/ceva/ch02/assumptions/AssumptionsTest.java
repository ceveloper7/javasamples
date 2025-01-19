package com.ceva.ch02.assumptions;

import com.ceva.ch02.assumptions.environment.JavaSpecification;
import com.ceva.ch02.assumptions.environment.OperationSystem;
import com.ceva.ch02.assumptions.environment.TestsEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {
    private static final String EXPECTED_JAVA_VERSION = "1.8";
    private TestsEnvironment environment = new TestsEnvironment(
            new JavaSpecification(System.getProperty("java.vm.specification.version")),
            new OperationSystem(System.getProperty("os.name"), System.getProperty("os.arch"))
    );
    private SUT systemUnderTest = new SUT();

    // el metodo setUp se ejecuta antes de cada test. las pruebas no van a correr a menos que
    // la suposicion de que el actual ambiente Windows sea true
    @BeforeEach
    void setUp() {
        assumeTrue(environment.isWindows());
    }

    @Test
    void testNoJobToRun() {
        assumingThat(
                // evaluamos que la version actual de java sea como la esperada. solo si esta suposicion
                // es verdad se verifica la siguiente suposicion
                () -> environment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
                // verificamos que no exista un job actualmente en ejecucion
                () -> assertFalse(systemUnderTest.hasJobToRun()));
    }

    @Test
    void testJobToRun() {
        assumeTrue(environment.isAmd64Architecture());

        systemUnderTest.run(new Job());

        assertTrue(systemUnderTest.hasJobToRun());
    }
}
