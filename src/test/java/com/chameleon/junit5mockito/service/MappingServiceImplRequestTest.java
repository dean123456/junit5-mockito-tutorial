package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.ClientType;
import com.chameleon.junit5mockito.models.RequestToExternalService;
import com.chameleon.junit5mockito.models.RequestToService;
import com.chameleon.junit5mockito.service.aggregator.RequestToExternalServiceAggregator;
import com.chameleon.junit5mockito.service.aggregator.RequestToServiceAggregator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Mapping tests") // общее отображаемое имя всех тестовых результатов
class MappingServiceImplRequestTest {

    MappingService mappingService = new MappingServiceImpl();

    /**
     * Example 2
     */
    @Test
    @DisplayName("Example 2") // отображаемое имя этого теста
    void mappingRequestWithClientTypeIndividualTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                "123456",
                "passport,snils"
        ); // создали запрос в сервис

        RequestToExternalService expected = new RequestToExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "FL",
                "XYZ000001",
                "123456",
                true,
                List.of("passport", "snils")
        ); // создали ожидаемый запрос во внешнюю систему

        RequestToExternalService actual = mappingService.mappingRequest(requestToService); // передали в тестируемый метод запрос и получили результат

        // actual = null; // тест упадёт при вызове метода fail()
        if (actual == null) {
            fail("Fail because actual is null");
        }

        //Проверяем по отдельности каждое поле
        assertEquals(expected.getRequestId(), actual.getRequestId());
        //assertEquals(expected.getRequestId(), actual.getRequestId() + " something wrong", "These values are not equivalent"); // пример отображения сообщения, выводимого в консоль в случае неэквивалентности
        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getFrom(), actual.getFrom());
        assertEquals(expected.getId(), actual.getId());
        assertTrue(actual.getFlag());
        assertEquals(expected.getDocumentsList().get(0), actual.getDocumentsList().get(0));
        assertEquals(expected.getDocumentsList().get(1), actual.getDocumentsList().get(1));

        // Проверяем одну и ту же коллекцию разными способами
        assertEquals(expected.getDocumentsList(), actual.getDocumentsList());
        assertIterableEquals(expected.getDocumentsList(), actual.getDocumentsList());

        // Проверяем, что две ссылки ссылаются на разные объекты
        assertNotSame(expected, actual);
    }

    /**
     * Example 3
     */
    @Test
    @DisplayName("Successful test \uD83D\uDC4C") // отображаемое имя этого теста
    void mappingRequestWithClientTypeCompanyTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.COMPANY,
                "XYZ",
                "123456",
                "passport,snils"
        ); // создали запрос в сервис

        RequestToExternalService expected = new RequestToExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "UL",
                "XYZ000001",
                "123456",
                true,
                List.of("passport", "snils")
        ); // создали ожидаемый запрос во внешнюю систему

        RequestToExternalService actual = mappingService.mappingRequest(requestToService); // передали в тестируемый метод запрос и получили результат

        assertEquals(expected, actual); // Проверяем, что два объекта эквивалентны. Важно! Методы equals и hashCode должны быть переопределены.
    }

    /**
     * Example 4
     */
    @Test
    void mappingRequestWithNullSystemFromTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                null,
                "123456",
                "passport,snils"
        ); // создали запрос в сервис, где systemFrom = null
        assertThrows(RuntimeException.class, () -> mappingService.mappingRequest(requestToService)); // Проверяем, что выбрасывается исключение
    }

    /**
     * Example 5
     */
    @Test
    void mappingRequestWithNullClientIdTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                null,
                "passport,snils"
        ); // создали запрос в сервис, где clientId = null
        assertThrows(RuntimeException.class, () -> mappingService.mappingRequest(requestToService)); // Проверяем, что выбрасывается исключение
    }

    /**
     * Example 6
     */
    @Test
    void mappingRequestWithNullDocumentsTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                "123456",
                null
        ); // создали запрос в сервис, где documents = null
        assertThrows(RuntimeException.class, () -> mappingService.mappingRequest(requestToService)); // Проверяем, что выбрасывается исключение
    }

    /**
     * Example 7
     */
    @Test
    void mappingRequestWithEmptyDocumentsTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                "123456",
                ""
        ); // создали запрос в сервис, где documents - пустая строка
        assertThrows(RuntimeException.class, () -> mappingService.mappingRequest(requestToService)); // Проверяем, что выбрасывается исключение
    }

    /**
     * Example 8
     */
    @Test
    void mappingRequestWithClientTypeIndividualAssertAllTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                "123456",
                "passport,snils"
        ); // создали запрос в сервис

        RequestToExternalService expected = new RequestToExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "FL",
                "XYZ000001",
                "123456",
                true,
                List.of("pass\\w*","snils") // список содержит регулярное выражение
        ); // создали ожидаемый запрос во внешнюю систему

        RequestToExternalService actual = mappingService.mappingRequest(requestToService); // передали в тестируемый метод запрос и получили результат

        assertAll("Assert all", // можно проверять сразу несколько выражений
                () -> {
                    String type = actual.getType();
                    assertNotNull(type);
                    assertAll("Type", // проверка начнётся, только, если будет пройдена проверка в предыдущей строчке
                            () -> assertTrue(type.startsWith("F")),
                            () -> assertTrue(type.endsWith("L")));
                },
                () -> assertLinesMatch(expected.getDocumentsList(), actual.getDocumentsList())); // проверка построчно
    }

    /**
     * Example 30
     */
    @ParameterizedTest(name = "{index} => test with {1}")
    @CsvSource({
            "a095d420-c73f-4814-947f-81365c15c992, INDIVIDUAL, XYZ, 123456, 'passport,snils', a095d420-c73f-4814-947f-81365c15c992, FL, XYZ000001, 123456, true, 'passport,snils'",
            "d455d420-c73f-4814-947f-81365c15c992, COMPANY, XYZ, 123456, 'passport,snils', d455d420-c73f-4814-947f-81365c15c992, UL, XYZ000001, 123456, true, 'passport,snils'",
    }) // в каждой строчке значения полей как передоваемого объекта, так и ожидаемого результата
    @DisplayName("Example 30") // отображаемое имя этого теста
    void mappingRequestWithClientTypeIndividualWithAggregatorsTest( // внедрение пользовательских агрегаторов
            @AggregateWith(RequestToServiceAggregator.class) RequestToService requestToService,
            @AggregateWith(RequestToExternalServiceAggregator.class) RequestToExternalService expected
            ) {

        RequestToExternalService actual = mappingService.mappingRequest(requestToService); // передали в тестируемый метод запрос и получили результат

        assertEquals(expected, actual);
    }
}