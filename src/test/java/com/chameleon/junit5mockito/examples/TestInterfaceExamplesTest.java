package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 20
 * Тестовый класс имплементирует интерфейс CommonLogger, в котором default методы аннотированы аннотациями жизненного цикла
 */
public class TestInterfaceExamplesTest implements CommonLogger{

    @Test
    @DisplayName("TEST 1")
    void test_1() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @DisplayName("TEST 2")
    void test_2() {
        assertEquals(36, 6 * 6);
    }
}
