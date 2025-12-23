package com.bookstore.OnlineBookStore.controller;

import com.bookstore.OnlineBookStore.model.Book;
import com.bookstore.OnlineBookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // ✅ Add new book (admin)
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // ✅ View all books that are available (quantity > 0)
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .filter(b -> b.getQuantity() > 0)
                .toList();
    }
    // ✅ Decrease quantity when an order is placed
    @PutMapping("/decrease/{bookId}")
    public String decreaseQuantity(@PathVariable Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) return "❌ Book not found!";
        Book book = optionalBook.get();

        if (book.getQuantity() <= 0) {
            return "⚠️ Book out of stock!";
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        return "✅ Quantity updated. Remaining: " + book.getQuantity();
    }
}
