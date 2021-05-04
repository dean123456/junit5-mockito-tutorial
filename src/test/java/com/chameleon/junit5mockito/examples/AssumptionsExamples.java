package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * Example 10
 * В переменных среды добавлена переменная TEST_ENV = JUnit5
 */
public class AssumptionsExamples {

    private static final Logger log = LoggerFactory.getLogger(AssumptionsExamples.class);

    @Test
    void assumeTrueIfTestEnvEqualsJUnit5Test() {
        assumeTrue("JUnit5".equals(System.getenv("TEST_ENV"))); // тест не будет проигнорирован

        int result = 5 * 5;
        assertEquals(25, result);

        log.info("This assertion will pass. And result is {}.", result);
    }

    @Test
    void assumeFalseIfTestEnvEqualsJUnit4Test() {
        assumeFalse("JUnit4".equals(System.getenv("TEST_ENV"))); // тест не будет проигнорирован

        int result = 5 * 5;
        assertEquals(25, result);

        log.info("This assertion will pass. And result is {}.", result);
    }

    @Test
    void assumeTrueIfTestEnvEqualsJUnit3Test() {
        assumeTrue("JUnit3".equals(System.getenv("TEST_ENV")),
                "Test ignored"); // тест будет проигнорирован и будет выведено сообщение "Test ignored"
        assertEquals(25, 5 * 5);
    }

    @Test
    void assumeTrueIfTestEnvEqualsJUnit3Test2() {
        log.info("Test method started");

        assumingThat("JUnit4".equals(System.getenv("TEST_ENV")),
                () -> {
                    assertEquals(25, 5 * 5);
                    log.info("This assertion will be ignored");
                }); // результатом предположения будет false и следовательно в лог ничего не будет выведено, однако на дальнейший сценарий это никак не повлияет

        int result = 6 * 6;
        assertEquals(36, result);

        log.info("This assertion will pass. And result is {}.", result);
    }
}
