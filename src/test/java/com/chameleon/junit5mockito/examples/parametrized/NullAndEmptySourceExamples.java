package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 26
 * В оба тестовых метода передаётся по 6 значений (null, пустая строка и 4 пустых символа поддержываемых @ValueSource)
 */
public class NullAndEmptySourceExamples {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStringsWithTwoAnnotationsTest(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStringsWithOneAnnotationsTest(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
}
