package com.chameleon.junit5mockito.service;

import com.chameleon.junit5mockito.db.DB;

import java.util.Map;

public interface DBService {

    boolean connect();

    boolean disconnect();

    Map<Integer, String> read();

    boolean write(Integer key, String value);

    boolean writeAll(Map<Integer, String> values);

    boolean clear();
}
