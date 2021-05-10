package com.chameleon.junit5mockito.service.aggregator;

import com.chameleon.junit5mockito.models.RequestToExternalService;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Пользовательский агрегатор аргументов класса RequestToExternalService
 */
public class RequestToExternalServiceAggregator implements ArgumentsAggregator {
    @Override
    public RequestToExternalService aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        return new RequestToExternalService(
                accessor.getString(5),
                accessor.getString(6),
                accessor.getString(7),
                accessor.getString(8),
                accessor.getBoolean(9),
                Arrays.stream(accessor.getString(10).split(","))
                        .collect(Collectors.toList())
        );
    }
}
