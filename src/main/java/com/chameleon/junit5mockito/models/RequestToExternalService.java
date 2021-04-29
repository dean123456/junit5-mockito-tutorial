package com.chameleon.junit5mockito.models;

import java.util.Objects;

public class RequestToExternalService {
    private String requestId; // идентификатор запроса
    private String type; // тип клиента (INDIVIDUAL - фл, COMPANY - юл)
    private String from; // система из которой поступил запрос
    private String id; // идентификатор клиента
    private boolean flag; // логический признак

    public RequestToExternalService() {
    }

    public RequestToExternalService(String requestId,
                                    String type,
                                    String from,
                                    String id,
                                    boolean flag) {
        this.requestId = requestId;
        this.type = type;
        this.from = from;
        this.id = id;
        this.flag = flag;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestToExternalService)) return false;
        RequestToExternalService that = (RequestToExternalService) o;
        return getFlag() == that.getFlag() && Objects.equals(getRequestId(), that.getRequestId()) && Objects.equals(getType(), that.getType()) && Objects.equals(getFrom(), that.getFrom()) && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getType(), getFrom(), getId(), getFlag());
    }

    @Override
    public String toString() {
        return "RequestToExternalService{" +
                "requestId='" + requestId + '\'' +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", id='" + id + '\'' +
                ", flag=" + flag +
                '}';
    }
}
