package com.bookstore.OnlineBookStore.controller;

import com.bookstore.OnlineBookStore.model.User;
import com.bookstore.OnlineBookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user, @RequestParam String type) {
        try {
            User saved = userService.register(user, type);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User foundUser = userService.login(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
}
