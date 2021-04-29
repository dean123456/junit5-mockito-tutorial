package com.chameleon.junit5mockito.service;


import com.chameleon.junit5mockito.models.RequestToExternalService;
import com.chameleon.junit5mockito.models.RequestToService;
import com.chameleon.junit5mockito.models.ResponseFromExternalService;
import com.chameleon.junit5mockito.models.ResponseFromService;

public interface MappingService {
    RequestToExternalService mappingRequest(RequestToService request);

    ResponseFromService mappingResponse(ResponseFromExternalService response);
}
