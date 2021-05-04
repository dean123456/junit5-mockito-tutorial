package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * Example 11
 */
public class OSConditionalExamples {

    @Test
    @EnabledOnOs(MAC) // Тест отработает только в Mac OS
    void enabledOnMacOsTest() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @EnabledOnOs(WINDOWS)
        // Тест отработает только в Windows
    void enabledOnWindowsTest() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @DisabledOnOs(LINUX)
        // Тест не отработает только в Linux
    void disabledOnLinuxTest() {
        assertEquals(25, 5 * 5);
    }
}
