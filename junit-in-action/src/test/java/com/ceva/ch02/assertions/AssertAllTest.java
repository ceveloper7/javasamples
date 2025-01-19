package com.ceva.ch02.assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * assertAll este metodo verificara todas las aserciones (afirmaciones), incluso de alguna de ellas falla
 */
public class AssertAllTest {
    @Test
    @DisplayName("SUT should default to not being under current verification")
    void testSystemNotVerified(){
        SUT systemUnderTest = new SUT("Our system under test");
        assertAll("By default, SUT is not under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified())
        );
    }

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification() {
        SUT systemUnderTest = new SUT("Our system under test");

        systemUnderTest.verify();

        assertAll("SUT should be under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified())
        );
    }

    @Test
    @DisplayName("SUT should have no current job")
    void testNoJob(){
        SUT systemUnderTest = new SUT("Our system under test");
        assertNull(systemUnderTest.getCurrentJob(), ()-> "There should no be current job");
    }
}
