package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 31
 */
public class TimeoutExamples {


    @Disabled
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100MillisecondsTest() throws InterruptedException {
        Thread.sleep(200);
        assertEquals(25, 5 * 5);
    }
}
