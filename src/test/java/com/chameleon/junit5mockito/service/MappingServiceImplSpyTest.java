package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.ResponseFromExternalService;
import com.chameleon.junit5mockito.models.ResponseFromService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

/**
 * Example 59
 */
@ExtendWith(MockitoExtension.class)
class MappingServiceImplSpyTest {

    @Spy
    private NameServiceImpl nameServiceSpy; // создание шпиона с помощью аннотации

    @InjectMocks
    private MappingServiceImpl mappingService; // создание экземпляра сервиса и внедрение шпиона с помощью аннотации

    @Test
    void mappingResponseWithSpyTest() {
        Mockito.when(nameServiceSpy.getFio(eq("123456"))).thenReturn("Иванов Иван Иванович"); // мокируем метод на возврат значения
        // Также будет вызван реальный метод getCompanyName("123456");

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Иванов Иван Иванович",
                "UNKNOWN"
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }
}