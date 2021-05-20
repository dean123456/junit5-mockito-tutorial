package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Example 13
 */
public class JVMPropertiesConditionalExamplesTest {

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*") // Тест отработает, если системное свойство соответствует регулярному выражению
    void enabledOn64BitArchitecturesTest() {
        assertEquals("amd64", System.getProperty("os.arch"));
    }

    @Test
    @DisabledIfSystemProperty(named = "os.name", matches = "Windows.*") // Тест не отработает, если системное свойство соответствует регулярному выражению
    void disabledOnWindowsTest() {
        assertNotEquals("Windows 10", System.getProperty("os.name"));
    }
}
