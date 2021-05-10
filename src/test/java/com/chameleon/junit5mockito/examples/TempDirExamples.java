package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example 33
 * Для наглядности запускать в режиме debug
 * Путь до временной директории в Windows обычно C:\Users\xxxxxx\AppData\Local\Temp\xxxxxx
 */
public class TempDirExamples {

    @Test
    void writeLinesToFileTest(@TempDir Path tempDir) throws IOException {
        Path file = tempDir.resolve("test.txt"); // создаём экземпляр с временным файлом

        List<String> lines = List.of("1", "2", "3"); // создаём список с данными

        Files.write(file, lines); // записываем данные во временный файл

        assertAll(
                () -> assertTrue(Files.exists(file), "File should exist"), // проверяем, что файл существует
                () -> assertLinesMatch(lines, Files.readAllLines(file)) // построчно сравниваем значения из списка с прочитанными из файла
        );
    }
}
