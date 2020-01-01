package ha.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
}
