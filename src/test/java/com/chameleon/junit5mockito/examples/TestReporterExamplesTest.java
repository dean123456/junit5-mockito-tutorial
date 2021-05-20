package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 19
 * JUnit5 позволяет добавлять дополнительную информацию в средство вывода.
 */
public class TestReporterExamplesTest {

    @Test
        // передаёт только одно значение
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("TestReporterExamplesTest");
    }

    @Test
        // передаёт ключ-значение
    void reportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("1", "One");
    }

    @Test
        // передаёт карту ключей-значений
    void reportMultipleKeyValuePairs(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("1", "One");
        values.put("2", "Two");

        testReporter.publishEntry(values);
    }
}