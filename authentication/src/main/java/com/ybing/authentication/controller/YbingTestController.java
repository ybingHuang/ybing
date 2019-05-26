package com.ybing.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class YbingTestController {

    @GetMapping
    public String test() {
        return "hello world";
    }
}
