package org.ceva.ch02.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestListTest {
    private List<String> values;

    @BeforeEach
    public void setUp() {
        values = new ArrayList<>();
        values.add("John");
        values.add("Michael");
        values.add("William");
    }

    @Test
    @DisplayName("List without Hamcrest will intentionally fail to show how failing information is displayed")
    public void testListWithoutHamcrest() {
        assertEquals(3, values.size());
        // assertion fail, reporte del assert sin usar hamcrest
        assertTrue(values.contains("John") || values.contains("Michael") || values.contains("William"));
    }

    @Test
    @DisplayName("List with Hamcrest will intentionally fail to show how failing information is displayed")
    public void testListWithHamcrest() {
        assertThat(values, hasSize(3));
        assertThat(values, hasItem(anyOf(equalTo("John"), equalTo("Michael"), equalTo("William"))));
        assertThat("The list doesn't contain all the expected objects, in order", values, contains("Oliver", "Jack", "Harry"));
        assertThat("The list doesn't contain all the expected objects", values, containsInAnyOrder("Jack", "Harry", "Oliver"));
    }
}
