package com.example.toy.auth.config;

import com.example.toy.common.result.CustomException;
import com.example.toy.common.result.ErrorCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    
    //TODO : 에러코드 받아와서 처리
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        throw new CustomException(ErrorCode.BAD_REQUEST);
    }
}
