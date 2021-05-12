package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Реализация входного и выходного маппинга
 */
public class MappingServiceImpl implements MappingService {

    private NameService nameService;

    public MappingServiceImpl() {
    }

    public MappingServiceImpl(NameService nameService) {
        this.nameService = nameService;
    }

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
        requestToExternalService.setDocumentsList(Optional.ofNullable(request.getDocuments())
                .filter(v -> v.length() != 0)
                .map(this::createDocumentsList)
                .orElseThrow(() -> new RuntimeException("List of documents must not be empty")));
        log.info("Request after mapping: " + requestToExternalService);
        return requestToExternalService;
    }

    @Override
    public ResponseFromService mappingResponse(ResponseFromExternalService response) {
        var responseFromService = new ResponseFromService();
        log.info("Response before mapping: " + response);
        responseFromService.setRequestId(Optional.ofNullable(response.getRequestId())
                .map(UUID::fromString)
                .orElseThrow(() -> new RuntimeException("Value of requestId must be present")));
        Optional.ofNullable(response.getInn()).ifPresentOrElse(inn -> {
                    responseFromService.setFio(nameService.getFio(inn));
                    responseFromService.setCompanyName(nameService.getCompanyName(inn));
                },
                () -> nameService.notifyIfInnNull());
        log.info("Response after mapping: " + responseFromService);
        return responseFromService;
    }

    public String compareNames(String first, String second, String third) {
        log.info("Compare: [{}, {}, {}]", first, second, third);
        String company = nameService.compare(first, second, third);
        log.info("Result of comparing: {}", company);
        return company;
    }

    private String convertType(ClientType clientType) {
        if (ClientType.COMPANY == clientType) {
            return "UL";
        }
        return "FL";
    }

    private List<String> createDocumentsList(String documentsList) {
        return Arrays.stream(documentsList.split(","))
                .collect(Collectors.toList());
    }
}
