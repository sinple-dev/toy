package com.example.toy.api.service;

import com.example.toy.common.repository.UserRepository;
import com.example.toy.common.result.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApiService {

    private final UserRepository userRepository;


    public void apiTest() {

//        throw new CustomException("custom test", errorCode);

    }

}
