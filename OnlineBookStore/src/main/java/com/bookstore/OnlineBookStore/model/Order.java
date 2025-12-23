package com.bookstore.OnlineBookStore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String bookTitle;
    private float price;
    private String paymentMethod;
    private String status; // Placed, Shipped, Delivered, Cancelled
}
