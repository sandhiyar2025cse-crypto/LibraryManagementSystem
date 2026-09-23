package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.author;
import com.example.model.book;
import com.example.services.authorservice;
import com.example.services.bookservice;

@Controller
@RequestMapping("/books")
public class BookWebController {

    private final bookservice bookService;
    private final authorservice authorService;

    public BookWebController(
            bookservice bookService,
            authorservice authorService) {

        this.bookService = bookService;
        this.authorService = authorService;
    }

    // ADD BOOK
    @PostMapping("/save")
    public String saveBook(
            @RequestParam String bookName,
            @RequestParam Double price,
            @RequestParam Long authorId) {

        author author = authorService.getAuthorById(authorId);

        book newBook = new book();
        newBook.setBookName(bookName);
        newBook.setPrice(price);
        newBook.setAuthor(author);

        bookService.addBook(newBook);

        return "redirect:/#books";
    }

    // UPDATE BOOK
    @PostMapping("/update/{id}")
    public String updateBook(
            @PathVariable Long id,
            @RequestParam String bookName,
            @RequestParam Double price,
            @RequestParam Long authorId) {

        author author = authorService.getAuthorById(authorId);

        book updatedBook = new book();
        updatedBook.setBookName(bookName);
        updatedBook.setPrice(price);
        updatedBook.setAuthor(author);

        bookService.updateBook(id, updatedBook);

        return "redirect:/#books";
    }

    // DELETE BOOK
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return "redirect:/#books";
    }
}