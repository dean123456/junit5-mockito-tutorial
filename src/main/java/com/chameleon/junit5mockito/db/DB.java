package com.chameleon.junit5mockito.db;

import java.util.HashMap;
import java.util.Map;

public class DB {

    private static DB db;

    private Map<Integer, String> table;

    private DB() {
        table = new HashMap<>();
    }

    public static DB getDB() {
        if (db == null)
            db = new DB();
        return db;
    }

    public Map<Integer, String> getTable() {
        return table;
    }
}
