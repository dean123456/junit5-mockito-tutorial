package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 18
 */
@DisplayName("TestInfoExamples") // общее отображаемое имя всех тестовых результатов
class TestInfoExamples {

    private static final Logger log = LoggerFactory.getLogger(TestInfoExamples.class);

    TestInfoExamples(TestInfo testInfo) {
        assertEquals("TestInfoExamples", testInfo.getDisplayName()); // проверяем, что имя класса соответствует указанному
        log.info("{} class is constructed ", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String methodName = testInfo.getTestMethod()
                .map(Method::getName)
                .orElseThrow(); // получаем имя метода
        String className = testInfo.getTestClass()
                .map(Class::getName)
                .orElseThrow(); // получаем имя класса
        log.info("Test method {} from test class {} with name {} is started",
                methodName,
                className,
                testInfo.getDisplayName());
    }

    @Test
    @DisplayName("TEST 1") // отображаемое имя тестового метода
    @Tag("my-tag") // присваиваем методу именованый тег
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName()); // проверяем, что отображаемое имя метода соответствует указанному
        assertTrue(testInfo.getTags().contains("my-tag")); // проверяем, что в информации о тесте содержится указанный тег
    }

    @Test
    void test2() {
    }

}