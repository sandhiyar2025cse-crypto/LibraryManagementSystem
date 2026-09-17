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

import com.example.model.author;
import com.example.services.authorservice;

@RestController
@RequestMapping("/authors")
public class authorController {

    private final authorservice service;

    public authorController(authorservice service) {
        this.service = service;
    }

    @GetMapping
    public List<author> getAllAuthors() {
        return service.getAllAuthors();
    }

    @PostMapping
    public author addAuthor(@RequestBody author author) {
        return service.addAuthor(author);
    }

    @GetMapping("/{id}")
    public author getAuthor(@PathVariable Long id) {
        return service.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public author updateAuthor(@PathVariable Long id,
                               @RequestBody author updatedAuthor) {
        return service.updateAuthor(id, updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        service.deleteAuthor(id);
        return "Author deleted successfully";
    }
}