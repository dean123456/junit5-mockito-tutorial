package com.chameleon.junit5mockito.models;

import java.util.Objects;
import java.util.UUID;

public class RequestToService {
    private UUID requestId; // идентификатор запроса
    private ClientType clientType; // тип клиента (INDIVIDUAL - фл, COMPANY - юл)
    private String systemFrom; // система из которой поступил запрос
    private String clientId; // идентификатор клиента

    public RequestToService() {
    }

    public RequestToService(UUID requestId,
                            ClientType clientType,
                            String systemFrom,
                            String clientId) {
        this.requestId = requestId;
        this.clientType = clientType;
        this.systemFrom = systemFrom;
        this.clientId = clientId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getSystemFrom() {
        return systemFrom;
    }

    public void setSystemFrom(String systemFrom) {
        this.systemFrom = systemFrom;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestToService)) return false;
        RequestToService that = (RequestToService) o;
        return Objects.equals(getRequestId(), that.getRequestId()) && getClientType() == that.getClientType() && Objects.equals(getSystemFrom(), that.getSystemFrom()) && Objects.equals(getClientId(), that.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getClientType(), getSystemFrom(), getClientId());
    }

    @Override
    public String toString() {
        return "RequestToService{" +
                "requestId=" + requestId +
                ", clientType=" + clientType +
                ", systemFrom='" + systemFrom + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
