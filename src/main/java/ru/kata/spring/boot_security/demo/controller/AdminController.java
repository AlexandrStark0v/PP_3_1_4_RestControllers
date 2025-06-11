package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String listUsers(Model model, Principal principal) {
        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index";
    }

    @GetMapping("/new")
    public String createUserFrom(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm (@PathVariable Long id, Model model) {

        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }




}
