package com.bookstore.OnlineBookStore.service;

import com.bookstore.OnlineBookStore.model.Cart;
import com.bookstore.OnlineBookStore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUser(String email) {
        return cartRepository.findByUserEmail(email);
    }

    public void removeFromCart(String email, Long bookId) {
        cartRepository.deleteByUserEmailAndBookId(email, bookId);
    }

    public void clearCart(String email) {
        List<Cart> items = cartRepository.findByUserEmail(email);
        cartRepository.deleteAll(items);
    }
}
