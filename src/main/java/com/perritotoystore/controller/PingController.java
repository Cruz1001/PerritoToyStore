package com.perritotoystore.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Ping")
public class PingController {

    @GetMapping("/api/ping")
    public String ping() {
        return "pong";
    }
}