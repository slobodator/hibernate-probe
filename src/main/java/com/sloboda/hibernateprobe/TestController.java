package com.sloboda.hibernateprobe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@Slf4j
public class TestController {
    @PostMapping
    public void post(@RequestBody IncomingRequest request) {
        log.info("request {} ", request);
        log.info("Classes are {} {} ", request.getStr().getClass(), request.getNumber().getClass());
    }
}
