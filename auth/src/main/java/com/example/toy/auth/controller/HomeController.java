package com.example.toy.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("")
    public String home() {
        System.out.println("들어왔다");
        return "Hello, AUTH 인증 해줘!";
    }

}
