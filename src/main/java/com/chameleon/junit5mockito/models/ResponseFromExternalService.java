package com.chameleon.junit5mockito.models;


import java.util.Objects;

public class ResponseFromExternalService {
    private String requestId; // идентификатор запроса
    private String inn; // ИНН

    public ResponseFromExternalService(String requestId,
                                       String inn) {
        this.requestId = requestId;
        this.inn = inn;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseFromExternalService)) return false;
        ResponseFromExternalService that = (ResponseFromExternalService) o;
        return Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getInn(), that.getInn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getInn());
    }

    @Override
    public String toString() {
        return "ResponseFromExternalService{" +
                "requestId='" + requestId + '\'' +
                ", inn='" + inn + '\'' +
                '}';
    }
}
