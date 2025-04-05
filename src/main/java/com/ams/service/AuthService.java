package com.ams.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ams.entity.User;
import com.ams.entity.Role;
import com.ams.repository.UserRepository;
import com.ams.security.JwtTokenUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtUtils;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    // Register new user
    public String register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.USER); // Set default role
        }

        userRepository.save(user);
        return "User registered successfully.";
    }

    // Login and return username, role, and token
   // Login and return id, username, role, and token
public Map<String, String> login(String username, String password) {
    Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));

    if (userOptional.isEmpty() || !passwordEncoder.matches(password, userOptional.get().getPassword())) {
        throw new RuntimeException("Invalid username or password.");
    }

    User user = userOptional.get();
    String token = jwtUtils.generateToken(user.getUsername(), user.getRole().name());

    Map<String, String> response = new HashMap<>();
    response.put("id", String.valueOf(user.getId())); // Add ID to response
    response.put("username", user.getUsername());
    response.put("role", user.getRole().name());
    response.put("token", token);

    return response;
}

}
