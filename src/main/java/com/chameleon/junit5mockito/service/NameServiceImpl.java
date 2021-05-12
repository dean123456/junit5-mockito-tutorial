package com.chameleon.junit5mockito.service;

public class NameServiceImpl implements NameService{
    @Override
    public String getFio(String inn) {
        return null;
    }

    @Override
    public String getCompanyName(String inn) {
        return null;
    }

    @Override
    public String compare(String first, String second, String third) {
        return null;
    }

    @Override
    public void notifyIfInnNull() {
        throw new RuntimeException("Can't notify because have no any code");
    }
}
