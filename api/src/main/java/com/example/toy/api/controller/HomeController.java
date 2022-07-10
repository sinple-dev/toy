package com.example.toy.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
public class HomeController {

    @GetMapping("")
    public String home() {
        System.out.println("들어왔다");
        return "Hello, Spring boot!";
    }






}
