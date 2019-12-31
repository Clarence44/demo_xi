package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class       ：HelloWorld
 *
 * @author ：MXXXL
 * @version ：1.0$
 * @date ：Created in 12/31/0031 22:12
 */
@RestController
public class HelloWorld {
    @GetMapping(value = "/hello")
    public String hello() {
        return "HelloWorld";
    }
}
