package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping(value="/hello")
    public String hello() {
        return "helloWord";
    }

    @GetMapping(value="/asdf")
    public String asdf(){
        return "asdf";
    }

}