package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.book;
import com.example.services.bookservice;

@RestController
@RequestMapping("/books")
public class BookController {

    private final bookservice service;

    public BookController(bookservice service) {
        this.service = service;
    }

    @GetMapping
    public List<book> getAllBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public book addBook(@RequestBody book book) {
        return service.addBook(book);
    }

    @GetMapping("/{id}")
    public book getBook(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public book updateBook(@PathVariable Long id,
                           @RequestBody book updatedBook) {
        return service.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted successfully";
    }
}