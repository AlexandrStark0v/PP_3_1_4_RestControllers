package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User findByUsername(String username);
    User updateUser(User user);
    User findByEmail(String email);

    User findById(Long id);
}
