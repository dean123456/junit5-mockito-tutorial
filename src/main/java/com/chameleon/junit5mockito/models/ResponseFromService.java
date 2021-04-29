package com.chameleon.junit5mockito.models;

import java.util.Objects;
import java.util.UUID;

public class ResponseFromService {
    private UUID requestId; // идентификатор запроса
    private String firstName; // имя
    private String lastName; // фамилия
    private String patronymic; // отчество
    private String companyName; // название компании

    public ResponseFromService() {
    }

    public ResponseFromService(UUID requestId,
                               String firstName,
                               String lastName,
                               String patronymic,
                               String companyName) {
        this.requestId = requestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.companyName = companyName;
    }

    public ResponseFromService(UUID requestId,
                               String companyName) {
        this(requestId, null, null, null, companyName);
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
        return Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getPatronymic(), that.getPatronymic()) && Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getFirstName(), getLastName(), getPatronymic(), getCompanyName());
    }

    @Override
    public String toString() {
        return "ResponseFromService{" +
                "requestId=" + requestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
