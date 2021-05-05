package com.chameleon.junit5mockito.examples.condition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 15
 * В переменных среды добавлена переменная TEST_ENV = JUnit5
 */
@EnabledIf("checkOs")
public class CustomConditionalExamples {

    @Test
    @EnabledIf("checkEnv") // Тест отработает только, если метод checkEnv вернёт true
    void enabled() {
        assertEquals(25, 5 * 5);
    }

    @Test
    @DisabledIf("checkEnv") // Тест не отработает только, если метод checkEnv вернёт true
    void disabled() {
        assertEquals(25, 5 * 5);
    }

    // Метод условия
    boolean checkEnv() {
        return "JUnit5".equals(System.getenv("TEST_ENV"));
    }

    // Статический метод условия
    static boolean checkOs(){
        return "Windows 10".equals(System.getProperty("os.name"));
    }
}
