package com.chameleon.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static org.junit.jupiter.api.condition.JRE.JAVA_8;

public class JRE {
    @Test
    @EnabledOnJre(JAVA_8)
    void onlyOnJava8() {
        // ...
    }
}
