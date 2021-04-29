package com.chameleon.junit5mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SumClassWithMockitoExtensionTest {

    @Mock
    SumClass sumClass;

    @Test
    void sumClassNotNull() {
        assertNotNull(sumClass);
    }
}