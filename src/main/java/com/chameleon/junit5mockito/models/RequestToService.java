package com.chameleon.junit5mockito.models;

import java.util.Objects;
import java.util.UUID;

public class RequestToService {
    private UUID requestId; // идентификатор запроса
    private ClientType clientType; // тип клиента (INDIVIDUAL - фл, COMPANY - юл)
    private String systemFrom; // система из которой поступил запрос
    private String clientId; // идентификатор клиента
    private String documents; // строка, содержащая список запрашиваемых документов, разделённых запятой

    public RequestToService() {
    }

    public RequestToService(UUID requestId,
                            ClientType clientType,
                            String systemFrom,
                            String clientId,
                            String documents) {
        this.requestId = requestId;
        this.clientType = clientType;
        this.systemFrom = systemFrom;
        this.clientId = clientId;
        this.documents = documents;
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

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestToService)) return false;
        RequestToService that = (RequestToService) o;
        return Objects.equals(getRequestId(), that.getRequestId()) && getClientType() == that.getClientType() && Objects.equals(getSystemFrom(), that.getSystemFrom()) && Objects.equals(getClientId(), that.getClientId()) && Objects.equals(getDocuments(), that.getDocuments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getClientType(), getSystemFrom(), getClientId(), getDocuments());
    }

    @Override
    public String toString() {
        return "RequestToService{" +
                "requestId=" + requestId +
                ", clientType=" + clientType +
                ", systemFrom='" + systemFrom + '\'' +
                ", clientId='" + clientId + '\'' +
                ", documents='" + documents + '\'' +
                '}';
    }
}
