package com.example.intern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @GetMapping("/status/ping")
    public String displayPong() {
        return "Pong";
    }
}
