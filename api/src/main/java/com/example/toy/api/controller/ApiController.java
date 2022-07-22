package com.example.toy.api.controller;

import com.example.toy.api.service.ApiService;
import com.example.toy.common.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/test")
    public ResponseEntity<?> me()  {
        System.out.println("api test input");
        SuccessResult result = new SuccessResult();
        result.put("total", "10000");
        result.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



}