package com.tca.libraryApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tca.libraryApp.jpa.User;

import java.util.Optional;

// Repository interface for User entity
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom method to find a user by ID
    Optional<User> findById(Integer userId);
}
