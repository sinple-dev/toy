package com.example.toy.auth.security;

import com.example.toy.common.Entity.AuthToken;
import com.example.toy.common.Entity.User;
import com.example.toy.common.principal.UserPrincipal;
import com.example.toy.common.repository.AuthTokenRepository;
import com.example.toy.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenRepository authTokenRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("로그인 성공");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = userPrincipal.getUser();
        user.setUpdatedBy(user.getId());
        user.setUpdatedDt(new Date());
        userRepository.save(user);

        // 1. accessToken 검증
        // 2. accessToken 만료시 refreshToken 검증
        // 2-1. refreshToken 만료 안됬으면 accessToken 발급
        // 2-2. refreshToken 만료시 재발급
        String accessToken = TokenProvider.createAccessToken(user);
        String refreshToken = TokenProvider.createRefreshToken(user);
        AuthToken authToken = new AuthToken();
        authToken.setAccessToken(accessToken);
        authToken.setRefreshToken(refreshToken);
        authTokenRepository.save(authToken);

        response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + accessToken);
    }
}
