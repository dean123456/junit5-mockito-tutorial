package com.chameleon.junit5mockito.models;


import java.util.Objects;

public class ResponseFromExternalService {
    private String requestId; // идентификатор запроса
    private String firstName; // имя
    private String lastName; // фамилия
    private String patronymic; // отчество
    private String companyName; // название компании

    public ResponseFromExternalService() {
    }

    public ResponseFromExternalService(String requestId,
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
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
        if (!(o instanceof ResponseFromExternalService)) return false;
        ResponseFromExternalService that = (ResponseFromExternalService) o;
        return Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getPatronymic(), that.getPatronymic()) && Objects.equals(getCompanyName(), that.getCompanyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getFirstName(), getLastName(), getPatronymic(), getCompanyName());
    }

    @Override
    public String toString() {
        return "ResponseFromExternalService{" +
                "requestId='" + requestId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
