package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

/**
 * Example 27
 */
public class EnumSourceExamplesTest {

    List<String> docsList = List.of("PASSPORT", "SNILS", "DRIVERS_LICENCE"); // создаём список документов

    @ParameterizedTest
    @EnumSource(Docs.class) // определяем источник значений
    void enumSourceFromEnumClassTest(Docs docs) {
        assertTrue(docsList.contains(docs.name())); // проверяем, что в списке документов содержатся значения предоставляемые источником значений
    }

    @ParameterizedTest
    @EnumSource(value = Docs.class, mode = EXCLUDE, names = "PASSPORT") // определяем источник значений и исключаем значение "PASSPORT"
    void enumSourceFromEnumClassWithExcludeTest(Docs docs) {
        assertNotEquals("PASSPORT", docs.name()); // проверяем, что ни одно из передаваемых значений не эквивалентно "PASSPORT"
    }

    @ParameterizedTest
    @EnumSource(names = { "PASSPORT", "SNILS", "DRIVERS_LICENCE" }) // определяем источник значений
    void enumSourceTest(Docs docs) {
        assertTrue(docsList.contains(docs.name())); // проверяем, что в списке документов содержатся значения предоставляемые источником значений
    }
}
