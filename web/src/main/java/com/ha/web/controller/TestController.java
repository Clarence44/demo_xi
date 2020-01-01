package com.ha.web.controller;

import com.ha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TestController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/about")
    public String about(){
        return userService.testService();
    }
    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
}
