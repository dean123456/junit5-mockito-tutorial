package com.chameleon.junit5mockito.mockito;

import com.chameleon.junit5mockito.service.MappingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example 36
 */
public class AnnotationMockCreationExamplesTest {

    @Mock
    MappingServiceImpl mock; // создание мока с помощью аннотации

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this); // инициализация моков
    }

    @Test
    void mockIsNotNullTest() {
        assertNotNull(mock); // проверяем, что экземпляр мока не null
    }
}
