package com.skorg.firstapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("healthCheck")
    public String healthCheck(){
        return "Health Check Passed and Okay!";
    }
}
