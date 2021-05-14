package com.chameleon.junit5mockito.models;

import java.util.Objects;
import java.util.UUID;

public class ResponseFromService {
    private UUID requestId; // идентификатор запроса
    private String fio; // ФИО
    private String companyName; // название компании

    public ResponseFromService() {
    }

    public ResponseFromService(UUID requestId,
                               String fio,
                               String companyName) {
        this.requestId = requestId;
        this.fio = fio;
        this.companyName = companyName;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseFromService)) return false;
        ResponseFromService that = (ResponseFromService) o;
        return Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getFio(), that.getFio()) && Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getFio(), getCompanyName());
    }

    @Override
    public String toString() {
        return "ResponseFromService{" +
                "requestId=" + requestId +
                ", fio='" + fio + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
