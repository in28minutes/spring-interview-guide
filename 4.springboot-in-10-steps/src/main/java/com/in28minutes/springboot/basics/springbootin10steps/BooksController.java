package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return List.of(new Book(1L, "Mastering Spring 5.2", "Ranga Karanam"));
    }
}