package com.sloboda.hibernateprobe;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProtoTest extends BaseTest {
    @Autowired
    private Single single;

    @Test
    public void name() {
        single.method();
        single.method();
    }
}
