package com.chameleon.junit5mockito.service;

public class NameServiceImpl implements NameService{
    @Override
    public String getFio(String inn) {
        return "UNKNOWN";
    }

    @Override
    public String getCompanyName(String inn) {
        return "UNKNOWN";
    }

    @Override
    public String compare(String first, String second, String third) {
        return "UNKNOWN";
    }

    @Override
    public void notifyIfInnNull() {
        throw new RuntimeException("This method was not mocked");
    }
}
