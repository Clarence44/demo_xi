package com.ha.web.controller;

import com.ha.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TestController {
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/about")
    public String about() {
        return userService.testService();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
