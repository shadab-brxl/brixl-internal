package com.app.bxl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @GetMapping(path = "/api/ping")
    public ResponseEntity<String> sample() {
        System.out.println("Hello World1");
        log.info("Hello World1 - Info");
        return ResponseEntity.ok("pong");
    }
}