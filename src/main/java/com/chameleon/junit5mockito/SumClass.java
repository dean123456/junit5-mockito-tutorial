package com.chameleon.junit5mockito;

public class SumClass {

    private int a;
    private int b;

    public SumClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

}
