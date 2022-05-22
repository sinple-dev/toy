package com.example.toy.auth.controller;

import com.example.toy.common.Entity.User;
import com.example.toy.common.result.SuccessResult;
import com.example.toy.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/signup")
    public ResponseEntity<?> get() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securePassword = encoder.encode("1234");

        User user = new User();
        user.setEmail("asd@naver.com");
        user.setPassword(securePassword);
        user.setName("테스트");
        userRepository.save(user);


        SuccessResult result = new SuccessResult();
        result.put("total", "10000");
        result.setMessage("success");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}