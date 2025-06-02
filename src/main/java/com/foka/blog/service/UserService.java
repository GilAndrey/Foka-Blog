package com.foka.blog.service;

import com.foka.blog.model.User;
import com.foka.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Cadastro de Usuário
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use.");
        }
        return userRepository.save(user);
    }

    // Buscar usuário por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Buscar todos os usuários (ONLY ADMIN)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
