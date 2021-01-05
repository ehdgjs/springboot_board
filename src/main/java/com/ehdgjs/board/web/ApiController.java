package com.ehdgjs.board.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }
}
