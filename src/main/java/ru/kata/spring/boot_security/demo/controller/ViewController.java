package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // имя файла admin-panel.html в templates
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; // user.html в папке templates
    }
}