package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.db.DB;

import java.util.Map;
import java.util.Optional;

public class DBServiceImpl implements DBService {

    private DB db;

    @Override
    public boolean connect() {
        db = DB.getDB();
        return db != null;
    }

    @Override
    public boolean disconnect() {
        db = null;
        return true;
    }

    @Override
    public Map<Integer, String> read() {
        return Optional.ofNullable(db)
                .map(v -> db.getTable())
                .orElseThrow(() -> new RuntimeException("Not connected to DB"));
    }

    @Override
    public boolean write(Integer key, String value) {
        return Optional.ofNullable(db)
                .map(v -> {
                    db.getTable().put(key, value);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("Not connected to DB"));
    }

    @Override
    public boolean writeAll(Map<Integer, String> values) {
        return Optional.ofNullable(db)
                .map(v -> {
                    db.getTable().putAll(values);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("Not connected to DB"));
    }

    @Override
    public boolean clear() {
        return Optional.ofNullable(db)
                .map(v -> {
                    db.getTable().clear();
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("Not connected to DB"));
    }
}
