package com.chameleon.junit5mockito.examples;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface CommonLogger {

    static final Logger log = LoggerFactory.getLogger(CommonLogger.class);

    @BeforeAll
    default void beforeAllTests() {
        log.info("Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        log.info("After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        log.info(String.format("Start to execute [%s]",
                testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        log.info(String.format("Finished executing [%s]",
                testInfo.getDisplayName()));
    }
}
