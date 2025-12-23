package com.bookstore.OnlineBookStore.controller;

import com.bookstore.OnlineBookStore.model.Cart;
import com.bookstore.OnlineBookStore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5500") // or * if you're testing locally
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // ✅ Add item to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        Cart savedCart = cartRepository.save(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    // ✅ Get all items for a user
    @GetMapping("/{email}")
    public ResponseEntity<List<Cart>> getCartByUser(@PathVariable String email) {
        List<Cart> cartItems = cartRepository.findByUserEmail(email);
        return ResponseEntity.ok(cartItems);
    }

    // ✅ Remove item from cart (FIXED)
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long id) {
        try {
            System.out.println("🗑️ Removing cart item ID: " + id);
            cartRepository.deleteById(id);
            return ResponseEntity.ok("Item removed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to remove item!");
        }
    }
}
