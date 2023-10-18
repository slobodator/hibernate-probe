package com.sloboda.hibernateprobe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Single {
    private final Proto proto;

    void method() {
        proto.method();
    }
}
