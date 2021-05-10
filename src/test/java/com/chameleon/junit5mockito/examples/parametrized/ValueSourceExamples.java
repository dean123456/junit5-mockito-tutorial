package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 25
 */
public class ValueSourceExamples {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int value) {
        assertTrue(0 < value && 4 > value);
    }
}
