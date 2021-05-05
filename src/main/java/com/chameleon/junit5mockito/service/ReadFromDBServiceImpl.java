package com.chameleon.junit5mockito.service;

import java.util.Map;

public class ReadFromDBServiceImpl implements ReadFromDBService {

    private DBService dbService;

    public ReadFromDBServiceImpl(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public Map<Integer, String> readFromDB() {
        return dbService.read();
    }
}
