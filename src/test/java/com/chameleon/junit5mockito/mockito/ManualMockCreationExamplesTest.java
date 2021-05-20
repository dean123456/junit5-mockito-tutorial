package com.chameleon.junit5mockito.mockito;

import com.chameleon.junit5mockito.service.MappingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example 35
 */
public class ManualMockCreationExamplesTest {

    MappingServiceImpl mock = Mockito.mock(MappingServiceImpl.class); // ручное создание мока

    @Test
    void mockIsNotNullTest() {
        assertNotNull(mock); // проверяем, что экземпляр мока не null
    }
}
