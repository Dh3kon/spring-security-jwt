package com.javatechie.springsecurityjwt.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        String password = new BCryptPasswordEncoder().encode("1234");
        System.out.println(password);
    }
}
