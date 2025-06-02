package com.foka.blog.controller;

import com.foka.blog.model.User;
import com.foka.blog.repository.UserRepository;
import com.foka.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Buscar todos os usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userService.getAllUsers();
    }

    // Buscar usuario por id
    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
