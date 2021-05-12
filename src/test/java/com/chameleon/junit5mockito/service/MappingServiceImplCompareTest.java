package com.chameleon.junit5mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class MappingServiceImplCompareTest {

    @Mock
    private NameService nameServiceMock; // создание мока с помощью аннотации

    @InjectMocks
    private MappingServiceImpl mappingService; // создание экземпляра сервиса и внедрение мока с помощью аннотации

    /**
     * Example 46
     */
    @Test
    void compareNamesToReturnFirstArgTest() {
        Mockito.when(nameServiceMock.compare(anyString(), anyString(), anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg()); // мокируем метод на возврат значения первого аргумента

        assertEquals("ООО Звезда", mappingService.compareNames("ООО Звезда", "ЗАО Звезда", "ПАО Звезда"));
    }

    /**
     * Example 47
     */
    @Test
    void compareNamesToReturnSecondArgTest() {
        Mockito.when(nameServiceMock.compare(anyString(), anyString(), anyString())).thenAnswer(AdditionalAnswers.returnsSecondArg()); // мокируем метод на возврат значения второго аргумента

        assertEquals("ЗАО Звезда", mappingService.compareNames("ООО Звезда", "ЗАО Звезда", "ПАО Звезда"));
    }

    /**
     * Example 48
     */
    @Test
    void compareNamesToReturnLastArgTest() {
        Mockito.when(nameServiceMock.compare(anyString(), anyString(), anyString())).thenAnswer(AdditionalAnswers.returnsLastArg()); // мокируем метод на возврат значения последнего аргумента

        assertEquals("ПАО Звезда", mappingService.compareNames("ООО Звезда", "ЗАО Звезда", "ПАО Звезда"));
    }

    /**
     * Example 49
     */
    @Test
    void compareNamesToReturnSecondArgByIndexTest() {
        Mockito.when(nameServiceMock.compare(anyString(), anyString(), anyString())).thenAnswer(AdditionalAnswers.returnsArgAt(1)); // мокируем метод на возврат значения второго аргумента

        assertEquals("ЗАО Звезда", mappingService.compareNames("ООО Звезда", "ЗАО Звезда", "ПАО Звезда"));
    }

    /**
     * Example 50
     */
    @Test
    void compareNamesToReturnCustomAnswerTest() {
        Mockito.when(nameServiceMock.compare(anyString(), anyString(), anyString())).thenAnswer(AdditionalAnswers.answer(new Answer3<String, String, String, String>() {
            @Override
            public String answer(String argument0, String argument1, String argument2) throws Throwable {
                if (argument0.compareTo(argument1) > 0) {
                    if (argument0.compareTo(argument2) > 0) {
                        return argument0;
                    } else return argument2;
                } else {
                    if (argument1.compareTo(argument2) > 0) {
                        return argument1;
                    }
                }
                return argument2;
            }
        })); // мокируем метод на возврат значения с помощью реализации функционального интерфейса

        assertEquals("ПАО Звезда", mappingService.compareNames("ООО Звезда", "ЗАО Звезда", "ПАО Звезда"));
    }



}