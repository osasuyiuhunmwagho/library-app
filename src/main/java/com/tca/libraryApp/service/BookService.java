package com.tca.libraryApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tca.libraryApp.jpa.Book;
import com.tca.libraryApp.repository.BookRepository;

// Service class for Book-related business logic
@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection for repository
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create a new book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    // Update an existing book
    public Book updateBook(Integer bookId, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(bookId);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setPublicationYear(updatedBook.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }

    // Delete a book
    public void deleteBook(Integer bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
        } else {
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
    }
}
