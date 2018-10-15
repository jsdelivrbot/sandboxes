package com.example.aws.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;

@RestController
public class MyController {

    private static Integer invocationCount = 0;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        val example = new ArrayList<Integer>();
        return "Hello, " + name + "!";
    }

    @RequestMapping("/count")
    public Integer count() {
        return ++invocationCount;
    }
}
