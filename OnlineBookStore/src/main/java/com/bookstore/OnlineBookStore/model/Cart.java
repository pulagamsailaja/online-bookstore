package com.bookstore.OnlineBookStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // Unique cart item ID (auto-generated)

    private String userEmail;   // The email of the user who added the book
    private Long bookId;        // The book's unique ID
    private String title;       // Book title
    private String author;      // Book author
    private float price;        // Book price
}
