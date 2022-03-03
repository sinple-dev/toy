package com.example.toy.api.Controller;

import com.example.toy.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.toy.common.utils.TestUtil;


@RestController
@RequestMapping("/api")
public class ApiController {


    @Autowired
    UserRepository userRepository;


    @RequestMapping("/home")
    public String home() {


        return TestUtil.test();

//        return "Hello, Spring boot!";
    }

}