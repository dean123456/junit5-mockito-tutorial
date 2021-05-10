package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 23
 */
public class CsvFileSourceExamples {

    @ParameterizedTest
    @CsvFileSource(resources = "/sources/power.csv", numLinesToSkip = 1) // определяем источник значений и пропускаем первую строчку в файле
    void csvFileSourceTest(double value, double expected) {
        double actual = Math.pow(value, 2); // возводим значение в квадрат
        assertEquals(expected, actual); // проверяем, что ожидаемое значение равно возведённому в квадрат
    }
}
