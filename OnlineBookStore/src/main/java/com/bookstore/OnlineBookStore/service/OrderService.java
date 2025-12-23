package com.bookstore.OnlineBookStore.service;

import com.bookstore.OnlineBookStore.dto.OrderRequest;
import com.bookstore.OnlineBookStore.model.Book;
import com.bookstore.OnlineBookStore.model.Cart;
import com.bookstore.OnlineBookStore.model.Order;
import com.bookstore.OnlineBookStore.repository.BookRepository;
import com.bookstore.OnlineBookStore.repository.CartRepository;
import com.bookstore.OnlineBookStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.bookstore.OnlineBookStore.designpatterns.state.*;
import com.bookstore.OnlineBookStore.designpatterns.observer.*;
@Service
public class OrderService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public String placeOrder(OrderRequest req) {
        try {
            // Save one order for each item
            for (Cart c : req.getItems()) {

                // Create order entry
                Order order = new Order();
                order.setUserEmail(req.getUserEmail());
                order.setBookTitle(c.getTitle());
                order.setPrice(c.getPrice());
                order.setPaymentMethod(req.getPaymentMethod());
                order.setStatus("PLACED");
                orderRepository.save(order);

                // Reduce quantity
                Book book = bookRepository.findById(c.getBookId()).orElse(null);
                if (book != null && book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    bookRepository.save(book);
                }
            }

            // clear cart
            cartRepository.deleteByUserEmail(req.getUserEmail());

            return "Order placed successfully!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to place order!";
        }
    }

    public String updateOrderStatus(Long orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isEmpty()) {
            return "❌ Order not found!";
        }

        Order order = optionalOrder.get();

        // --- Apply State Pattern ---
        OrderContext context = new OrderContext();
        OrderState state;

        switch (status.toLowerCase()) {
            case "shipped":
                state = new ShippedOrderState();
                break;
            case "delivered":
                state = new DeliveredOrderState();
                break;
            case "cancelled":
                state = new CancelledState();
                break;
            default:
                state = new PlacedState();
        }

        context.setState(state);
        String message = context.applyState();

        order.setStatus(status.toUpperCase());
        orderRepository.save(order);

        // --- Observer Notification ---
        OrderNotificationManager notifier = new OrderNotificationManager();
        notifier.addObserver(new AdminObserver("admin@bookstore.com"));
        notifier.addObserver(new UserObserver(order.getUserEmail()));

        notifier.notifyObservers("Order ID " + orderId + " is now " + order.getStatus());

        return "✅ " + message + " (Order ID: " + orderId + ")";
    }

    public List<Order> getOrders(String email) {
        return orderRepository.findByUserEmail(email);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
