package com.tca.libraryApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.libraryApp.jpa.User;
import com.tca.libraryApp.repository.UserRepository;

// Service class for User-related business logic
@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection for repository
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Update an existing user
    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    // Delete a user
    public void deleteUser(Integer userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}
