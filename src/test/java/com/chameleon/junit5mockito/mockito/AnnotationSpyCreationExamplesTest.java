package com.chameleon.junit5mockito.mockito;

import com.chameleon.junit5mockito.service.MappingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example 58
 */
public class AnnotationSpyCreationExamplesTest {

    @Mock
    MappingServiceImpl spy; // создание шпиона с помощью аннотации

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this); // инициализация моков
    }

    @Test
    void mockIsNotNullTest() {
        assertNotNull(spy); // проверяем, что экземпляр шпиона не null
    }
}
