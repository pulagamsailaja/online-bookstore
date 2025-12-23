package com.bookstore.OnlineBookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.OnlineBookStore.model.Book;
import java.util.Optional;
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
