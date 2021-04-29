package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.UUID;

/**
 * Реализация входного и выходного маппинга
 */
public class MappingServiceImpl implements MappingService {

    private static final Logger log = LoggerFactory.getLogger(MappingServiceImpl.class);

    private static final String SYSTEM_CODE = "000001";

    @Override
    public RequestToExternalService mappingRequest(RequestToService request) {
        log.info("Request before mapping: " + request);
        var requestToExternalService = new RequestToExternalService();
        requestToExternalService.setRequestId(Optional.ofNullable(request.getRequestId())
                .map(UUID::toString)
                .orElse(UUID.randomUUID().toString()));
        requestToExternalService.setType(Optional.ofNullable(request.getClientType())
                .map(this::convertType)
                .orElse(String.valueOf(ClientType.INDIVIDUAL)));
        requestToExternalService.setFrom(Optional.ofNullable(request.getSystemFrom())
                .map(v -> v.concat(SYSTEM_CODE))
                .orElseThrow(() -> new RuntimeException("Value of systemFrom must be present")));
        requestToExternalService.setId(Optional.ofNullable(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Value of clientId must be present")));
        requestToExternalService.setFlag(true);
        log.info("Request after mapping: " + requestToExternalService);
        return requestToExternalService;
    }

    @Override
    public ResponseFromService mappingResponse(ResponseFromExternalService response) {
        var responseFromController = new ResponseFromService();
        log.info("Response before mapping: " + response);
        responseFromController.setRequestId(Optional.ofNullable(response.getRequestId())
                .map(UUID::fromString)
                .orElseThrow(() -> new RuntimeException("Value of requestId must be present")));
        Optional.ofNullable(response.getCompanyName()).ifPresent(responseFromController::setFirstName);
        Optional.ofNullable(response.getCompanyName()).ifPresent(responseFromController::setLastName);
        Optional.ofNullable(response.getCompanyName()).ifPresent(responseFromController::setPatronymic);
        Optional.ofNullable(response.getCompanyName()).ifPresent(responseFromController::setCompanyName);
        log.info("Response after mapping: " + responseFromController);
        return responseFromController;
    }

    private String convertType(ClientType clientType) {
        switch (clientType) {
            case INDIVIDUAL:
                return "FL";
            case COMPANY:
                return "UL";
        }
        return null;
    }
}
