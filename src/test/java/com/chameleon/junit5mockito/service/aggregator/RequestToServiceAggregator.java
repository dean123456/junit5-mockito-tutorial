package com.chameleon.junit5mockito.service.aggregator;

import com.chameleon.junit5mockito.models.ClientType;
import com.chameleon.junit5mockito.models.RequestToService;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.UUID;

/**
 * Пользовательский агрегатор аргументов класса RequestToService
 */
public class RequestToServiceAggregator implements ArgumentsAggregator {
    @Override
    public RequestToService aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        return new RequestToService(
                UUID.fromString(accessor.getString(0)),
                ClientType.valueOf(accessor.getString(1)),
                accessor.getString(2),
                accessor.getString(3),
                accessor.getString(4)
        );
    }
}
