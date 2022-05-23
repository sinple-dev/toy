package com.example.toy.common.repository;

import com.example.toy.common.Entity.AuthToken;
import com.example.toy.common.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    User findByAccessToken(@Param("accessToken") String accessToken);
}
