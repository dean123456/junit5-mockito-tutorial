package com.chameleon.junit5mockito;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class SumClassTest {

    SumClass mock = Mockito.mock(SumClass.class);

    @Test
    void sumClassIsNull() {
        when(mock.sum()).thenReturn(5);
        BDDMockito.given(mock.sum()).willReturn(5);
        assertNotNull(mock);
    }
}