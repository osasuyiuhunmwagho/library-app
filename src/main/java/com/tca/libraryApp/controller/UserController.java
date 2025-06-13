package com.tca.libraryApp.controller;

import com.tca.libraryApp.jpa.User;
import com.tca.libraryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REST controller for User-related endpoints
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection for service
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    // Delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
