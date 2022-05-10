package com.example.toy.auth.controller;

import com.example.toy.common.result.SuccessResult;
import com.example.toy.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/test")
    public ResponseEntity<?> get() {

        SuccessResult result = new SuccessResult();
        result.put("total", "10000");
        result.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



}