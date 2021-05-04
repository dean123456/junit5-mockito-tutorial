package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example 14
 */
public class EnvironmentConditionalExamples {

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "JUnit[45]")
    void enabledOnJUnit4_5Test() {
        assertEquals("JUnit5", System.getenv("TEST_ENV"));
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "JUnit5")
    void disabledNotOnJUnit5Test() {
        assertNotEquals("JUnit5", System.getenv("TEST_ENV"));
    }
}
