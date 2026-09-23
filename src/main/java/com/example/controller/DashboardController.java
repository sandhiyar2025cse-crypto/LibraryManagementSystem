package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.services.authorservice;
import com.example.services.bookservice;
import com.example.services.memberservice;

@Controller
public class DashboardController {

    private final bookservice bookService;
    private final authorservice authorService;
    private final memberservice memberService;

    public DashboardController(
            bookservice bookService,
            authorservice authorService,
            memberservice memberService) {

        this.bookService = bookService;
        this.authorService = authorService;
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute(
                "books",
                bookService.getAllBooks()
        );

        model.addAttribute(
                "authors",
                authorService.getAllAuthors()
        );

        model.addAttribute(
                "members",
                memberService.getAllMembers()
        );

        model.addAttribute(
                "bookCount",
                bookService.getAllBooks().size()
        );

        model.addAttribute(
                "authorCount",
                authorService.getAllAuthors().size()
        );

        model.addAttribute(
                "memberCount",
                memberService.getAllMembers().size()
        );

        return "library";
    }
}