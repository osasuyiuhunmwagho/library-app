package com.tca.libraryApp.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import com.tca.libraryApp.jpa.Book;
import com.tca.libraryApp.service.BookService;

// REST controller for Book-related endpoints
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor injection for service
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // Get book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        Optional<Book> book = bookService.getBookById(bookId);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a book
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(bookId, book));
    }

    // Delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
