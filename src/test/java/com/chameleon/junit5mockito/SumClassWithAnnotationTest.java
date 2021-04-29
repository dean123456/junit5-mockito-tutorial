package com.chameleon.junit5mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SumClassWithAnnotationTest {

    @Mock
    SumClass sumClass;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sumClassIsNull() {
        assertNotNull(sumClass);
    }
}