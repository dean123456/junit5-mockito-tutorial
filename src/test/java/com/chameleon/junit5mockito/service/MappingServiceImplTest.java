package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.ClientType;
import com.chameleon.junit5mockito.models.RequestToExternalService;
import com.chameleon.junit5mockito.models.RequestToService;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MappingServiceImplTest {

    MappingService mappingService = new MappingServiceImpl();

    @Test
    void mappingRequestWithClientTypeIndividualTest() {
        RequestToService requestToService = new RequestToService(
                UUID.fromString("a095d420-c73f-4814-947f-81365c15c992"),
                ClientType.INDIVIDUAL,
                "XYZ",
                "123456"
        ); // создали запрос в сервис

        RequestToExternalService expected = new RequestToExternalService(
                "a095d420-c73f-4814-947f-81365c15c992",
                "FL",
                "XYZ000001",
                "123456",
                true
        ); // создали ожидаемый запрос во внешнюю систему

        RequestToExternalService actual = mappingService.mappingRequest(requestToService); // передали в тестируемый метод запрос и получили результат

        //Проверяем по отдельности каждое поле
        assertEquals(expected.getRequestId(), actual.getRequestId());
        //assertEquals(expected.getRequestId(), actual.getRequestId() + " something wrong", "These values are not equivalent"); // пример отображения сообщения, выводимого в консоль в случае неэквивалентности
        assertEquals(expected.getType(), actual.getType());
        assertEquals(expected.getFrom(), actual.getFrom());
        assertEquals(expected.getId(), actual.getId());
        assertTrue(actual.getFlag());
    }


    @Test
    void mappingResponse() {
    }
}