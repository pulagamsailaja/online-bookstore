package com.bookstore.OnlineBookStore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;
    private String dept;
    private String year;

    // Factory pattern will set this
    private String role; // "STUDENT" or "ADMIN"
}
