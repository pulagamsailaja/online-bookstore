package com.bookstore.OnlineBookStore.repository;

import com.bookstore.OnlineBookStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserEmail(String userEmail);
}
