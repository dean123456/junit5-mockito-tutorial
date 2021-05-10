package com.chameleon.junit5mockito.examples.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Example 29
 */
public class ArgumentsAggregatorExamples {

    @ParameterizedTest
    @CsvSource({ // определяем источник значений
            "1, One, true",
            "2, Two, false"
    })
    void argumentsAccessorTest(ArgumentsAccessor arguments) { // внедряем экземпляр ArgumentsAccessor для доступа к значениям по индексу
        int intValue = arguments.getInteger(0);
        String stringValue = arguments.getString(1);
        boolean booleanValue = arguments.getBoolean(2);


        if (intValue == 1) {
            assertEquals("One", stringValue);
            assertTrue(booleanValue);
        } else {
            assertEquals("Two", stringValue);
            assertFalse(booleanValue);
        }
    }
}
