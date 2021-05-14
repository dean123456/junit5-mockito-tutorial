package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.ResponseFromExternalService;
import com.chameleon.junit5mockito.models.ResponseFromService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;

// Example 37
@ExtendWith(MockitoExtension.class)
        // расширение, инициализирующее моки
class MappingServiceImplResponseTest {

    // Example 37
    @Mock(answer = Answers.RETURNS_SMART_NULLS) // Создание мока и установка поведения по-умолчанию
    private NameServiceImpl nameServiceMock; // создание мока с помощью аннотации

    //private MappingServiceImpl mappingService = new MappingServiceImpl(nameServiceMock); // ручное внедрение моков

    // Example 38
    @InjectMocks
    private MappingServiceImpl mappingService; // создание экземпляра сервиса и внедрение мока с помощью аннотации

    @Test
    void nameServiceMockIsNotNullTest() {
        assertNotNull(nameServiceMock); // проверяем, что экземпляр мока не null
    }

    @Test
    void mappingServiceIsNotNullTest() {
        assertNotNull(mappingService); // проверяем, что экземпляр сервиса не null
    }

    // Example 39
    @Test
    void mappingResponseWithFirstSchemeSuccessTest() {
        Mockito.when(nameServiceMock.getFio(eq("123456"))).thenReturn("Иванов Иван Иванович"); // мокируем метод на возврат значения
        Mockito.when(nameServiceMock.getCompanyName(anyString())).thenReturn(null); // мокируем метод на возврат null

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Иванов Иван Иванович",
                null
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    // Example 40
    @Test
    void mappingResponseWithFirstSchemeExceptionTest() {
        Mockito.when(nameServiceMock.getFio(any())).thenThrow(new RuntimeException("Can't find FIO")); // мокируем метод на выброс исключения

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> mappingService.mappingResponse(responseFromExternalService)); // проверяем, что при вызове метода выбрасывается исключение и получаем исключение

        assertEquals("Can't find FIO", exception.getMessage()); // проверяем, что текст исключения соответствует ожидаемому
    }

    // Example 41
    @Test
    void mappingResponseWithBDDSchemeSuccessTest() {

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "Директор Петров Пётр Петрович",
                "ОАО ПППиКо"
        ); // создали ожидаемый ответ из сервиса

        // given (дано)
        BDDMockito.given(nameServiceMock.getFio(startsWith("654"))).willReturn("Директор Петров Пётр Петрович"); // мокируем метод на возврат значения
        BDDMockito.given(nameServiceMock.getCompanyName(endsWith("321"))).willReturn("ОАО ПППиКо"); // мокируем метод на возврат значения

        // when (когда)
        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        // then (тогда)
        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    // Example 42
    @Test
    void mappingResponseWithBDDSchemeExceptionTest() {
        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали ответ из внешнего сервиса

        // given (дано)
        BDDMockito.given(nameServiceMock.getFio(matches("\\d"))).willReturn("Директор Петров Пётр Петрович"); // мокируем метод на возврат значения
        BDDMockito.willThrow(new RuntimeException("Can't find company")).given(nameServiceMock).getCompanyName(endsWith("321")); // мокируем метод на выброс исключения

        // when (когда)

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> mappingService.mappingResponse(responseFromExternalService)); // проверяем, что при вызове метода выбрасывается исключение и получаем исключение

        // then (тогда)
        assertEquals("Can't find company", exception.getMessage()); // проверяем, что текст исключения соответствует ожидаемому
    }

    // Example 44
    @Test
    void mappingResponseWithThirdSchemeSuccessTest() {
        Mockito.doNothing().doThrow(new RuntimeException("This exception will not be thrown")).when(nameServiceMock).notifyIfInnNull(); // мокируем void метод, чтобы он ничего не делал

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                null
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                null,
                null
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    // Example 45
    @Test
    void mappingResponseWithThirdSchemeExceptionTest() {
        Mockito.doThrow(new RuntimeException("Can't notify")).when(nameServiceMock).notifyIfInnNull(); // мокируем void метод на выброс исключения

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                null
        ); // создали ответ из внешнего сервиса

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> mappingService.mappingResponse(responseFromExternalService)); // проверяем, что при вызове метода выбрасывается исключение и получаем исключение

        assertEquals("Can't notify", exception.getMessage()); // проверяем, что текст исключения соответствует ожидаемому
    }

    // Example 51
    @Test
    void mappingResponssdeWithThirdSchemeSuccessTest() {
        // Нет замоканых методов. Ожидается поведение по умолчанию - RETURNS_SMART_NULLS
        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        ResponseFromService expected = new ResponseFromService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                "", // по умолчанию для String проставится пустая строка
                "" // по умолчанию для String проставится пустая строка
        ); // создали ожидаемый ответ из сервиса

        ResponseFromService actual = mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод и получили результат

        assertEquals(expected, actual); // проверяем, что ожидаемое значение эквивалентно актуальному
    }

    // Example 52
    @Test
    void mappingResponseVerifyTest() {
        Mockito.when(nameServiceMock.getFio(eq("123456"))).thenReturn("Иванов Иван Иванович"); // мокируем метод на возврат значения
        Mockito.when(nameServiceMock.getCompanyName(anyString())).thenReturn(null); // мокируем метод на возврат null

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод

        Mockito.verify(nameServiceMock).getFio(anyString()); // проверяем, что метод был вызван 1 раз
        Mockito.verify(nameServiceMock).getCompanyName(anyString()); // проверяем, что метод был вызван 1 раз
        Mockito.verify(nameServiceMock, Mockito.atLeastOnce()).getFio(anyString()); // проверяем, что метод был вызван хотя бы 1 раз
        Mockito.verify(nameServiceMock, Mockito.atLeast(1)).getFio(anyString()); // проверяем, что метод был вызван 1 раз
        Mockito.verify(nameServiceMock, Mockito.times(1)).getFio(anyString()); // проверяем, что метод был вызван 1 раз
        Mockito.verify(nameServiceMock, Mockito.atMostOnce()).getFio(anyString()); // проверяем, что метод был вызван не более 1 раза
        Mockito.verify(nameServiceMock, Mockito.atMost(1)).getFio(anyString()); // проверяем, что метод вызван не более 1 раза
        Mockito.verify(nameServiceMock, Mockito.never()).notifyIfInnNull(); // проверяем, что метод был вызван 1 раз
        //Mockito.verifyNoInteractions(nameServiceMock); // тест упадёт, т.к вызовы с указанным моком были
        //Mockito.verifyNoMoreInteractions(nameServiceMock);
    }

    // Example 53
    @Test
    void mappingResponseVerifyBDDStyleTest() {

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали ответ из внешнего сервиса

        // given (дано)
        BDDMockito.given(nameServiceMock.getFio(startsWith("654"))).willReturn("Директор Петров Пётр Петрович"); // мокируем метод на возврат значения
        BDDMockito.given(nameServiceMock.getCompanyName(endsWith("321"))).willReturn("ОАО ПППиКо"); // мокируем метод на возврат значения

        // when (когда)
        mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод

        // then (тогда)
        then(nameServiceMock).should().getFio(anyString()); // проверяем, что метод был вызван 1 раз
        then(nameServiceMock).should().getCompanyName(anyString()); // проверяем, что метод был вызван 1 раз
    }

    // Example 54
    @Test
    void mappingResponseVerifyInOrderTest() {
        Mockito.when(nameServiceMock.getFio(eq("123456"))).thenReturn("Иванов Иван Иванович"); // мокируем метод на возврат значения
        Mockito.when(nameServiceMock.getCompanyName(anyString())).thenReturn(null); // мокируем метод на возврат null

        ResponseFromExternalService responseFromExternalService = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали ответ из внешнего сервиса

        mappingService.mappingResponse(responseFromExternalService); // передали ответ в тестируемый метод

        InOrder order = Mockito.inOrder(nameServiceMock); // создание экземпляра InOrder

        // Тест пройдёт
        order.verify(nameServiceMock).getFio(anyString());
        order.verify(nameServiceMock).getCompanyName(anyString());

        // Тест не пройдёт
        /*order.verify(nameServiceMock).getCompanyName(anyString());
        order.verify(nameServiceMock).getFio(anyString());*/
    }

    // Example 55
    @Captor
    ArgumentCaptor<String> captor;

    // ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class); // ручное создание ArgumentCaptor

    // Example 56
    @Test
    void mappingResponseWithCaptorTest() {
        Mockito.when(nameServiceMock.getFio(eq("123456"))).thenReturn("Иванов Иван Иванович"); // мокируем метод на возврат значения
        Mockito.when(nameServiceMock.getCompanyName(anyString())).thenReturn(null); // мокируем метод на возврат null

        ResponseFromExternalService responseFromExternalService_1 = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "123456"
        ); // создали первый ответ из внешнего сервиса

        mappingService.mappingResponse(responseFromExternalService_1); // передали ответ в тестируемый метод

        Mockito.verify(nameServiceMock).getFio(captor.capture()); // проверяем, что метод был вызван 1 раз и сохраняем значение аргумента
        assertEquals("123456", captor.getValue()); // проверяем, что значение аргумента эквивалентно ожидаемому

        ResponseFromExternalService responseFromExternalService2 = new ResponseFromExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "654321"
        ); // создали второй ответ из внешнего сервиса

        mappingService.mappingResponse(responseFromExternalService2); // передали ответ в тестируемый метод

        Mockito.verify(nameServiceMock, times(2)).getCompanyName(captor.capture()); // проверяем, что метод был вызван 2 раза и сохраняем значение аргумента
        assertEquals("654321", captor.getValue()); // проверяем, что значение аргумента эквивалентно ожидаемому
    }

}