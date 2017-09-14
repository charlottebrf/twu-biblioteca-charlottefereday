package com.twu.biblioteca;

public class Book {
    private final String author;
    private final int year;
    public String title;

    public Book(String title, String author, int year) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public Book getBook(Book book) {
        return book;
    }
}
