package com.bookstore.OnlineBookStore.controller;

import com.bookstore.OnlineBookStore.dto.OrderRequest;
import com.bookstore.OnlineBookStore.model.Order;
import com.bookstore.OnlineBookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // USER places order (Cart Checkout)
    @PostMapping("/place")
    public String placeOrder(@RequestBody OrderRequest request) {
        return orderService.placeOrder(request);
    }

    // USER order history
    @GetMapping("/{email}")
    public List<Order> getUserOrders(@PathVariable String email) {
        return orderService.getOrders(email);
    }

    // ADMIN: get all orders
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // ADMIN: update order status
    @PutMapping("/update-status/{id}")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

}
