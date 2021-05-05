package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 16
 * По очереди раскомментировать аннотации. Также есть вариант в src/test/resources/junit-platform.properties
 * Для реализации DisplayName ещё раскоментировать аннотации @DisplayName
 */
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Сортирует тестовые методы на основе числовых значений, указанных в @Order аннотации
//@TestMethodOrder(MethodOrderer.MethodName.class) // Сортирует тестовые методы в алфавитно-цифровом порядке на основе их имен методов и списков формальных параметров
//@TestMethodOrder(MethodOrderer.Random.class) // Псевдослучайно сортирует тестовые методы. Также можно указать начальное число.
public class OrderExamples {

    @Test // символ 'c', приведённый к int равен 99
    @Order(1)
    //@DisplayName("Third")
    void c() {
        assertEquals(25, 5 * 5);
    }

    @Test // символ 'c', приведённый к int равен 98
    @Order(2)
    //@DisplayName("Second")
    void b() {
        assertEquals(25, 5 * 5);
    }

    @Test // символ 'c', приведённый к int равен 97
    @Order(3)
    //@DisplayName("First")
    void a() {
        assertEquals(25, 5 * 5);
    }
}
