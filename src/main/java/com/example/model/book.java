package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class book {

    @Id
    @GeneratedValue
    private Long id;

    private String bookName;
    private double price;
    private String author;

    public book() {
    }

    public book(String bookName, double price, String author) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}