package com.chameleon.junit5mockito.examples;

import com.chameleon.junit5mockito.service.DBService;
import com.chameleon.junit5mockito.service.DBServiceImpl;
import com.chameleon.junit5mockito.service.ReadFromDBService;
import com.chameleon.junit5mockito.service.ReadFromDBServiceImpl;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 21
 */
class RepeatedTestsExamplesTest {

    private static final Logger log = LoggerFactory.getLogger(RepeatedTestsExamplesTest.class);

    private static DBService dbService;
    private static ReadFromDBService readFromDBService;

    @BeforeAll
    static void connection() {
        dbService = new DBServiceImpl(); // Создание экземпляра сервиса, обслуживающего БД
        readFromDBService = new ReadFromDBServiceImpl(dbService); // Создание экземпляра сервиса, осуществляющего чтение из БД
        boolean isConnected = dbService.connect(); // Подключение к БД и получение флага успеха/неуспеха
        assertTrue(isConnected); // Проверка успешного подключения к БД
        log.info("Connected to DB");
    }

    @BeforeEach
    void init(RepetitionInfo repetitionInfo) { // Внедрение экземпляра RepetitionInfo
        boolean isWritten = dbService.writeAll(Map.of(
                1, "one",
                2, "two",
                3, "three")); // Инициализация БД значениями и получение флага успеха/неуспеха
        assertTrue(isWritten); // Проверка успешной инициализации

        int currentRepetition = repetitionInfo.getCurrentRepetition(); // Получение текущего повторения
        int totalRepetitions = repetitionInfo.getTotalRepetitions(); // Получение общего количества повторений
        log.info("Values inserted to DB. Repetition {} of {}", currentRepetition, totalRepetitions);
    }

    //@RepeatedTest(value = 2, name = "{displayName} ({currentRepetition}/{totalRepetitions})")
    //@RepeatedTest(value = 2, name = RepeatedTest.LONG_DISPLAY_NAME)
    @RepeatedTest(2)
    @DisplayName("ReadFromDBTest")
    void readFromDBTest(RepetitionInfo repetitionInfo) {
        Map<Integer, String> expected = Map.of(
                1, "one",
                2, "two",
                3, "three"); // Создали ожидаемое значение

        Map<Integer, String> actual = readFromDBService.readFromDB(); // Вызвали тестируемый метод и получили результат

        assertEquals(expected, actual); // Проверяем, что два объекта эквивалентны.
        log.info("readFromDBTest asserted successfully");
    }

    @AfterEach
    void clear(RepetitionInfo repetitionInfo) { // Внедрение экземпляра RepetitionInfo
        boolean isCleared = dbService.clear(); // Очистка БД и получение флага успеха/неуспеха
        assertTrue(isCleared); // Проверка успешной очистки

        int currentRepetition = repetitionInfo.getCurrentRepetition(); // Получение текущего повторения
        int totalRepetitions = repetitionInfo.getTotalRepetitions(); // Получение общего количества повторений
        log.info("DB cleared. Repetition {} of {}", currentRepetition, totalRepetitions);
    }

    @AfterAll
    static void destroy() {
        boolean isDisconnected = dbService.disconnect(); // Отключение от БД и получение флага успеха/неуспеха
        assertTrue(isDisconnected); // Проверка успешного отключения
        log.info("Disconnected");
    }
}