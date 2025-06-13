package com.tca.libraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tca.libraryApp.jpa.Book;

import java.util.Optional;

// Repository interface for Book entity
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Custom method to find a book by ID
    Optional<Book> findById(Integer bookId);
}
