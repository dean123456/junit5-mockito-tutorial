package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example 14
 * В переменных среды добавлена переменная TEST_ENV = JUnit5
 */
public class EnvironmentConditionalExamples {

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "JUnit[45]") // Тест отработает только, если переменная среды соответствует регулярному выражению
    void enabledOnJUnit4_5Test() {
        assertEquals("JUnit5", System.getenv("TEST_ENV"));
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "JUnit5") // Тест не отработает только, если переменная среды соответствует регулярному выражению
    void disabledNotOnJUnit5Test() {
        assertNotEquals("JUnit5", System.getenv("TEST_ENV"));
    }
}
