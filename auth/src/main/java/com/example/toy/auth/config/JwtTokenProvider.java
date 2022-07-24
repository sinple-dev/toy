package com.example.toy.auth.config;

import com.example.toy.auth.principal.UserPrincipal;
import com.example.toy.auth.services.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private String secretKey = "secret";

    private long tokenValidTime = 30 * 60 * 1000L;

    static final List AUTHORITIES = new ArrayList();
    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    public String createToken(UserPrincipal userPrincipal) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserPrincipal userPrincipal = userDetailsServiceImpl.loadUserByUsername(getUserId(token));
        return new UsernamePasswordAuthenticationToken(userPrincipal, "", AUTHORITIES);
    }

    public String getUserId(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(String authorization) {
        return authorization != null ? authorization.substring(7) : null;
    }

    public Boolean validateToken(HttpServletRequest request, String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            request.setAttribute("jwtException", "Invalid JWT signature");
        } catch (MalformedJwtException e) {
            request.setAttribute("jwtException", "Invalid JWT token");
        } catch (ExpiredJwtException e) {
            request.setAttribute("jwtException", "Expired JWT token");
        } catch (UnsupportedJwtException e) {
            request.setAttribute("jwtException", "Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            request.setAttribute("jwtException", "JWT claims string is empty.");
        }
        return false;
    }
}