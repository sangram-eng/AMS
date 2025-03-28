package com.ams.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ams.entity.Role;
import com.ams.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.time}")
    private long expirationTime;

    private Algorithm algorithm;

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(secretKey);
    }

    // Generate JWT Token
    public String generateToken(String username, String role) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(algorithm);
    }

    // Get username from token
    public String getUsernameFromToken(String token) {
        return decodeToken(token).getSubject();
    }

    // Get a specific claim from token
    public String getClaim(String token, String claim) {
        return decodeToken(token).getClaim(claim).asString();
    }

    // Validate the token
    public boolean validateToken(String token) {
        try {
            return !decodeToken(token).getExpiresAt().before(new Date());
        } catch (JWTVerificationException exception) {
            return false;
        }
    }

    // Decode and verify token
    private DecodedJWT decodeToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    // Authenticate user with token
    public void authenticateWithToken(String token) {
        if (validateToken(token)) {
            String username = getUsernameFromToken(token);
            String role = getClaim(token, "role");
    
            User user = new User(username, "", Role.valueOf(role.toUpperCase()));
    
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
    
}
