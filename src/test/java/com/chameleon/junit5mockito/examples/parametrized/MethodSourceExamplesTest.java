package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 28
 */
public class MethodSourceExamplesTest {

    List<String> docList = List.of("passport", "snils", "driver's license"); // создаём список документов

    @ParameterizedTest
    @MethodSource("docsProvider")
    void methodSourceTest(String values) {
        assertTrue(docList.contains(values)); // проверяем, что в списке документов содержатся значения предоставляемые источником значений
    }

    static Stream<String> docsProvider() { // статический фабричный метод - поставщик значений
        return Stream.of("passport", "snils", "driver's license");
    }
}
