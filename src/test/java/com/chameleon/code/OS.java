package com.chameleon.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.condition.OS.MAC;

public class OS {
    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }
}
