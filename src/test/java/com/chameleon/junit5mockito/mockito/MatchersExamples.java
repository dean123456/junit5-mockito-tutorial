package com.chameleon.junit5mockito.mockito;

import com.chameleon.junit5mockito.models.ResponseFromExternalService;
import com.chameleon.junit5mockito.models.ResponseFromService;
import com.chameleon.junit5mockito.service.MappingServiceImpl;
import com.chameleon.junit5mockito.service.NameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.*;

/**
 * Example 43
 */
@ExtendWith(MockitoExtension.class) // расширение, инициализирующее моки
public class MatchersExamples {

    @Mock
    private NameService nameServiceMock; // создание мока с помощью аннотации

    @InjectMocks
    private MappingServiceImpl mappingService; // создание экземпляра сервиса и внедрение мока с помощью аннотации

    @Test
    void mappingResponseWithIsNotNullAndFindMatchersTest() {
        Mockito.when(nameServiceMock.getFio(isNotNull())).thenReturn("Иванов Иван Иванович"); // не null
        Mockito.when(nameServiceMock.getCompanyName(find("^65\\d"))).thenReturn("ООО Калинка"); // если соответствует регулярному выражению

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Иванов Иван Иванович",
                "ООО Калинка"
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    @Test
    void mappingResponseWithIsAAndAndMatchersTest() {
        Mockito.when(nameServiceMock.getFio(isA(String.class))).thenReturn("Петров Пётр Петрович"); // если String
        Mockito.when(nameServiceMock.getCompanyName(and(startsWith("654"), endsWith("321")))).thenReturn("ПАО Рассвет");

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654000321"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Петров Пётр Петрович",
                "ПАО Рассвет"
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    @Test
    void mappingResponseWithNotAndOrMatchersTest() {
        Mockito.when(nameServiceMock.getFio(not(eq("999999")))).thenReturn("Дмитриев Дмитрий Дмитриевич"); // если не 999999
        Mockito.when(nameServiceMock.getCompanyName(or(eq("654321"), eq("123456")))).thenReturn("ПАО Закат");

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Дмитриев Дмитрий Дмитриевич",
                "ПАО Закат"
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }
}
