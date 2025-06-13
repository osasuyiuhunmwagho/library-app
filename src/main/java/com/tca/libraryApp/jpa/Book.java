package com.tca.libraryApp.jpa;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// Entity class representing the Books table
@Entity
@Table(name = "books")
public class Book implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Primary key with auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    // Mandatory title
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    // Mandatory author
    @Column(name = "author", nullable = false, length = 100)
    private String author;

    // Mandatory ISBN with unique constraint
    @Column(name = "isbn", nullable = false, length = 13, unique = true)
    private String isbn;

    // Optional publication year
    @Column(name = "publication_year")
    private Integer publicationYear;

    // Default constructor for JPA
    public Book() {}

    // Constructor with mandatory fields
    public Book(String title, String author, String isbn, Integer publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
