package com.weber.cs3230.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @RequestMapping("/health")
    public String healthCheck() {
        return "Up and running!";
    }
}
