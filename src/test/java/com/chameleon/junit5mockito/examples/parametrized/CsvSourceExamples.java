package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 24
 */
public class CsvSourceExamples {

    @ParameterizedTest
    @CsvSource({ // определяем источник значений
            "1, 1",
            "2, 8",
            "3, 27",
            "4, 64",
            "5, 125",
            "6, 216",
            "7, 343",
            "8, 512",
            "9, 729",
            "10, 1000",
    })
    void testWithCsvSource(double value, double expected) {
        double actual = Math.pow(value, 3); // возводим значение в куб
        assertEquals(expected, actual); // проверяем, что ожидаемое значение равно возведённому в куб
    }
}
