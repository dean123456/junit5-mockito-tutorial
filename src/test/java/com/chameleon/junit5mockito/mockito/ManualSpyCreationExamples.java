package com.chameleon.junit5mockito.mockito;

import com.chameleon.junit5mockito.service.MappingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example 57
 * Ручное создание шпиона
 */
public class ManualSpyCreationExamples {

    // 1 способ
    MappingServiceImpl mappingService = new MappingServiceImpl();
    MappingServiceImpl spy = Mockito.spy(mappingService);

    // 2 способ
    //MappingServiceImpl spy = Mockito.spy(MappingServiceImpl.class);

    @Test
    void spyIsNotNullTest() {
        assertNotNull(spy); // проверяем, что экземпляр шпиона не null
    }
}
