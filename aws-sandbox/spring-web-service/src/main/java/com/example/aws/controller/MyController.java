package com.example.aws.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    private static Integer invocationCount = 0;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    
    @RequestMapping("/count")
    public Integer count() {
        return ++invocationCount;
    }
}
