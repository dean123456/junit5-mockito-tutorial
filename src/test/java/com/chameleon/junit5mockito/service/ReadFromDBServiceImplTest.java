package com.chameleon.junit5mockito.service;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Example 17
 * Методы вызываются в соответствии с применяемыми аннотациями жизненного цикла
 */
class ReadFromDBServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(ReadFromDBServiceImplTest.class);

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
    void init() {
        boolean isWritten = dbService.writeAll(Map.of(
                1, "one",
                2, "two",
                3, "three")); // Инициализация БД значениями и получение флага успеха/неуспеха
        assertTrue(isWritten); // Проверка успешной инициализации
        log.info("Values inserted to DB");
    }

    @Test
    void readFromDBTest() {
        Map<Integer, String> expected = Map.of(
                1, "one",
                2, "two",
                3, "three"); // Создали ожидаемое значение

        Map<Integer, String> actual = readFromDBService.readFromDB(); // Вызвали тестируемый метод и получили результат

        assertEquals(expected, actual); // Проверяем, что два объекта эквивалентны.
        log.info("readFromDBTest asserted successfully");
    }

    @Test
    void readFromDBAfterWriteOneMoreRecordTest() {
        Map<Integer, String> expected = Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four"); // Создали ожидаемое значение

        boolean isWritten = dbService.write(4, "four"); // Добавили значение в БД
        assertTrue(isWritten); // Проверили успешное добавление значения

        Map<Integer, String> actual = readFromDBService.readFromDB(); // Вызвали тестируемый метод и получили результат

        assertEquals(expected, actual); // Проверяем, что два объекта эквивалентны.
        log.info("readFromDBAfterWriteOneMoreRecordTest asserted successfully");
    }

    @AfterEach
    void clear() {
        boolean isCleared = dbService.clear(); // Очистка БД и получение флага успеха/неуспеха
        assertTrue(isCleared); // Проверка успешной очистки
        log.info("DB cleared");
    }

    @AfterAll
    static void destroy() {
        boolean isDisconnected = dbService.disconnect(); // Отключение от БД и получение флага успеха/неуспеха
        assertTrue(isDisconnected); // Проверка успешного отключения
        log.info("Disconnected");
    }
}