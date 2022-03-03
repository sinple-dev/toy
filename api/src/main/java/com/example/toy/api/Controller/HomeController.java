package com.example.toy.api.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.toy.common.utils.TestUtil;


@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home() {


        return TestUtil.test();

//        return "Hello, Spring boot!";
    }

}