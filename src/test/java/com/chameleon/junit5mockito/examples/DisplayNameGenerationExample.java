package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 9
 * По очереди раскомментировать аннотации. Также есть вариант в src/test/resources/junit-platform.properties
 */
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // заменяет символы подчёркивания на пробелы в именах тестовых методов
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) // создает полные предложения, объединяя имена тестовых методов и класса их включающих
//@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class) // создает полные предложения, объединяя имена тестовых методов и класса их включающих, используя кастомный разделитель
public class DisplayNameGenerationExample {

    @Test
    void display_name_without_underscores() {
        assertEquals(25, 5 * 5);
    }

}
