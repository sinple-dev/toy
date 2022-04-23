package com.example.toy.api.Controller;

import com.example.toy.common.model.result.SuccessResult;
import com.example.toy.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.toy.common.utils.TestUtil;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/test")
    public ResponseEntity<?> get() {

        System.out.println("testestset");
        SuccessResult result = new SuccessResult();
        result.put("total", "10000");
        result.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



}