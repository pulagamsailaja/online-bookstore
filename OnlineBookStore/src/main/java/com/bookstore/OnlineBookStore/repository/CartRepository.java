package com.bookstore.OnlineBookStore.repository;

import com.bookstore.OnlineBookStore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserEmail(String userEmail);

    @Transactional
    void deleteByUserEmail(String userEmail);

    @Transactional
    void deleteByUserEmailAndBookId(String userEmail, Long bookId);
}
