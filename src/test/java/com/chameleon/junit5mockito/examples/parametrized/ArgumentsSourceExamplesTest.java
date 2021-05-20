package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 22
 */
public class ArgumentsSourceExamplesTest {

    List<String> docList = List.of("passport", "snils", "driver's license"); // создаём список документов

    @ParameterizedTest
    @ArgumentsSource(DocArgumentsProvider.class) // определяем источник значений
    //@ArgumentsSources(@ArgumentsSource(DocArgumentsProvider.class)) // можно передать несколько
    void argumentsSourceTest(String values) {
        assertTrue(docList.contains(values)); // проверяем, что в списке документов содержатся значения предоставляемые источником значений
    }
}
