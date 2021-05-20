package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.JRE.*;

/**
 * Example 12
 */
public class JREConditionalExamplesTest {

    @Test
    @EnabledOnJre(JAVA_8) // Тест отработает только в Java 8
    void enabledOnJava8Test() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @EnabledOnJre(JAVA_11) // Тест отработает только в Java 11
    void enabledOnJava11Test() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @DisabledOnJre(value = {JAVA_9, JAVA_10}) // Тест не отработает в Java 9 и Java 10
    void disabledOnJava9Test() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @EnabledForJreRange(min = JAVA_8, max = JAVA_11) // Тест отработает c Java 8 по Java 11
    void enabledOnJava8_11Test() {
        assertEquals(25, 5 * 5);
    }
}
