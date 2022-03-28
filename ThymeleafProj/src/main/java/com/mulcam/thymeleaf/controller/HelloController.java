package com.mulcam.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/gitTest")
    public String gitTest() {
    	return "test"; 
    }
}
