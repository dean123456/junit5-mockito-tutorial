package com.chameleon.junit5mockito.service;

public interface NameService {

    String getFio(String inn);

    String getCompanyName(String inn);

    String compare(String first, String second, String third);

    void notifyIfInnNull();
}
