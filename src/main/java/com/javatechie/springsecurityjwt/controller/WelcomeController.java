package com.javatechie.springsecurityjwt.controller;

import com.javatechie.springsecurityjwt.entity.dto.AuthRequest;
import com.javatechie.springsecurityjwt.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String welcome() {
        return "Welcome to Spring Boot App";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                    authRequest.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
