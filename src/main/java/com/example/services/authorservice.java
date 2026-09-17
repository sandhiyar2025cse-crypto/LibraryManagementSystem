package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.author;
import com.example.repository.authorrepository;

@Service
public class authorservice {

    private final authorrepository repository;

    public authorservice(authorrepository repository) {
        this.repository = repository;
    }

    public List<author> getAllAuthors() {
        return repository.findAll();
    }

    public author addAuthor(author author) {
        return repository.save(author);
    }

    public author getAuthorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public author updateAuthor(Long id, author updatedAuthor) {
        author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setCountry(updatedAuthor.getCountry());

        return repository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }

        repository.deleteById(id);
    }
}