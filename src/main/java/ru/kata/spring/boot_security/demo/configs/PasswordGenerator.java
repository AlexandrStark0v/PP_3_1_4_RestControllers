package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPasswordAdmin = "admin";
        String rawPasswordUser = "user";

        String encodedAdmin = encoder.encode(rawPasswordAdmin);
        String encodedUser = encoder.encode(rawPasswordUser);

        System.out.println("admin = " + encodedAdmin);
        System.out.println("user  = " + encodedUser);
    }
}