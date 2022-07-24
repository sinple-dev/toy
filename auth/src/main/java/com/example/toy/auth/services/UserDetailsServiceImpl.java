package com.example.toy.auth.services;

import com.example.toy.common.Entity.User;
import com.example.toy.auth.principal.UserPrincipal;
import com.example.toy.common.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new UserPrincipal(user);
    }
}
