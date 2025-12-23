package com.bookstore.OnlineBookStore.service;

import com.bookstore.OnlineBookStore.model.User;
import com.bookstore.OnlineBookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Register new user (Student or Admin)
    public User register(User user, String type) {
        // 1️⃣ Check if email already exists
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            throw new RuntimeException("Email already registered!");
        }

        // 2️⃣ Assign role based on type
        if (type.equalsIgnoreCase("ADMIN")) {
            user.setRole("ADMIN");
        } else {
            user.setRole("STUDENT");
        }

        // 3️⃣ Save new user
        return userRepository.save(user);
    }

    // ✅ Login verification
    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new RuntimeException("Invalid email or password!");
        }
        return user;
    }

    // ✅ Get all users (admin purpose)
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
